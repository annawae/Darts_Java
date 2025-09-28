package rechner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class StartFrame extends JFrame{
	Spieler[] spieler;
	int zahl;
	JTextField[] namen;
	
	StartFrame(){
		
	this.setBackground(Color.DARK_GRAY);
	this.setLayout(new FlowLayout());
	this.setSize(240, 500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel spielerFrage = new JLabel ("Wie viele Spieler?");
	this.add(spielerFrage);
	spielerFrage.setFont(new Font("Arial", Font.BOLD, 16));
	spielerFrage.setForeground(Color.DARK_GRAY);
	
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
		MainFrame mainFrame = new MainFrame(spieler);
		mainFrame.getContentPane().setBackground(new Color(123, 142, 100));
	});
	
	Start.setBackground(new Color(145, 6, 31));
	Start.setPreferredSize(new Dimension(120,40));
	this.setVisible(true);
	
}

}