package State;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Entity.Point;
import Main.Display;
import Runner.Solver.RandomSolver;

public class RunState extends State {
	
	private ArrayList<Point> points=new ArrayList<Point>();
	
	private int outside;
	
	private int inside;
	
	private RandomSolver randomSolver;
	
	public RunState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		points=new ArrayList<Point>();
		
		outside=0;
		
		inside=0;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics2D g) {
		g.drawArc(0,0,display.getWidth(),display.getHeight(),0,360);
		
		for(int i=0;i<points.size();i++) {
			points.get(i).render(g);
		}
	}
	
	public void startRandomSolving() {
		randomSolver=new RandomSolver(display);
		randomSolver.start();
	}
	
	public void reset() {
		createObject();
		
		if(randomSolver!=null) {
			randomSolver.stop();
			randomSolver=null;
		}
		System.out.println("************* Trial End *************");
	}
	
	public ArrayList<Point> getPoints() {
		return points;
	}
	
	public void addPoint(Point point) {
		points.add(point);
	}
	
	public void removePoint(Point point) {
		points.remove(point);
	}
	
	public void setOutSide(int outside) {
		this.outside=outside;
	}
	
	public int getOutSide() {
		return outside;
	}
	
	public void setInSide(int inside) {
		this.inside=inside;
	}
	
	public int getInside() {
		return inside;
	}
}	
