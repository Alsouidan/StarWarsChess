package model.pieces.heroes;

import java.awt.Point;

import exceptions.*;
import model.game.*;
import model.pieces.Piece;

public class Medic extends ActivatablePowerHero {
public Medic(Player player, Game game, String name){
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
		default: throw new UnallowedMovementException("Medic cannot move in this direction",this,r);
	}}
public void usePower(Direction r,Piece target,Point newPos) throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException {
	
	if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
		throw new WrongTurnException("This is not your turn",this);
	if(isPowerUsed()==true){
		throw new PowerAlreadyUsedException("Can't use power twice",this);
	}
	if(!target.getOwner().equals(getOwner()))
		throw new InvalidPowerTargetException ("Can't revive enemy piece",this,target);
	if(!getOwner().getDeadCharacters().contains(target)) 
		throw new InvalidPowerTargetException ("Can't revive a piece that hasn't been eliminated",this,target); 
	switch(r)
	{
	case UP: resUp(target);break;
	case RIGHT:resRight(target);break;
	case LEFT:resLeft(target);break;
	case DOWN:resDown(target);break;
	case UPRIGHT: resUpRight(target);break;
	case DOWNRIGHT:resDownRight(target);break;
	case UPLEFT:resUpLeft(target);break;
	case DOWNLEFT:resDownLeft(target);break;
	}
	if(getOwner().equals(getGame().getPlayer2()))
	getGame().getCc().lightning();
	}

	public void resUp(Piece target) throws InvalidPowerTargetException, InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException
	{
		int i=this.getPosI();
		int ti=(i==0)?6:i-1;
		int j=this.getPosJ();
		if (getGame().getCellAt(ti,j).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(ti, j).setPiece(p);p.setPosI(ti);p.setPosJ(j);
			getOwner().getDeadCharacters().remove(n);
			if (p instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (p instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
		super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	public void resDown(Piece target) throws InvalidPowerTargetException, InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException
	{
		int i=this.getPosI();
		int ti=(i==6)?0:i+1;
		int j=this.getPosJ();
		
		if (getGame().getCellAt(ti,j).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(ti, j).setPiece(p);p.setPosI(ti);p.setPosJ(j);
			getOwner().getDeadCharacters().remove(n);
			if (getGame().getCellAt(ti,j).getPiece() instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (getGame().getCellAt(ti,j).getPiece() instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
			super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	public void resLeft(Piece target) throws  InvalidPowerTargetException, InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException
	{
		int i=this.getPosI();
		int j=this.getPosJ();
		int tj =(j==0)?5:j-1;
		if (getGame().getCellAt(i,tj).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(i, tj).setPiece(p);p.setPosI(i);p.setPosJ(tj);
			getOwner().getDeadCharacters().remove(n);
			if (getGame().getCellAt(i,tj).getPiece() instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (getGame().getCellAt(i,tj).getPiece() instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
			super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	public void resRight(Piece target) throws InvalidPowerTargetException, InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException
	{
		int i=this.getPosI();
		int j=this.getPosJ();
		int tj=(j==5)?0:j+1;
		if (getGame().getCellAt(i,tj).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(i, tj).setPiece(p);p.setPosI(i);p.setPosJ(tj);
			getOwner().getDeadCharacters().remove(n);
			if (getGame().getCellAt(i,tj).getPiece() instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (getGame().getCellAt(i,tj).getPiece() instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
			super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	public void resUpRight(Piece target) throws InvalidPowerTargetException, InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException	{
		int i=this.getPosI();
		int ti=(i==0)?6:i-1;
		int tj=(getPosJ()==5)?0:getPosJ()+1;
		if (getGame().getCellAt(ti,tj).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(ti, tj).setPiece(p);p.setPosI(ti);p.setPosJ(tj);
			getOwner().getDeadCharacters().remove(n);
			if (p instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (p instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
		super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	public void resUpLeft(Piece target) throws InvalidPowerTargetException, InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException
	{
		int i=this.getPosI();
		int j=this.getPosJ();
		int ti=(i==0)?6:i-1;
		int tj=(j==0)?5:j-1;
		if (ti>=0 && tj>=0 &&getGame().getCellAt(ti,tj).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(ti, tj).setPiece(p);p.setPosI(ti);p.setPosJ(tj);
			getOwner().getDeadCharacters().remove(n);
			if (getGame().getCellAt(ti,tj).getPiece() instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (getGame().getCellAt(ti,tj).getPiece() instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
			super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	public void resDownRight(Piece target) throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException
	{
		int i=this.getPosI();
		int j=this.getPosJ();
		int ti=(i==6)?0:i+1;
		int tj=(j==5)?0:j+1;
		if ( getGame().getCellAt(ti,tj).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(ti, tj).setPiece(p);p.setPosI(ti);p.setPosJ(tj);
			getOwner().getDeadCharacters().remove(n);
			if (getGame().getCellAt(ti,tj).getPiece() instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (getGame().getCellAt(ti,tj).getPiece() instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
		super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	public void resDownLeft(Piece target) throws InvalidPowerTargetException, InvalidPowerDirectionException, PowerAlreadyUsedException, WrongTurnException
	{
		int i=this.getPosI();
		int j=this.getPosJ();
		int ti=i+1;
		int tj=j-1;
		if(ti>6 || tj<0){
			throw new InvalidPowerTargetException ("You can't revive a piece in this position",this,target);
		}
		if (getGame().getCellAt(ti,tj).getPiece()== null)
		{
			int n= getOwner().getDeadCharacters().indexOf(target);
			Piece p=getOwner().getDeadCharacters().get(n);getGame().getCellAt(ti, tj).setPiece(p);p.setPosI(ti);p.setPosJ(tj);
			getOwner().getDeadCharacters().remove(n);
			if (getGame().getCellAt(ti,tj).getPiece() instanceof Armored )
			{
				((Armored)target).setArmorUp(true);
			}
			if (getGame().getCellAt(ti,tj).getPiece() instanceof ActivatablePowerHero)
			{
				((ActivatablePowerHero)target).setPowerUsed(false);
			}
			super.usePower(null, null, null);
		}
		else 
		{
			throw new InvalidPowerTargetException ("Piece already exists in this cell",this,target);
		}
	}
	
	}

