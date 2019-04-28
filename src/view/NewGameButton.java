package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.MainMenuListener;

public class NewGameButton extends JButton {

	public  NewGameButton(MainMenuListener mml){
		super("");
		setActionCommand("newgame");
		setBorder(null);
		setOpaque(false);
		setContentAreaFilled(false);
		setImage();
		setBorderPainted(false);
		addActionListener(mml);
	}
	
	private void setImage() {
		ImageIcon ii=null;
		try{
			ii = new ImageIcon(getClass().getResource("/GUI/newgame.png"));}
			catch(NullPointerException e){
				}
		super.setIcon(ii);
		
	}
}
