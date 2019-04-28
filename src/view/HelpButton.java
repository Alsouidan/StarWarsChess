package view;
import javax.swing.JButton;

import model.game.Game;

public class HelpButton extends SuperButton {

	public HelpButton(String s, Game g) {
		super(s, g);
		setActionCommand("help");
		addActionListener(g.getCc());
	}

}
