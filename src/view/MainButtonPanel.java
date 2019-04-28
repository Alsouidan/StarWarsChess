package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MainMenuListener;

public class MainButtonPanel extends JPanel {
	public MainButtonPanel(MainMenuListener mml){
		setLayout(new GridLayout(3,1));
		setBorder(null);
		setOpaque(false);
		JButton jb=new JButton();setBorder(null);
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setBorderPainted(false);
		add(new NewGameButton(mml));
		add(jb);
		add(new ExitButton(mml));
		
	}

}
