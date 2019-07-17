package Entity;

import java.awt.Graphics2D;

import Main.Display;

public abstract class Entity {
	protected Display display;
	
	protected int x;
	
	protected int y;
	
	protected int width;
	
	protected int height;
	
	public Entity(Display display,int x,int y,int width,int height) {
		this.display=display;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}	
