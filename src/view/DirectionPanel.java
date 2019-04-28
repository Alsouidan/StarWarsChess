package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.game.Direction;
import model.game.Game;

public class DirectionPanel extends JPanel {
public DirectionPanel (Game g){
	setLayout(new GridLayout (3,3));
	DirectionButton dbU=new DirectionButton(Direction.UP,g);
	DirectionButton dbUR=new DirectionButton(Direction.UPRIGHT,g);
	DirectionButton dbUL=new DirectionButton(Direction.UPLEFT,g);
	DirectionButton dbD=new DirectionButton(Direction.DOWN,g);
	DirectionButton dbDR=new DirectionButton(Direction.DOWNRIGHT,g);
	DirectionButton dbDL=new DirectionButton(Direction.DOWNLEFT,g);
	DirectionButton dbL=new DirectionButton(Direction.LEFT,g);
	DirectionButton dbR=new DirectionButton(Direction.RIGHT,g);
	add(dbUL);
	add(dbU);
	add(dbUR);
	add(dbL);
	add(new PowerButton("Use Power",g));
	add(dbR);
	add(dbDL);
	add(dbD);
	add(dbDR);
}

public Dimension getPreferredSize(){
	Dimension d= getParent().getSize();
	int w = d.width*20/100;
	int h = d.height*20/100;
	return new Dimension(w,h);
	
}
}
