package model.pieces;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;

public interface Movable {
	public void move(Direction r) throws WrongTurnException, OccupiedCellException, UnallowedMovementException;
//not fully explained so i'll postpone to later 
//	public void moveUp();
//	public void moveDown();
//	public void moveLeft();
//	public void moveRight();
//	public void moveUpRight();
//	public void moveUpLeft();
//	public void moveDownRight();
//	public void moveDownLeft();
}
