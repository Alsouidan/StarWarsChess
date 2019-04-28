package model.pieces.sidekicks;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public class SideKickP2 extends SideKick {
public SideKickP2 (Game game, String name){
super(game.getPlayer2(),game,name);	
		}
public void move(Direction r) throws UnallowedMovementException, OccupiedCellException, WrongTurnException{
	if(!(getGame().getCurrentPlayer().equals(this.getOwner())))
		throw new WrongTurnException("This is not your turn",this);
	switch(r){
		case DOWN:moveDown();break;
		case DOWNRIGHT:moveDownRight();break;
		case DOWNLEFT:moveDownLeft();break;
		case RIGHT:moveRight();break;
		case LEFT:moveLeft();break;
		default: throw new UnallowedMovementException("Your SideKick cannot move in this direction",this,r);
	}}
public void attack(Piece target){//note to self: law etsawa7t fel GUI make Hero generators in game class
	if(target instanceof SideKick){
		super.attack(target);
		
	}
	else
		if(target instanceof Super){
			this.getOwner().setPayloadPos(this.getOwner().getPayloadPos()+1);
		int i=this.getPosI();
		int j=this.getPosJ();
		kill(target,this);
		getGame().getCellAt(i, j).setPiece(null);
		Super s=new Super(this.getOwner(),this.getGame(),"P2 Super");
		getGame().getCellAt(i, j).setPiece(s);s.setPosI(i);s.setPosJ(j);
		getGame().checkWinner();
		}else
		if(target instanceof Ranged){
			this.getOwner().setPayloadPos(this.getOwner().getPayloadPos()+1);
			int i=this.getPosI();
			int j=this.getPosJ();
			kill(target,this);
			getGame().getCellAt(i, j).setPiece(null);
			Ranged s=new Ranged(this.getOwner(),this.getGame(),"P2 Ranged");
			getGame().getCellAt(i, j).setPiece(s);s.setPosI(i);s.setPosJ(j);
			getGame().checkWinner();
		}else
		if(target instanceof Medic){
			this.getOwner().setPayloadPos(this.getOwner().getPayloadPos()+1);
			int i=this.getPosI();
			int j=this.getPosJ();
			kill(target,this);
			getGame().getCellAt(i, j).setPiece(null);
			Medic s=new Medic(this.getOwner(),this.getGame(),"P2 Medic");
			getGame().getCellAt(i, j).setPiece(s);s.setPosI(i);s.setPosJ(j);
			getGame().checkWinner();
		}else
		if(target instanceof Tech){
			this.getOwner().setPayloadPos(this.getOwner().getPayloadPos()+1);
			int i=this.getPosI();
			int j=this.getPosJ();
			kill(target,this);
			getGame().getCellAt(i, j).setPiece(null);
			Tech s=new Tech(this.getOwner(),this.getGame(),"P2 Tech"); //note: can replace with generator in GUI
			getGame().getCellAt(i, j).setPiece(s);s.setPosI(i);s.setPosJ(j);
			getGame().checkWinner();
		}else
		if(target instanceof Speedster){
			this.getOwner().setPayloadPos(this.getOwner().getPayloadPos()+1);
			int i=this.getPosI();
			int j=this.getPosJ();
			kill(target,this);
			getGame().getCellAt(i, j).setPiece(null);
			Speedster s=new Speedster(this.getOwner(),this.getGame(),"P2 Speedster");
			getGame().getCellAt(i, j).setPiece(s);s.setPosI(i);s.setPosJ(j);
			getGame().checkWinner();
		}else
		if(target instanceof Armored && ((Armored)target).isArmorUp()){
			((Armored)target).setArmorUp(false);
		}else{//armored with armor down
			this.getOwner().setPayloadPos(this.getOwner().getPayloadPos()+1);
			int i=this.getPosI();
			int j=this.getPosJ();
			kill(target,this);
			getGame().getCellAt(i, j).setPiece(null);
			Armored s=new Armored(this.getOwner(),this.getGame(),"P2 Armored");
			getGame().getCellAt(i, j).setPiece(s);s.setPosI(i);s.setPosJ(j);
			getGame().checkWinner();
		}
	
}
}
