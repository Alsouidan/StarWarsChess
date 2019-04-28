package model.game;

import controller.ChessController;
import model.pieces.*;
import model.pieces.heroes.*;
import model.pieces.sidekicks.*;

public class Game { //all attributes are read unless stated
 final private	int payloadPosTarget=6;
 final private int boardWidth = 6;
 final private int boardHeight=7;
 private Player player1;
 private Player player2;
 private Player currentPlayer; //Read&write
 private Cell [][] board; //neither read nor write. height X Width
 private ChessController cc;
 public ChessController getCc() {
	return cc;
}
public void setCc(ChessController cc) {
	this.cc = cc;
}
public Game (Player player1, Player player2){
	 cc = new ChessController();
	 this.player1=player1;
	 this.player2=player2;
	 board=new Cell [boardHeight][boardWidth];
	 currentPlayer=player1;
	 assemblePieces();
 }
public int getPayloadPosTarget() {
	return payloadPosTarget;
}
public int getBoardWidth() {
	return boardWidth;
}
public int getBoardHeight() {
	return boardHeight;
}
public Player getPlayer1() {
	return player1;
}
public Player getPlayer2() {
	return player2;
}
public Player getCurrentPlayer() {
	return currentPlayer;
}
public void setCurrentPlayer(Player currentPlayer) {
	this.currentPlayer = currentPlayer;
}
public static boolean contains(int[]a,int b){
	for(int i=0;i<a.length;i++)
		if(a[i]==b)
			return true;
		return false;
	
}
public static int[] randomlist(){
	int[]r1=new int[6];
	for(int i=0;i<6;i++){
		r1[i]=(int)(Math.random()*6);
	}
	int r2[]=new int [6];
	for(int i=0;i<6;i++){
		r2[i]=-1;
	}
	for(int i=0;i<6;i++){
		if(r2[r1[i]]==-1)
			r2[r1[i]]=i;
			else{
				while (r2[r1[i]]!=-1){
					r1[i]=(r1[i]==5)?0:r1[i]+1;
				}
				r2[r1[i]]=i;
				
			}
	}
return r2;}
public  void assemblePieces(){//random not implemented
for(int i=0;i<getBoardHeight();i++){
	for(int j=0;j<getBoardWidth();j++){
		board[i][j]=new Cell();
	}
	
}
int r1[]=randomlist();
int c=-1;
Medic m=	new Medic(player2,this,"P2 Medic");m.setPosI(1);m.setPosJ(r1[++c]);board[1][r1[c]].setPiece(m);
Speedster s= new Speedster(player2,this,"P2 Speedster");s.setPosI(1);s.setPosJ(r1[++c]);board[1][r1[c]].setPiece(s);
Super su= new Super(player2,this,"P2 Super");su.setPosI(1);su.setPosJ(r1[++c]);board[1][r1[c]].setPiece(su);
Tech t=new Tech(player2,this,"P2 Tech");t.setPosI(1);t.setPosJ(r1[++c]);board[1][r1[c]].setPiece(t);
Ranged r=new Ranged(player2,this,"P2 Ranged");r.setPosI(1);r.setPosJ(r1[++c]);board[1][r1[c]].setPiece(r);
Armored a=new Armored(player2,this,"P2 Armored");a.setPosI(1);a.setPosJ(r1[++c]);board[1][r1[c]].setPiece(a);
for(int i=0;i<this.getBoardWidth();i++){
	board[2][i].setPiece(new SideKickP2(this,"P2 SideKick"));
	board[2][i].getPiece().setPosI(2);board[2][i].getPiece().setPosJ(i);
}
c=-1;
r1=randomlist();
Armored a2= new Armored(player1,this,"P1 Armored");a2.setPosI(5);a2.setPosJ(r1[++c]);board[5][r1[c]].setPiece(a2);
Speedster s2= new Speedster(player1,this,"P1 Speedster");s2.setPosI(5);s2.setPosJ(r1[++c]);board[5][r1[c]].setPiece(s2);
Ranged r22=new Ranged(player1,this,"P1 Ranged");r22.setPosI(5);r22.setPosJ(r1[++c]);board[5][r1[c]].setPiece(r22);
Tech t2= new Tech(player1,this,"P1 Tech");t2.setPosI(5);t2.setPosJ(r1[++c]);board[5][r1[c]].setPiece(t2);
Medic m2=new Medic(player1,this,"P1 Medic");m2.setPosI(5);m2.setPosJ(r1[++c]);board[5][r1[c]].setPiece(m2);
Super su2=new Super(player1,this,"P1 Super");su2.setPosI(5);su2.setPosJ(r1[++c]);board[5][r1[c]].setPiece(su2);
for(int i=0;i<this.getBoardWidth();i++){
	board[4][i].setPiece(new SideKickP1(this,"P1 SideKick"));
	board[4][i].getPiece().setPosI(4);board[4][i].getPiece().setPosJ(i);
}
}
public Cell getCellAt(int i,int j){
	return board[i][j];
}
public void switchTurns(){
	if (this.getCurrentPlayer().equals(player1)){
		this.setCurrentPlayer(player2);
		return;
	}
	this.setCurrentPlayer(player1);
}
public boolean checkWinner(){
	if(this.getCurrentPlayer().getPayloadPos()==this.getPayloadPosTarget()){
		return true;
	}
	return false;
}

}