package model.pieces;
import model.pieces.heroes.*;
import exceptions.*;
import model.game.*;
import model.pieces.sidekicks.*;

public abstract class Piece implements Movable  { /*attributes are read only unless 
	and abstract class as no instants will be created*/
private String name;
private Player owner;
private Game game;
private int posI; //read&write
private int posJ; //read&write
public Piece(Player player, Game game, String name){
	owner=player;
	this.game=game;
	this.name=name;
}
public String getName() {
	return name;
}
public Player getOwner() {
	return owner;
}
public Game getGame() {
	return game;
}
public int getPosI() {
	return posI;
}
public int getPosJ() {
	return posJ;
}
public void setPosI(int posI) {
	this.posI = posI;
}
public void setPosJ(int posJ) {
	this.posJ = posJ;
}
public static void kill(Piece target,Piece atk){//nullifies piece in cell not sure if correct
	atk.game.getCellAt(target.getPosI(), target.getPosJ()).setPiece(null);
	target.getOwner().getDeadCharacters().add(target);
}
public  void attack(Piece target) {//Override in SideKick Class
if((target instanceof Armored) && ((Armored) target).isArmorUp()){
((Armored)target).setArmorUp(false);
if(target.getOwner().equals(getGame().getPlayer1())){
	target.getGame().getCc().growl();
}
}
else{
	if(target instanceof SideKick){
		kill(target,this);
		getOwner().setSideKilled(getOwner().getSideKilled()+1);
		int p=((getOwner().getSideKilled()%2)==0)?getOwner().getPayloadPos()+1:getOwner().getPayloadPos();
		getOwner().setPayloadPos(p);
	}else{
		kill(target,this);
		getOwner().setPayloadPos(getOwner().getPayloadPos()+1);
	}
	getGame().checkWinner();}}
//i will check for wrap and armored in helpers
public void moveDown() throws OccupiedCellException, WrongTurnException{
int i=this.getPosI();
int j=this.getPosJ();
int ni=(i+1==game.getBoardHeight())?0:i+1;
boolean istarget=game.getCellAt(ni, j).getPiece()!=null;
if(istarget && getGame().getCellAt(ni, j).getPiece().getOwner().equals(this.getOwner())){
throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.DOWN);	
}
if(istarget && (game.getCellAt(ni, j).getPiece()instanceof Armored) && ((Armored) game.getCellAt(ni, j).getPiece()).isArmorUp()){
	attack(game.getCellAt(ni, j).getPiece());
}else{if(istarget){
	attack(game.getCellAt(ni, j).getPiece());}
Piece p=getGame().getCellAt(i, j).getPiece();
game.getCellAt(ni, j).setPiece(p); p.setPosI(ni);p.setPosJ(j);
game.getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveRight() throws OccupiedCellException, WrongTurnException{
int i=this.getPosI();
int j=this.getPosJ();
int nj=(j+1==game.getBoardWidth())?0:j+1;
boolean istarget=game.getCellAt(i, nj).getPiece()!=null;
if(istarget && getGame().getCellAt(i, nj).getPiece().getOwner().equals(this.getOwner())){
throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.RIGHT);	
}
if(istarget && (game.getCellAt(i, nj).getPiece()instanceof Armored) && ((Armored) game.getCellAt(i, nj).getPiece()).isArmorUp()){
	attack(game.getCellAt(i, nj).getPiece());
}else{if(istarget){
	attack(game.getCellAt(i, nj).getPiece());}
Piece p=getGame().getCellAt(i, j).getPiece();
game.getCellAt(i, nj).setPiece(p); p.setPosJ(nj);p.setPosI(i);game.getCellAt(i, j).setPiece(null);}
this.getGame().switchTurns();}
public void moveLeft() throws OccupiedCellException, WrongTurnException{
	int i=this.getPosI();
	int j=this.getPosJ();
	int nj=(j==0)?5:j-1;
	boolean istarget=game.getCellAt(i, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(i, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.LEFT);	
		}
	if(istarget && (game.getCellAt(i, nj).getPiece()instanceof Armored) && ((Armored) game.getCellAt(i, nj).getPiece()).isArmorUp()){
		attack(game.getCellAt(i, nj).getPiece());
	}else{if(istarget){
		attack(game.getCellAt(i, nj).getPiece());}
	Piece p=getGame().getCellAt(i, j).getPiece();
	game.getCellAt(i, nj).setPiece(p); p.setPosJ(nj);p.setPosI(i);
	game.getCellAt(i, j).setPiece(null);}this.getGame().switchTurns();}
public void moveUp() throws OccupiedCellException, WrongTurnException{
int i=this.getPosI();
int j=this.getPosJ();
int ni=(i==0)?6:i-1;
boolean istarget=game.getCellAt(ni, j).getPiece()!=null;
if(istarget && getGame().getCellAt(ni, j).getPiece().getOwner().equals(this.getOwner())){
throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.UP);	
}
if(istarget && (game.getCellAt(ni, j).getPiece()instanceof Armored) && ((Armored) game.getCellAt(ni, j).getPiece()).isArmorUp()){
	attack(game.getCellAt(ni, j).getPiece());
}else{if(istarget){
	attack(game.getCellAt(ni, j).getPiece());}
Piece p=getGame().getCellAt(i, j).getPiece();
game.getCellAt(ni, j).setPiece(p); p.setPosI(ni);p.setPosJ(j);game.getCellAt(i, j).setPiece(null);}
this.getGame().switchTurns();}
public void moveDownRight() throws OccupiedCellException, WrongTurnException{
	int i=this.getPosI();
	int j=this.getPosJ();
	int nj=(j+1==game.getBoardWidth())?0:j+1;
	int ni=(i+1==game.getBoardHeight())?0:i+1;
	boolean istarget=game.getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.DOWNRIGHT);	
		}
	if(istarget && (game.getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) game.getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(game.getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(game.getCellAt(ni, nj).getPiece());}
	Piece p=getGame().getCellAt(i, j).getPiece();
	game.getCellAt(ni, nj).setPiece(p); p.setPosJ(nj);p.setPosI(ni);//actual move
	
	game.getCellAt(i, j).setPiece(null);}
	this.getGame().switchTurns();}
