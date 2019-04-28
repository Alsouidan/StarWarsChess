package view;

import model.game.Game;

public class EndOk extends SuperButton{

	public EndOk(String s, Game g) {
		super(s, g);
		this.setActionCommand("end");
		this.addActionListener(g.getCc());
	}
	

}
