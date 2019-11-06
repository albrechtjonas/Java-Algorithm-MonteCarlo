package Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Main.Display;

public class ComponentActionHandler implements ActionListener {
	
	private Display display;
	
	public ComponentActionHandler(Display display) {
		this.display=display;
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		JTextField textField=display.getWindow().getTextField();
		
		if(textField.getText().equals("solve")) {
			display.getRunState().startRandomSolving();
			display.getWindow().getTextField().setText("");
		}else if(textField.getText().equals("reset")) {
			display.getRunState().reset();
			display.getWindow().getTextField().setText("");
		}else {
			JOptionPane.showMessageDialog(display.getWindow().getFrame(),"Unknown Command");
			display.getWindow().getTextField().setText("");
		}
	}
}
