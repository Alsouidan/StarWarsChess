package view;

import model.game.Game;

public class GotItButton extends SuperButton {

	public GotItButton(String s, Game g) {
		super(s, g);
		setActionCommand("gotit");
		addActionListener(g.getCc());
	}
	
}
