package view;
import java.awt.BorderLayout;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import controller.StartListener;
import model.game.Game;
import model.game.Player;

public class GameFrame extends JFrame {
	private Clip clip;
	private Player p1;
	private Player p2;
	private CurrentPlayerPanel cp;
	private ScorePanel sp;
	private GraveYardPanel gyd;
	private BoardPanel bp;
	public CurrentPlayerPanel getCp() {
		return cp;
	}

	public void setCp(CurrentPlayerPanel cp) {
		this.cp = cp;
	}

	public GameFrame(Player p1,Player p2,boolean firstTime){
		Game g=new Game(p1,p2);
		setSize(1366,768);
		setTitle("Star Wars Chess");
		setLayout(new BorderLayout ());
		BoardPanel bp= new BoardPanel (g);
		setBp(bp);
		DirectionPanel x=new DirectionPanel(g);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(bp,BorderLayout.CENTER);
		add(x,BorderLayout.EAST);
		CurrentPlayerPanel cp=new CurrentPlayerPanel(g);
		setCp(cp);
		add(cp,BorderLayout.NORTH);
		ScorePanel sp=new ScorePanel(g);
		setSp(sp);
		add(sp,BorderLayout.WEST);
		GraveYardPanel gyd=new GraveYardPanel(g);
		setGyd(gyd);
		add(gyd,BorderLayout.SOUTH);
		setVisible(true);
		revalidate();
		repaint();
		if(firstTime)
		song();
	
	}
	
public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	}

public BoardPanel getBp() {
		return bp;
	}

	public void setBp(BoardPanel bp) {
		this.bp = bp;
	}

public GraveYardPanel getGyd() {
		return gyd;
	}

	public void setGyd(GraveYardPanel gyd) {
		this.gyd = gyd;
	}

public ScorePanel getSp() {
		return sp;
	}

	public void setSp(ScorePanel sp) {
		this.sp = sp;
	}

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
	public void song(){
		File file=null;
			
			file=new File("theme.wav");
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
