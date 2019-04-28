package view;

import javax.swing.ImageIcon;

import model.game.Direction;
import model.game.Game;

public class DirectionButton extends SuperButton {
	private Direction direction;
	public DirectionButton(Direction r,Game g){
		super("",g);
		direction=r;
		setImage();
		this.setActionCommand("d");
		this.addActionListener(g.getCc());
	}
	private void setImage() {
		ImageIcon ii=null;
		try{
			ii = new ImageIcon(getClass().getResource("/GUI/"+getDirection()+".png"));}
			catch(NullPointerException e){
//				new ErrorFrame(new NullPointerException("Image File Not Found"),cell.getPiece().getGame());
				}
		setIcon(ii);
		
	}
	public Direction getDirection(){	
		return direction;	
	}
}