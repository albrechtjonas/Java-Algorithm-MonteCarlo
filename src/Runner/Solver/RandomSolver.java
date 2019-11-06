package Runner.Solver;

import Entity.Point;
import Main.Display;
import Runner.Runner;

public class RandomSolver extends Runner {
	
	private Thread thread;
	
	private final int rate=60;
	
	public RandomSolver(Display display) {
		super(display);
		
		thread=new Thread(this);
	}
	
	public synchronized void start() {
		thread.start();
	}
	
	@SuppressWarnings("deprecation")
	public synchronized void stop() {
		thread.stop();
	}
	
	public void run() {
		while(true) {	
			try {
				Thread.sleep(1);
			} catch (Exception exception) {}
			
			for(int i=0;i<rate;i++) {
				
				int pointX=(int)(Math.random()*display.getWidth());
				int pointY=(int)(Math.random()*display.getHeight());
				
				display.getRunState().addPoint(new Point(display,pointX,pointY));
			}
			
			if(display.getRunState().getPoints().size()%6000==0) {
				
				double ratio=(double)(display.getRunState().getInside())/display.getRunState().getPoints().size();
				
				double PI=ratio*display.getWidth()*display.getHeight()/Math.pow(display.getWidth()/2,2);
				
				System.out.println(PI);
				
			}
		}
	}
}
