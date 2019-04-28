package model.pieces.heroes;

import java.awt.Point;

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

public class Super extends ActivatablePowerHero {
	public Super(Player player, Game game, String name){
		super (player, game, name);
		}
	public void move(Direction r) throws WrongTurnException, OccupiedCellException, UnallowedMovementException{
		if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
			throw new WrongTurnException("This is not your turn",this);
		switch(r){
			case UP:moveUp();break;
			case DOWN:moveDown();break;
			case RIGHT:moveRight();break;
			case LEFT:moveLeft();break;
			default: throw new UnallowedMovementException("Super cannot move in this direction",this,r);
		
		}}
	public void usePowerHelper(Direction r1,Piece target1,Point newPos1,Boolean PowerAlreadyUsed) throws InvalidPowerDirectionException,WrongTurnException,PowerAlreadyUsedException, InvalidPowerTargetException {
		
		switch(r1){
		case UP:attackUp();super.usePower(null, null, null);break;
		case DOWN:attackDown();super.usePower(null, null, null);break;
		case RIGHT:attackRight();super.usePower(null, null, null);break;
		case LEFT:attackLeft();super.usePower(null, null, null);break;
		default: throw new InvalidPowerDirectionException(this,r1);
		
		}
		getGame().getCc().lightsaber();	
	}
	public void usePower(Direction r,Piece target,Point newPos) throws InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException, InvalidPowerTargetException {
		if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
			throw new WrongTurnException("This is not your turn",this);
		if(this.isPowerUsed()==true)
			throw new PowerAlreadyUsedException("Power Already Used", this);
		
		usePowerHelper( r, target, newPos,this.isPowerUsed()) ;
		
	}
	
	public void attackUp(){
		int h=this.getPosI();
		
		for(int count=2;count>0;count--) {
			h--;
			if((h>=0)&&((this.getGame().getCellAt(h, this.getPosJ()).getPiece()!=null)&& !this.getGame().getCellAt(h, this.getPosJ()).getPiece().getOwner().equals(getOwner()))) {
				this.attack(this.getGame().getCellAt(h, this.getPosJ()).getPiece());
				
			}
			
		}
}
		
	public void attackDown(){
		int h=this.getPosI();
		
		for(int count=2;count>0;count--) {
			h++;
			if((h<=6)&&((this.getGame().getCellAt(h, this.getPosJ()).getPiece()!=null)&&this.getGame().getCellAt(h, this.getPosJ()).getPiece().getOwner()!=this.getOwner())) {
				this.attack(this.getGame().getCellAt(h, this.getPosJ()).getPiece());
				
			}
			
		}
}
	


	public void attackRight(){
		int k=this.getPosJ();
		int i=this.getPosI();
		for(int count=2;count>0;count--) {
			k++;
			if((k<=5)&&((this.getGame().getCellAt(i,k).getPiece()!=null)&& !this.getGame().getCellAt(i,k).getPiece().getOwner().equals(this.getOwner()))) {
				this.attack(this.getGame().getCellAt(i,k).getPiece());
				
			}
			
		}
}
	
	public void attackLeft(){
		int k=this.getPosJ();
		int i=this.getPosI();
		for(int count=2;count>0;count--) {
			k--;
			if((k>=0)&&((this.getGame().getCellAt(i,k).getPiece()!=null)&& !this.getGame().getCellAt(i,k).getPiece().getOwner().equals(this.getOwner()))) {
				this.attack(this.getGame().getCellAt(i,k).getPiece());
				
			}
			
		}
}
	public boolean PowerAlreadyUsedhelper(Boolean PowerAlreadyUsed) {
		if(PowerAlreadyUsed==true) {
			return false;
		}
		return true;
		
	}
}
