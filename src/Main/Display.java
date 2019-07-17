package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import Entity.Circle;
import Entity.Point;

public class Display implements Runnable {
	
	private Thread thread;
	
	private Window window;
	
	private boolean running=false;
	
	private double tpt=1000000000/60;
	
	private BufferStrategy bs;
	
	private Graphics g;
	
	private Circle circle;
	
	private ArrayList<Point> points=new ArrayList<Point>();
	
	private int inside;
	
	public Display(Window window) {
		
		thread=new Thread(this);
		
		this.window=window;
	}
	
	public synchronized void start() {
		running=true;
		thread.start();
		circle=new Circle(this,0,0,800,800);
	}
	
	public synchronized void stop() {
		running=false;
		System.exit(0);
	}
	
	public void run() {
		
		double delta=0;
		
		long last=System.nanoTime();
		
		long now;
		
		while(running) {
			
			now=System.nanoTime();
			
			delta+=(now-last)/tpt;
			
			last=now;
			
			if(delta>=1) {
				tick();
				render();
				delta--;
			}
		}
	}
	
	public void tick() {
		for(int i=0;i<points.size();i++) {
			points.get(i).tick();
		}
		
		int x=(int)(Math.random()*800);
		
		int y=(int)(Math.random()*800);
		points.add(new Point(this,x,y,2,2));
		
		if(points.size()%1000==0) {
			double per=800*800/points.size();
			
			double pi=per*inside/400/400;
			
			System.out.println(pi);
		}
	}
	
	public void render() {
		bs=window.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		
		g.clearRect(0,0,window.getWidth(),window.getHeight());
		
		circle.render((Graphics2D)g);
		
		for(int i=0;i<points.size();i++) {
			points.get(i).render((Graphics2D)g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void setInside(int inside) {
		this.inside=inside;
	}
	
	public int getInside() {
		return inside;
	}
}
