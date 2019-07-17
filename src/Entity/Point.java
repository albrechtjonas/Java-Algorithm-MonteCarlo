package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.Display;

public class Point extends Entity {
	
	private Color color=Color.BLACK;
	
	private boolean checked=false;
	
	public Point(Display display,int x,int y,int width,int height) {
		super(display,x,y,width,height);
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public void tick() {
		
		if(!checked) {
			int xDistance=Math.abs(x+width/2-400);
		
			int yDistance=Math.abs(y+height/2-400);
		
			double distance=Math.sqrt(xDistance*xDistance+yDistance*yDistance);
		
			if(distance<400) {
				color=Color.RED;
				display.setInside(display.getInside()+1);
			}
			
			checked=true;
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x,y,width,height);
	}
}
