package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.MainMenuListener;

public class MainMenu extends JFrame {  
	private Clip clip;
	public Clip getClip() {
		return clip;
	}
	public void setClip(Clip clip) {
		this.clip = clip;
	}
    public MainMenu(MainMenuListener mml) {
    	setSize(1280,720);
    	setLocationRelativeTo(null);
    	setTitle("Main Menu");
    	setResizable(false);
    	setLayout(new BorderLayout());
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	JLabel jl=new JLabel(new ImageIcon("main.png"));
    	binary();
    	setContentPane(jl);
    	jl.setLayout(new GridBagLayout());
    	jl.add(new MainButtonPanel(mml));
     	setVisible(true);
    	
    	revalidate();
    	repaint();
    	
    }
    public static void main (String[] args){
    	new MainMenu(new MainMenuListener());
    }
    public void binary(){
    	File file=null;
    		
    		file=new File("binary.wav");
    		Clip c=null;
    		
    			try {
    				c = AudioSystem.getClip();
    			} catch (Exception e) {
    			}
    		
    		try {
    			c.open(AudioSystem.getAudioInputStream(file));
    		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
    			
    		}
    		c.loop(Clip.LOOP_CONTINUOUSLY);
    		c.start();
    		clip=c;
    		
    	
    	}

}
