package model.pieces.heroes;

import exceptions.GameActionException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Speedster extends NonActivatablePowerHero {
public Speedster(Player player, Game game, String name){
super (player, game, name);
	}

public void move(Direction r) throws WrongTurnException, OccupiedCellException, UnallowedMovementException{//Check throw statement
	if(!(getGame().getCurrentPlayer().equals(this.getOwner()))){
		throw new WrongTurnException("This is not your turn",this);}

	switch(r){
		case UP:moveUp();break;
		case UPRIGHT:moveUpRight();break;
		case DOWN:moveDown();break;
		case DOWNRIGHT:moveDownRight();break;
		case DOWNLEFT:moveDownLeft();break;
		case RIGHT:moveRight();break;
		case UPLEFT:moveUpLeft();break;
		case LEFT:moveLeft();break;
		default: throw new UnallowedMovementException("Speedster cannot move in this direction",this,r);}
	getGame().getCc().whoosh();
	}

public void moveDown() throws OccupiedCellException, WrongTurnException{
int j= this.getPosJ();
int i=this.getPosI();
int ni=(i+1==this.getGame().getBoardHeight())?1:(i+2==this.getGame().getBoardHeight())?0:i+2;
boolean istarget=this.getGame().getCellAt(ni, j).getPiece()!=null;
if(istarget && getGame().getCellAt(ni, j).getPiece().getOwner().equals(this.getOwner())){
throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.DOWN);	
}
if(istarget && (getGame().getCellAt(ni, j).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(ni, j).getPiece()).isArmorUp()){
	attack(getGame().getCellAt(ni, j).getPiece());
}else{if(istarget){
	attack(getGame().getCellAt(ni, j).getPiece());}
getGame().getCellAt(ni, j).setPiece(this); this.setPosI(ni);
getGame().getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveUp() throws OccupiedCellException, WrongTurnException{
	int j= this.getPosJ();
	int i=this.getPosI();
	int ni=(i==0)?5:(i-1==0)?6:i-2;
	boolean istarget=this.getGame().getCellAt(ni, j).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, j).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.UP);	
		}
	if(istarget && (getGame().getCellAt(ni, j).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(ni, j).getPiece()).isArmorUp()){
		attack(getGame().getCellAt(ni, j).getPiece());
	}else{if(istarget){
		attack(getGame().getCellAt(ni, j).getPiece());}
	getGame().getCellAt(ni, j).setPiece(this); this.setPosI(ni);
	getGame().getCellAt(i, j).setPiece(null);}	this.getGame().switchTurns();}
public void moveRight() throws OccupiedCellException, WrongTurnException{
	int j= this.getPosJ();
	int i=this.getPosI();
	int nj=(j+1==this.getGame().getBoardWidth())?1:(j+2==this.getGame().getBoardWidth())?0:j+2;
	boolean istarget=this.getGame().getCellAt(i, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(i, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.RIGHT);	
		}
	if(istarget && (getGame().getCellAt(i, nj).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(i, nj).getPiece()).isArmorUp()){
		attack(getGame().getCellAt(i, nj).getPiece());
	}else{if(istarget){
		attack(getGame().getCellAt(i, nj).getPiece());}
	getGame().getCellAt(i, nj).setPiece(this); this.setPosJ(nj);
	getGame().getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveLeft() throws OccupiedCellException, WrongTurnException{
	int j= this.getPosJ();
	int i=this.getPosI();
	int nj=(j==0)?4:(j-1==0)?5:j-2;
	boolean istarget=this.getGame().getCellAt(i, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(i, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.LEFT);	
		}
	if(istarget && (getGame().getCellAt(i, nj).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(i, nj).getPiece()).isArmorUp()){
		attack(getGame().getCellAt(i, nj).getPiece());
	}else{if(istarget){
		attack(getGame().getCellAt(i, nj).getPiece());}
	getGame().getCellAt(i, nj).setPiece(this); this.setPosJ(nj);
	getGame().getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveUpLeft() throws OccupiedCellException, WrongTurnException{
	int j= this.getPosJ();
	int i=this.getPosI();
	int nj=(j==0)?4:(j-1==0)?5:j-2;
	int ni=(i==0)?5:(i-1==0)?6:i-2;
	boolean istarget=this.getGame().getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.UPLEFT);	
		}
	if(istarget && (getGame().getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(getGame().getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(getGame().getCellAt(ni, nj).getPiece());}
	getGame().getCellAt(ni, nj).setPiece(this); this.setPosJ(nj);this.setPosI(ni);
	getGame().getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveDownLeft() throws OccupiedCellException, WrongTurnException{
	int j= this.getPosJ();
	int i=this.getPosI();
	int nj=(j==0)?4:(j-1==0)?5:j-2;
	int ni=(i+1==this.getGame().getBoardHeight())?1:(i+2==this.getGame().getBoardHeight())?0:i+2;
	boolean istarget=this.getGame().getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.DOWNLEFT);	
		}
	if(istarget && (getGame().getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(getGame().getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(getGame().getCellAt(ni, nj).getPiece());}
	getGame().getCellAt(ni, nj).setPiece(this); this.setPosJ(nj);this.setPosI(ni);

	getGame().getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveDownRight() throws OccupiedCellException, WrongTurnException{
	int j= this.getPosJ();
	int i=this.getPosI();
	int nj=(j+1==this.getGame().getBoardWidth())?1:(j+2==this.getGame().getBoardWidth())?0:j+2;
	int ni=(i+1==this.getGame().getBoardHeight())?1:(i+2==this.getGame().getBoardHeight())?0:i+2;
	boolean istarget=this.getGame().getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.DOWNRIGHT);	
		}
	if(istarget && (getGame().getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(getGame().getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(getGame().getCellAt(ni, nj).getPiece());}
	getGame().getCellAt(ni, nj).setPiece(this); this.setPosJ(nj);this.setPosI(ni);
	getGame().getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveUpRight() throws OccupiedCellException, WrongTurnException{
	int j= this.getPosJ();
	int i=this.getPosI();
	int nj=(j+1==getGame().getBoardWidth())?1:(j+2==getGame().getBoardWidth())?0:j+2;
	int ni=(i==0)?5:(i-1==0)?6:i-2;
	boolean istarget=this.getGame().getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.UPRIGHT);	
		}
	if(istarget && (getGame().getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) getGame().getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(getGame().getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(getGame().getCellAt(ni, nj).getPiece());}
	getGame().getCellAt(ni, nj).setPiece(this); this.setPosJ(nj);this.setPosI(ni);
	
	getGame().getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();} 
}


