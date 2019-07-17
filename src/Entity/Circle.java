package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.Display;

public class Circle extends Entity {
	
	private Color color=Color.BLACK;
	
	public Circle(Display display,int x,int y,int width,int height) {
		super(display,x,y,width,height);
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.drawOval(x,y,width,height);
	}
	
}
