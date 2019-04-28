package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StartListener;

public class PlayerPanel extends JPanel {
	private	JTextField inp = new JTextField(20);
	private	JTextField inp1 = new JTextField(20);
	public JTextField getInp1() {
		return inp1;
	}

	public void setInp1(JTextField inp1) {
		this.inp1 = inp1;
	}

	public PlayerPanel(StartListener l,boolean firstTime){
		try {
			Fonts.font();
		} catch (FontFormatException | IOException e) {
		}
		inp.setSize(50,300);
		JLabel jl1=new JLabel ("Player 1");
		jl1.setFont(new Font("Star Jedi",Font.PLAIN,13));
		add(jl1);
		add(inp);
		setSize(1000,1000);
		setVisible(true);
		inp1.setSize(50,300);
		JLabel jl2= new JLabel ("Player 2");
		jl2.setFont(new Font("Star Jedi",Font.PLAIN,13));
		add(jl2);
		add(inp1);
		add(new PlayerOK ("OK",l,firstTime));
		revalidate();
		repaint();
	}
	
	public JTextField getInp() {
		return inp;
	}

	public void setInp(JTextField inp) {
		this.inp = inp;
	}
	
}
