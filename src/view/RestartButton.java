package view;

import model.game.Game;

public class RestartButton extends SuperButton {

	public RestartButton(String s, Game g) {
		super(s, g);
		setActionCommand("restart");
		addActionListener(g.getCc());
	}
	

}
