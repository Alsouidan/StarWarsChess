package view;

import java.awt.*;

import javax.swing.*;

import model.game.*;

public class GraveYardPanel extends JPanel {
public GraveYardPanel(Game g){
	JLabel jl=new JLabel ("Current Player's dead Pieces:");
	jl.setFont(new Font("Star Jedi",Font.PLAIN,11));jl.setForeground(Color.YELLOW);
	setSize(3000,1000);
	int dead=g.getCurrentPlayer().getDeadCharacters().size();
	setLayout(new GridLayout(1,dead+1));
	add(jl);
	setBackground(Color.BLACK);
	setVisible(true);
	for(int i=0;i<dead;i++){
		add(new DeadButton(g.getCurrentPlayer().getDeadCharacters().get(i), g));
	}
	
}
public void refresh(Game g){
	removeAll();
	revalidate();
	repaint();
	JLabel jl=new JLabel ("Current Player's dead Pieces:");
	jl.setFont(new Font("Star Jedi",Font.PLAIN,11));jl.setForeground(Color.YELLOW);
	add(jl);
	int dead=g.getCurrentPlayer().getDeadCharacters().size();
	for(int i=0;i<dead;i++){
		add(new DeadButton(g.getCurrentPlayer().getDeadCharacters().get(i), g));
	}
	revalidate();
	repaint();
}
public Dimension getPreferredSize(){
	Dimension d= getParent().getSize();
	int w = d.width*20/100;
	int h = d.height*2/100;
	return new Dimension(w,h);
	
}
}
