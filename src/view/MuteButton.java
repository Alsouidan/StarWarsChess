package view;

import model.game.Game;

public class MuteButton extends SuperButton {

	public MuteButton(String s, Game g) {
		super(s, g);
		setActionCommand("mute");
		addActionListener(g.getCc());
	}

}
