package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.game.Game;

public class ErrorFrame extends JFrame {
public ErrorFrame(Exception e,Game g){
	try {
		Fonts.font();
	} catch (FontFormatException | IOException e1) {
		
	
	}
	setSize(600,200);
	setLayout(new BorderLayout());
	JLabel jl=new JLabel(e.getMessage());
	jl.setFont(new Font("Star Jedi",Font.PLAIN,15));
	jl.setForeground(Color.YELLOW);
	add(jl,BorderLayout.CENTER);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	add(new ErrorButton("OK", g),BorderLayout.SOUTH);
	this.getContentPane().setBackground(Color.BLACK);
	revalidate();
	repaint();
}

}