public void moveDownLeft() throws OccupiedCellException, WrongTurnException {
	int i=this.getPosI();
	int j=this.getPosJ();
	int nj=(j==0)?5:j-1;
	int ni=(i+1==game.getBoardHeight())?0:i+1;
	boolean istarget=game.getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.DOWNLEFT);	
		}
	if(istarget && (game.getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) game.getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(game.getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(game.getCellAt(ni, nj).getPiece());}
	Piece p=getGame().getCellAt(i, j).getPiece();
	game.getCellAt(ni, nj).setPiece(p); p.setPosJ(nj);p.setPosI(ni);//actual move
	game.getCellAt(i, j).setPiece(null);}
	this.getGame().switchTurns();}
public void moveUpLeft() throws OccupiedCellException, WrongTurnException {
	int i=this.getPosI();
	int j=this.getPosJ();
	int nj=(j==0)?5:j-1;
	int ni=(i==0)?6:i-1;
	boolean istarget=game.getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.UPLEFT);	
		}
	if(istarget && (game.getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) game.getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(game.getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(game.getCellAt(ni, nj).getPiece());}
	Piece p=getGame().getCellAt(i,j).getPiece();
	game.getCellAt(ni, nj).setPiece(p); p.setPosJ(nj);p.setPosI(ni);//actual move
	game.getCellAt(i, j).setPiece(null);}
	this.getGame().switchTurns();}
public void moveUpRight() throws OccupiedCellException, WrongTurnException  {
	int i=this.getPosI();
	int j=this.getPosJ();
	int nj=(j+1==game.getBoardWidth())?0:j+1;
	int ni=(i==0)?6:i-1;
	boolean istarget=game.getCellAt(ni, nj).getPiece()!=null;
	if(istarget && getGame().getCellAt(ni, nj).getPiece().getOwner().equals(this.getOwner())){
		throw new OccupiedCellException("Can't move to a cell containing a friendly piece",this,Direction.UPRIGHT);	
		}
	if(istarget && (game.getCellAt(ni, nj).getPiece()instanceof Armored) && ((Armored) game.getCellAt(ni, nj).getPiece()).isArmorUp()){
		attack(game.getCellAt(ni, nj).getPiece());
	}else{if(istarget){
		attack(game.getCellAt(ni, nj).getPiece());}
	Piece p=getGame().getCellAt(i, j).getPiece();
	game.getCellAt(ni, nj).setPiece(p); p.setPosJ(nj);p.setPosI(ni);//actual move
	game.getCellAt(i, j).setPiece(null);}
	this.getGame().switchTurns();}
public String toString(){
	return name;
}
}

