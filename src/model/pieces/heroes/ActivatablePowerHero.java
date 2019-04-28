package model.pieces.heroes;
import java.awt.*;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.PowerAlreadyUsedException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public abstract class ActivatablePowerHero extends Hero {
	private boolean powerUsed; //read&write
	public ActivatablePowerHero(Player player, Game game, String name){
		super(player,game,name);
		powerUsed=false;
	}
	public boolean isPowerUsed() {
		return powerUsed;
	}
	public void setPowerUsed(boolean powerUsed) {
		this.powerUsed = powerUsed;
	}
	 public void usePower(Direction r,Piece target,Point newPos) throws InvalidPowerDirectionException, InvalidPowerTargetException, PowerAlreadyUsedException, WrongTurnException{
		 powerUsed=true;
		 getGame().switchTurns();
		 
	 }
	 public String toString(){
		 if(!powerUsed){
			 return getName()+" Power not Used";
		 }
		 return getName()+" Power Used";
	 }
}
