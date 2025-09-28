package rechner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	int tempPunkte = 0;
	JLabel Punkte[];
	JButton[] btn = new JButton[20];
	int currentPlayer = 0;
	
	
	
	MainFrame(Spieler[] spieler){
		
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	this.setSize(600,1000);
	this.setVisible(true);
	this.setLayout(new FlowLayout());
	
	
	//JPanel für die Spieler erstellen und hinzufügen:
	JPanel spielerAnzeige = new JPanel(); 

	this.add(spielerAnzeige);
	spielerAnzeige.setLayout(new BoxLayout(spielerAnzeige, BoxLayout.Y_AXIS));
	spielerAnzeige.setBackground(new Color(123, 142, 100));
	Punkte = new JLabel[spieler.length];
	
	//Anzeige für vorhandene Spieler und deren Punkte anlegen:
	for(int i = 0; i<spieler.length; i++) {
		spieler[i].setPunkte(301);
		JLabel SpielerName = new JLabel("Spieler: " + spieler[i].getName());
		spielerAnzeige.add(SpielerName);
		Punkte[i] = new JLabel("Punktestand von " +spieler[i].getName() + ": " +spieler[i].getPunkte());
		spielerAnzeige.add(Punkte[i]);
		
	}
	
	//Buttons in eigenem JPanel mit eigenem Layout anlegen:
	JPanel Buttons = new JPanel();
	this.add(Buttons);
	Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.Y_AXIS));
	Buttons.setBackground(new Color(123, 142, 100));
	
	btn[0] = new JButton ("1");
	btn[1] = new JButton ("2");
	btn[2] = new JButton ("3");
	btn[3] = new JButton ("4");
	btn[4] = new JButton ("5");
	btn[5] = new JButton ("6");
	btn[6] = new JButton ("7");
	btn[7] = new JButton ("8");
	btn[8] = new JButton ("9");
	btn[9] = new JButton ("10");
	btn[10] = new JButton ("11");
	btn[11] = new JButton ("12");
	btn[12] = new JButton ("13");
	btn[13] = new JButton ("14");
	btn[14] = new JButton ("15");
	btn[15] = new JButton ("16");
	btn[16] = new JButton ("17");
	btn[17] = new JButton ("18");
	btn[18] = new JButton ("19");
	btn[19] = new JButton ("20");
	
	//Buttons anzeigen lassen:
	for(int i=0; i<=19; i++) {
		Buttons.add(btn[i]);
		btn[i].setBackground(new Color(66, 135, 245));
		btn[i].setPreferredSize(new Dimension(60, 40));
		btn[i].setMaximumSize(new Dimension(60, 40));
		btn[i].setMinimumSize(new Dimension(60, 40));
	}
	
	JPanel doubleTriple = new JPanel();
	this.add(doubleTriple);
	JButton doub = new JButton("double");
	JButton trip = new JButton("triple");
	
	doubleTriple.add(doub);
	doubleTriple.add(trip);
	
	
	//JPanel für die aktuell geworfenen Punkte anlegen:
	JPanel aktuellePunkte = new JPanel();
	this.add(aktuellePunkte);
	aktuellePunkte.setBackground(new Color(123, 142, 100));
	
	JLabel aktPunkte = new JLabel("geworfene Punkte: ");
	aktuellePunkte.add(aktPunkte);
	
	JButton zugEnde = new JButton("Zug beenden");
	aktuellePunkte.add(zugEnde);
	

	
	for(int y=0; y<btn.length; y++) {
		int index = y;
		btn[y].addActionListener(e -> {
			tempPunkte += index+1;
			aktPunkte.setText("geworfene Punkte: " + tempPunkte);
		});
	}
	
	//Zug beenden, Punkte übertragen und anzeigen:
	zugEnde.addActionListener(e -> {
		 
			spieler[currentPlayer].setPunkte(spieler[currentPlayer].getPunkte()-tempPunkte);
			tempPunkte = 0;
			aktPunkte.setText("geworfene Punkte: " + tempPunkte);
			Punkte[currentPlayer].setText("Punktestand von " +spieler[currentPlayer].getName() + ": " +spieler[currentPlayer].getPunkte());
			if(currentPlayer <spieler.length-1) {
				currentPlayer++;
			}
			else {
				currentPlayer = 0;
			}
	});
	



	
	
	this.setVisible(true);
	}

	
}
