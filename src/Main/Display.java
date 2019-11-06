package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import Handler.ComponentActionHandler;
import State.RunState;
import State.State;

public class Display implements Runnable {
	
	private Thread thread;
	
	private Window window;
	
	private boolean running=false;
	
	private double tpt=1000000000/60;
	
	private BufferStrategy bs;
	
	private Graphics g;
	
	private ComponentActionHandler componentActionHandler;
	
	private RunState runState;
	
	public Display(Window window) {
		thread=new Thread(this);
		this.window=window;
		
		createHandler();
		
		createState();
	}
	
	private void createHandler() {
		window.getTextField().requestFocus();
		
		componentActionHandler=new ComponentActionHandler(this);
		window.getTextField().addActionListener(componentActionHandler);
	}
	
	private void createState() {
		runState=new RunState(this);
		
		State.setState(runState);
	}
	
	public synchronized void start() {
		running=true;
		thread.start();
	}
	
	@SuppressWarnings("deprecation")
	public synchronized void stop() {
		running=false;
		thread.stop();
	}
	
	public void run() {
		
		double runDelta=0;
		
		long last=System.nanoTime();
		
		long now;
		
		while(running) {
			now=System.nanoTime();
			
			runDelta+=(now-last)/tpt;
			last=now;
			
			if(runDelta>=1) {
				tick();
				render();
				runDelta--;
			}
		}
	}

	private void tick() {
		if(State.getState()==runState) {
			runState.tick();
		}
	}
	
	private void render() {
		
		bs=window.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		
		g.clearRect(0,0,getWidth(),getHeight());
		
		if(State.getState()==runState) {
			runState.render((Graphics2D)g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public Window getWindow() {
		return window;
	}
	
	public int getWidth() {
		return window.getWidth();
	}
	
	public int getHeight() {
		return window.getHeight();
	}
	
	public RunState getRunState() {
		return runState;
	}
}
