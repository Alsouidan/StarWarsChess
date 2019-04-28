package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.game.Game;

public class BoardPanel extends JPanel {
private ArrayList <JButton> buttons;
public BoardPanel(Game g){
	setSize(700,700);
	buttons=new ArrayList();
	setLayout(new GridLayout (7,6));
	for(int i=0;i<7;i++){
		for(int j=0;j<6;j++){
			CellButton b=new CellButton (g.getCellAt(i, j), g,i,j);
			b.setPreferredSize(new Dimension(150,150));
			add(b);
			buttons.add(b);
		}
	}
}
public ArrayList<JButton> getButtons() {
	return buttons;
}
public void setButtons(ArrayList<JButton> buttons) {
	this.buttons = buttons;
}
public void refresh (Game g){
	removeAll();
	revalidate();
	repaint();
	setLayout(new GridLayout(7,6));
	for(int i=0;i<7;i++){
		for(int j=0;j<6;j++){
			CellButton b=new CellButton (g.getCellAt(i, j), g,i,j);
			add(b);buttons.add(b);
		}
	}
	revalidate();
	repaint();
}

}
