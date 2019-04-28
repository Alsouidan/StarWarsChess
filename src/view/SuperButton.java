package view;

import javax.swing.*;

import model.game.*;

public class SuperButton extends JButton {
private Game game;

public SuperButton (String s, Game g){
	super(s);
	game=g;
}
public Game getGame() {
	return game;
}

public void setGame(Game game) {
	this.game = game;
}


}
