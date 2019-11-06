package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Interface.Renderable;
import Main.Display;

public class Point extends Entity implements Renderable {
	
	public static final int radius=2;
	
	private Color color;
	
	public Point(Display display,int x,int y) {
		super(display,x,y);
		
		initialize();
	}
	
	private void initialize() {
		int centerX=display.getWidth()/2+display.getWidth()%2;
		int centerY=display.getHeight()/2+display.getHeight()%2;
		
		double xDistance=Math.pow(Math.abs(centerX-(x-radius/2)),2);
		double yDistance=Math.pow(Math.abs(centerY-(y-radius/2)),2);
		
		if(Math.sqrt(xDistance+yDistance)<display.getWidth()/2) {
			color=Color.BLUE;
			display.getRunState().setInSide(display.getRunState().getInside()+1);
		}else if(Math.sqrt(xDistance+yDistance)>display.getWidth()/2){
			color=Color.RED;
			display.getRunState().setOutSide(display.getRunState().getOutSide()+1);
		}else {
			display.getRunState().removePoint(this);
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillArc(x,y,radius,radius,0,360);
	}
}
