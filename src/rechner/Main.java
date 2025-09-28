package rechner;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		StartFrame startFrame = new StartFrame();
		
		startFrame.getContentPane().setBackground(new Color(123, 142, 100));
		
	}

}
