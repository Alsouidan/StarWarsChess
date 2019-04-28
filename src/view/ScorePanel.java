package view;

import java.awt.*;

import javax.swing.*;

import model.game.Game;

public class ScorePanel extends JPanel {
public ScorePanel(Game g){
	setSize(500,200);
	setLayout(new GridLayout(4,2));
	JLabel jl2=new JLabel("Pay Loads:");
	JLabel jl3=new JLabel("");
	JLabel jl4=new JLabel(g.getPlayer1()+":"+g.getPlayer1().getPayloadPos());
	JLabel jl5=new JLabel(g.getPlayer2()+":"+g.getPlayer2().getPayloadPos());
	JLabel jl6=new JLabel("SideKicks Killed:");
	JLabel jl7=new JLabel("");
	JLabel jl8=new JLabel(g.getPlayer1()+":"+g.getPlayer1().getSideKilled());
	JLabel jl9=new JLabel(g.getPlayer2()+":"+g.getPlayer2().getSideKilled());
	jl2.setFont(new Font("Star Jedi",Font.PLAIN,14));jl2.setForeground(Color.YELLOW);
	jl3.setFont(new Font("Star Jedi",Font.PLAIN,12));jl3.setForeground(Color.YELLOW);
	jl4.setFont(new Font("Star Jedi",Font.PLAIN,12));jl4.setForeground(Color.YELLOW);
	jl5.setFont(new Font("Star Jedi",Font.PLAIN,12));jl5.setForeground(Color.YELLOW);
	jl6.setFont(new Font("Star Jedi",Font.PLAIN,12));jl6.setForeground(Color.YELLOW);
	jl7.setFont(new Font("Star Jedi",Font.PLAIN,12));jl7.setForeground(Color.YELLOW);
	jl8.setFont(new Font("Star Jedi",Font.PLAIN,12));jl8.setForeground(Color.YELLOW);
	jl9.setFont(new Font("Star Jedi",Font.PLAIN,12));jl9.setForeground(Color.YELLOW);
	add(jl2);
	add(jl3);
	add(jl4);
	add(jl5);
	add(jl6);
	add(jl7);
	add(jl8);
	add(jl9);
	setVisible(true);
	this.setBackground(Color.BLACK);
	
	
}
public void refresh(Game g){
	removeAll();
	revalidate();
	repaint();
	JLabel jl2=new JLabel("Pay Loads:");
	JLabel jl3=new JLabel("");
	JLabel jl4=new JLabel(g.getPlayer1()+":"+g.getPlayer1().getPayloadPos());
	JLabel jl5=new JLabel(g.getPlayer2()+":"+g.getPlayer2().getPayloadPos());
	JLabel jl6=new JLabel("SideKicks Killed:");
	JLabel jl7=new JLabel("");
	JLabel jl8=new JLabel(g.getPlayer1()+":"+g.getPlayer1().getSideKilled());
	JLabel jl9=new JLabel(g.getPlayer2()+":"+g.getPlayer2().getSideKilled());
	jl2.setFont(new Font("Star Jedi",Font.PLAIN,14));jl2.setForeground(Color.YELLOW);
	jl3.setFont(new Font("Star Jedi",Font.PLAIN,12));jl3.setForeground(Color.YELLOW);
	jl4.setFont(new Font("Star Jedi",Font.PLAIN,12));jl4.setForeground(Color.YELLOW);
	jl5.setFont(new Font("Star Jedi",Font.PLAIN,12));jl5.setForeground(Color.YELLOW);
	jl6.setFont(new Font("Star Jedi",Font.PLAIN,12));jl6.setForeground(Color.YELLOW);
	jl7.setFont(new Font("Star Jedi",Font.PLAIN,12));jl7.setForeground(Color.YELLOW);
	jl8.setFont(new Font("Star Jedi",Font.PLAIN,12));jl8.setForeground(Color.YELLOW);
	jl9.setFont(new Font("Star Jedi",Font.PLAIN,12));jl9.setForeground(Color.YELLOW);
	add(jl2);
	add(jl3);
	add(jl4);
	add(jl5);
	add(jl6);
	add(jl7);
	add(jl8);
	add(jl9);
	revalidate();
	repaint();
}
public Dimension getPreferredSize(){
	Dimension d= getParent().getSize();
	int w = d.width*20/100;
	int h = d.height*10/100;
	return new Dimension(w,h);
	
}
}
