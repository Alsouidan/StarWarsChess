package model.pieces.heroes;

import exceptions.*;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Armored extends NonActivatablePowerHero {
private boolean armorUp;
public Armored (Player player, Game game, String name){
	super(player,game,name);
	armorUp=true;
}
public boolean isArmorUp() {
	return armorUp;
}
public void setArmorUp(boolean armorUp) {
	this.armorUp = armorUp;
}
public void move(Direction r) throws WrongTurnException, OccupiedCellException, UnallowedMovementException {
	if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
		throw new WrongTurnException("This is not your turn",this);
	switch(r){
		case UP:moveUp();break;
		case UPRIGHT:moveUpRight();break;
		case DOWN:moveDown();break;
		case DOWNRIGHT:moveDownRight();break;
		case DOWNLEFT:moveDownLeft();break;
		case RIGHT:moveRight();break;
		case UPLEFT:moveUpLeft();break;
		case LEFT:moveLeft();break;
		default: throw new UnallowedMovementException("Armored cannot move in this direction",this,r);
	}}
public String toString(){
	if(armorUp){
		return getName()+" ArmorUp";
	}
	return getName()+" ArmorDown";
}

}
