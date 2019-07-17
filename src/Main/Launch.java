package Main;

public class Launch {
	
	private final String title="MonteCarlo Simulation";
	
	private final int width=800;
	
	private final int height=800;
	
	public Window window;
	
	private Display display;
	
	private Launch() {
		window=new Window(title,width,height);
		display=new Display(window);
		display.start();
	}
	
	public static void main(String[]args) {
		new Launch();
	}
}
