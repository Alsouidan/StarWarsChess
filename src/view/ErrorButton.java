package view;

import model.game.Game;

public class ErrorButton extends SuperButton {

	public ErrorButton(String s, Game g) {
		super(s, g);
		setActionCommand("error");
		addActionListener(g.getCc());
	}

}
