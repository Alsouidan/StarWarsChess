package model.pieces.heroes;

import java.awt.Point;

import exceptions.GameActionException;
import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Ranged extends ActivatablePowerHero {
	public Ranged(Player player, Game game, String name){
		super (player, game, name);
		}
	public void move(Direction r) throws WrongTurnException, OccupiedCellException, UnallowedMovementException{
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
			default: throw new UnallowedMovementException("Ranged cannot move in this direction",this,r);
		}}
	public void usePower(Direction r,Piece target,Point newPos) throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException {
		
		if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
			throw new WrongTurnException("This is not your turn",this);
		if(isPowerUsed()==true){
			throw new PowerAlreadyUsedException("Can't use power twice",this);
		}
		switch(r)
		{
		case UP: attackUp();break;
		case RIGHT:attackRight();break;
		case LEFT:attackLeft();break;
		case DOWN:attackDown();break;
		default: throw new InvalidPowerDirectionException("Ranged cannot attack in this direction",this,r);
		}
		getGame().getCc().blast();
	
	}
	public void attackUp() throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException{
		int i=this.getPosI();
		int ti=i-1;
		int j=this.getPosJ();
		
		while (ti>=0 && ti<=6){
			boolean istarget=getGame().getCellAt(ti, j).getPiece()!=null;
			
			
			if (istarget && !getGame().getCellAt(ti, j).getPiece().getOwner().equals(this.getOwner()))
			{
				attack(getGame().getCellAt(ti, j).getPiece());
				super.usePower(null, null, null);
				return;
			}
			if (istarget && getGame().getCellAt(ti, j).getPiece().getOwner().equals(this.getOwner()))
			{
				throw new InvalidPowerDirectionException("Can't use power on friendly piece" ,this,Direction.UP);
			}
			ti--;
		}
		throw new InvalidPowerDirectionException("No Target in this direction",this,Direction.UP);
		
	}
	public void attackDown() throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException{
		int i=this.getPosI();
		int ti=i+1;
		int j=this.getPosJ();
		
		while (ti>=0 && ti<=6){
			boolean istarget=getGame().getCellAt(ti, j).getPiece()!=null;
			
			
			if (istarget && !getGame().getCellAt(ti, j).getPiece().getOwner().equals(this.getOwner()))
			{
				attack(getGame().getCellAt(ti, j).getPiece());
				super.usePower(null, null, null);
				return;
			}
			if (istarget && getGame().getCellAt(ti, j).getPiece().getOwner().equals(this.getOwner()))
			{
				throw new InvalidPowerDirectionException("Can't use power on friendly piece" ,this,Direction.DOWN);
			}
			ti++;
		}
		throw new InvalidPowerDirectionException("No Target in this direction",this,Direction.DOWN);
		
	}
	public void attackRight() throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException{
		int i=this.getPosI();
		int j=this.getPosJ();
		int tj= j+1;
		
		
		while (tj>=0 && tj<=5){
			boolean istarget=getGame().getCellAt(i, tj).getPiece()!=null;
			
			
			if (istarget && !getGame().getCellAt(i, tj).getPiece().getOwner().equals(this.getOwner()))
			{
				
				attack(getGame().getCellAt(i, tj).getPiece());
				super.usePower(null, null, null);
				return;
			}
			if (istarget && getGame().getCellAt(i, tj).getPiece().getOwner().equals(this.getOwner()))
			{
				throw new InvalidPowerDirectionException("Can't use power on friendly piece" ,this,Direction.RIGHT);
			}
			tj++;
		}
		throw new InvalidPowerDirectionException("No Target in this direction",this,Direction.RIGHT);
		
	}
	public void attackLeft() throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException{
		int i=this.getPosI();
		int j=this.getPosJ();
		int tj= j-1;
		
		
		while (tj>=0 && tj<=5){
			boolean istarget=getGame().getCellAt(i, tj).getPiece()!=null;
			
			
			if (istarget && !getGame().getCellAt(i, tj).getPiece().getOwner().equals(this.getOwner()))
			{
				
				attack(getGame().getCellAt(i, tj).getPiece());
				super.usePower(null, null, null);
				return;
			}
			if (istarget && getGame().getCellAt(i, tj).getPiece().getOwner().equals(this.getOwner()))
			{
				throw new InvalidPowerDirectionException("Can't use power on friendly piece" ,this,Direction.LEFT);
			}
			tj--;
		}
		throw new InvalidPowerDirectionException("No Target in this direction",this,Direction.LEFT);
		
	}

		
	
}
