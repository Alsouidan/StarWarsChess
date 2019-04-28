package view;

import model.game.Game;
import model.pieces.Piece;

public class DeadButton extends SuperButton {
	private Piece piece;
	public DeadButton (Piece a,Game g){
		super(a.getName(),g);
		piece=a;
		this.setActionCommand("dead");
		this.addActionListener(g.getCc());
		}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
