package rechner;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StartFrame extends JFrame{
	Spieler[] spieler;
	int zahl;
	JTextField[] namen;
	
	StartFrame(){
		
	
	this.setLayout(new FlowLayout());
	this.setSize(300, 300);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JTextField anzahl = new JTextField(10);
	
	this.add(anzahl);
	JButton ok = new JButton("OK");
	this.add(ok);
	
	ok.addActionListener(e -> {zahl = Integer.parseInt(anzahl.getText());
	
	spieler = new Spieler[zahl];
	for(int i = 0; i< zahl; i++) {
		spieler[i] = new Spieler();
	}
	
	namen = new JTextField[zahl];
	for(int x=0; x<zahl; x++) {
		JLabel nameText = new JLabel("Gib deinen Namen ein: ");
		JTextField namenEingabe = new JTextField(15);
		namen[x] = namenEingabe;
		this.add(nameText);
		this.add(namenEingabe);
	}
	
	this.revalidate();
	this.repaint();
	
	
	});	
	
	

	
	
	
	JButton Start = new JButton("START");
	this.add(Start);
	Start.addActionListener(e -> {
		for(int y = 0; y<zahl; y++) {

		spieler[y].setName(namen[y].getText());
	}
		new MainFrame(spieler);});
	
	this.setVisible(true);
	
}

}