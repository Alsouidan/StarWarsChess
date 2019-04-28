package view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.game.Game;

public class PowerButton extends SuperButton {

	public PowerButton(String s, Game g) {
		super("", g);
		setActionCommand("use");
		setImage();
		addActionListener(g.getCc());
	}
	public void setImage() {
		
			 ImageIcon ii = new ImageIcon(getClass().getResource("/GUI/usePower.png"));
			 
			super.setIcon(ii);
		}
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    java.awt.Image img = icon.getImage();  
	    java.awt.Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}

}
