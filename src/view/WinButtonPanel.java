package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.game.Game;

public class WinButtonPanel extends JPanel {
public WinButtonPanel(Game g){
	setBorder(null);
	setOpaque(false);
	add(new RestartButton("Play Again?",g));
	add(new EndOk ("End",g));
	setBackground(Color.BLACK);
}
public Dimension getPreferredSize(){
	Dimension d= getParent().getSize();
	int w = d.width*20/100;
	int h = d.height*10/100;
	return new Dimension(w,h);
	
}
}
