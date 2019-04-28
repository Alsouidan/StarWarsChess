package view;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import controller.StartListener;
import model.game.Player;

public class StartFrame extends JFrame {
private Player p1;
private Player p2;

public Player getP1() {
	return p1;
}
public void setP1(Player p1) {
	this.p1 = p1;
}
public Player getP2() {
	return p2;
}
public void setP2(Player p2) {
	this.p2 = p2;
}
public StartFrame(StartListener l,boolean firstTime){
	setSize(700,100);
	PlayerPanel p2=new PlayerPanel(l,firstTime);
	this.setLayout(new BorderLayout ());
	setTitle("Please Enter Your Names");
	setLocationRelativeTo(null);
	add(p2,BorderLayout.WEST);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	revalidate();
	repaint();
	
}

}
