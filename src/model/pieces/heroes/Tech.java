package model.pieces.heroes;

import java.awt.Point;

import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Tech extends ActivatablePowerHero {
	public Tech(Player player, Game game, String name){
		super (player, game, name);
		}
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
			throw new WrongTurnException("This is not your turn",this);
		switch(r){
			case UPRIGHT:moveUpRight();break;
			case DOWNRIGHT:moveDownRight();break;
			case DOWNLEFT:moveDownLeft();break;
			case UPLEFT:moveUpLeft();break;
			default: throw new UnallowedMovementException("Tech cannot move in this direction",this,r);
		}}
	public void usePower(Direction r,Piece target,Point newPos) throws WrongTurnException, PowerAlreadyUsedException, InvalidPowerTargetException {
		if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
			throw new WrongTurnException("This is not your turn",this);
		if(isPowerUsed()==true){
			throw new PowerAlreadyUsedException("Can't use power twice",this);
		}
		if(newPos!=null && target!=null && r==null) 
		this.teleport(target, newPos);
		if(target!= null && !target.getOwner().equals(getOwner()) && newPos==null && r==null)
			hack(target);
		if(target!= null && target.getOwner().equals(getOwner()) && newPos==null && r==null)
			restore(target);

		if(this.getOwner().equals(getGame().getPlayer1()))
		getGame().getCc().beep();
		
	}
	public void teleport(Piece target,Point p) throws InvalidPowerTargetException {
		int i=target.getPosI();int j=target.getPosJ();
		int y=(int)p.getX();int x=(int)p.getY();
		if(target.getOwner().equals(getOwner())&&getGame().getCellAt(y, x).getPiece()==null) {
			target.setPosI(y);target.setPosJ(x);
			getGame().getCellAt(i,j).setPiece(null);getGame().getCellAt(y,x).setPiece(target);
			
		}else if(!target.getOwner().equals(getOwner())) {
		throw new InvalidPowerTargetException ("Can't teleport an enemy piece",this,target);}
		else {
			if(!getGame().getCellAt(y, x).getPiece().equals(null)) {
			throw new InvalidPowerTargetException ("Cell is already containing a piece",this,target);}}
		this.setPowerUsed(true);}

public void hack(Piece target) throws InvalidPowerTargetException {
	if (!target.getOwner().equals(getOwner())) {
		if(target instanceof Armored) {
			if(((Armored) target).isArmorUp()==false) {
				throw new InvalidPowerTargetException ("The armor of this piece has already been removed",this,target);
			}else
				((Armored) target).setArmorUp(false);
		}
		if(target instanceof ActivatablePowerHero) {
			if(((ActivatablePowerHero) target).isPowerUsed()==true) {
				throw new InvalidPowerTargetException("This piece has already used its power",this,target);
			}else
				((ActivatablePowerHero) target).setPowerUsed(true);
		}
this.setPowerUsed(true);}
}
public void restore(Piece target) throws InvalidPowerTargetException {
	if (target.getOwner().equals(getOwner())) {
		if(target instanceof Armored) {
			if(((Armored) target).isArmorUp()==true) {
				throw new InvalidPowerTargetException ("The armor of this piece hasn't been removed yet",this,target);
			}else
				((Armored) target).setArmorUp(true);
		}
		if(target instanceof ActivatablePowerHero) {
			if(((ActivatablePowerHero) target).isPowerUsed()==false) {
				throw new InvalidPowerTargetException("This piece hasn't used its power yet",this,target);
			}else
				((ActivatablePowerHero) target).setPowerUsed(false);
		}
this.setPowerUsed(true);
	}
}
}
