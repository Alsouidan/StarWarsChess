package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.game.Game;
import model.game.Player;

public class WinningPanel extends JFrame {
public WinningPanel(Game g){
	try {
		Fonts.font();
	} catch (FontFormatException | IOException e) {
	}
	setSize(1000,500);
	setResizable(false);
	setTitle("You Won");
	JLabel jl1=new JLabel(new ImageIcon("background1.jpg"));
	Player winner=g.getCurrentPlayer().equals(g.getPlayer1())?g.getPlayer2():g.getPlayer1();
	JLabel jl=new JLabel("                 "+winner+" has ruled the galaxy !!!");
	jl.setFont(new Font("Star Jedi",Font.PLAIN,30));jl.setForeground(Color.YELLOW);
	setLocationRelativeTo(null);
	setContentPane(jl1);
	jl1.setLayout(new BorderLayout());
	jl1.add(jl,BorderLayout.CENTER);
	jl1.add(new WinButtonPanel(g),BorderLayout.SOUTH);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setVisible(true);
	revalidate();
	repaint();
	
}


}
