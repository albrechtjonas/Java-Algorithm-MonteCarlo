package Main;

public class MonteCarlo {
	
	private final String title="Monte Carlo";
	
	private final int width=801;
	
	private final int height=801;
	
	public Window window;
	
	private Display display;
	
	public static void main(String[]args) {
		new MonteCarlo();
	}
	
	private MonteCarlo() {
		window=new Window(title,width,height);
		
		display=new Display(window);
		
		display.start();
	}
}
