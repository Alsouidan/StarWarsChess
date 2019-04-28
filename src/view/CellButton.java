package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import com.sun.prism.Image;

import model.game.Cell;
import model.game.Game;

public class CellButton extends SuperButton {
private Cell cell; 
private Point p;
public Cell getCell() {
	return cell;
}
public void setCell(Cell cell) {
	this.cell = cell;
}
public CellButton (Cell a,Game g,int i, int j){
super("",g);
setVisible(true);
setBounds(0, 0, 100, 140);  //don't think it helps
cell=a;
setFocusPainted(true);
setBackground(Color.BLACK);
setContentAreaFilled(false);
setBorder(BorderFactory.createEmptyBorder());
setMargin(new Insets(0, 0, 0, 0));
setImage();
this.setToolTipText(a.toString());
this.setActionCommand("move");
this.addActionListener(g.getCc());
p=new Point(i,j);
//System.out.println(getHeight()+"  "+getWidth());
revalidate();
repaint();

}
public void setImage() {
	ImageIcon ii=null;
//	ImageIcon ii=new ImageIcon(getClass().getResource("/GUI/back.jpg"));;
	if (cell.getPiece()==null){
		try{
		ii = new ImageIcon(getClass().getResource("/GUI/back.jpg"));}
		catch(NullPointerException e){
			new ErrorFrame(new NullPointerException("Image File Not Found"),cell.getPiece().getGame());
			}
		}
	else{
		try{
			ii = new ImageIcon(getClass().getResource("/GUI/"+cell.toString()+".png"));}
			catch(NullPointerException e){
				new ErrorFrame(new NullPointerException("Image File Not Found"),cell.getPiece().getGame());
				}

	  }
//	super.setIcon(getscaledImage(ii,getHeight(),getWidth()));   slows down game
	super.setIcon(ii);
	}


public Point getP() {
	return p;
}
public void setP(Point p) {
	this.p = p;
}
public static ImageIcon getscaledImage(ImageIcon i,int x, int y){
	java.awt.Image image=i.getImage();
	return new ImageIcon(image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH));
}
//public Dimension getPreferredSize(){
//	Dimension d= getParent().getSize();
//	int w = d.width*80/100;
//	int h = d.height*80/100;
//	return new Dimension(w,h);
//	
//}
}
