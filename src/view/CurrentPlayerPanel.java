package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.*;

import model.game.*;

public class CurrentPlayerPanel extends JPanel {
public CurrentPlayerPanel(Game g){
	setSize(3000,500);
	setVisible(true);
	String s= (g.getCc().isUsePower())?"You are now using a power":"You are now Moving";
	JLabel jl=new JLabel("         it is ");
	JLabel jl1=new JLabel(g.getCurrentPlayer()+"");
	if((g.getCurrentPlayer().equals(g.getPlayer1()))){
		jl1.setForeground(Color.BLUE);	
	}else
		jl1.setForeground(Color.RED);
	JLabel jl2=new JLabel ("'s turn     "+s);
	jl.setFont(new Font("Star Jedi",Font.PLAIN,30));
	jl1.setFont(new Font("Star Jedi",Font.PLAIN,30));
	jl2.setFont(new Font("Star Jedi",Font.PLAIN,30));
	jl.setSize(3000,500);
	jl.setForeground(Color.YELLOW);jl2.setForeground(Color.YELLOW);
	setBackground(Color.BLACK);
	add(new HelpButton("Help!",g));
	if(!g.getCc().isMute()){
		add(new MuteButton("Mute",g));
	}else{
		add(new MuteButton("Unmute",g));
	}
	add(jl);add(jl1);add(jl2);
}

public void refresh(Game g) {
	try {
		Fonts.font();
	} catch (FontFormatException | IOException e) {
	}
	removeAll();
	revalidate();
	repaint();
	String s= (g.getCc().isUsePower())?"You are now using a power":"You are now Moving";
	JLabel jl=new JLabel("         it is ");
	JLabel jl1=new JLabel(g.getCurrentPlayer()+"");
	if((g.getCurrentPlayer().equals(g.getPlayer1()))){
		jl1.setForeground(Color.BLUE);	
	}else
		jl1.setForeground(Color.RED);
	JLabel jl2=new JLabel ("'s turn     "+s);
	jl.setFont(new Font("Star Jedi",Font.PLAIN,30));
	jl1.setFont(new Font("Star Jedi",Font.PLAIN,30));
	jl2.setFont(new Font("Star Jedi",Font.PLAIN,30));
	jl.setSize(3000,500);
	jl.setForeground(Color.YELLOW);jl2.setForeground(Color.YELLOW);
	setBackground(Color.BLACK);
	add(new HelpButton("Help!",g));
	if(!g.getCc().isMute()){
		add(new MuteButton("Mute",g));
	}else{
		MuteButton mb=new MuteButton("Unmute",g);mb.setActionCommand("unmute");
		add(mb);
	}
	add(jl);add(jl1);add(jl2);
	
	revalidate();
	repaint();
	
}
}
