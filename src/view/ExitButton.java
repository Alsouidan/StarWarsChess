package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.MainMenuListener;

public class ExitButton extends JButton {
public ExitButton(MainMenuListener mml){
	super("");
	setActionCommand("exit");
	setBorder(null);
	setOpaque(false);
	setContentAreaFilled(false);
	setBorderPainted(false);
	setImage();
	addActionListener(mml);
}

private void setImage() {
	ImageIcon ii=null;
	try{
		ii = new ImageIcon(getClass().getResource("/GUI/exit.png"));}
		catch(NullPointerException e){
			}
	super.setIcon(ii);
	
}
}
