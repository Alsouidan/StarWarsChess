package controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import view.BoardPanel;
import view.CellButton;
import view.CurrentPlayerPanel;
import view.DeadButton;
import view.DirectionButton;
import view.ErrorFrame;
import view.GameFrame;
import view.GraveYardPanel;
import view.HelpFrame;
import view.ScorePanel;
import view.StartFrame;
import view.WinningPanel;

public class ChessController extends SuperListener {
	private Direction direction;
	private Piece dead;
	private boolean usePower=false;
	private boolean mute=false;
	public boolean isMute() {
		return mute;
	}
	public void setMute(boolean mute) {
		this.mute = mute;
	}
	public boolean isUsePower() {
		return usePower;
	}
	public void setUsePower(boolean usePower) {
		this.usePower = usePower;
	}
	private Piece user;
	private Point p;
	public void actionPerformed(ActionEvent e) {
		JPanel jp=getJPanel(e);
		Game g=getGame(e);
		String s = e.getActionCommand();
		Component c = (Component) e.getSource();
		switch (s) {
		case "target":GameFrame gf3=((GameFrame) SwingUtilities.getRoot(c));
			p =((CellButton) e.getSource()).getP();turnMove(gf3.getBp());break;
		case "use": GameFrame gf7=((GameFrame) SwingUtilities.getRoot(c));
	turnUser(gf7.getBp());	
			usePower=true;((JButton) e.getSource()).setActionCommand("done");gf7.getCp().refresh(g);saber();;break;
		case "done": GameFrame gf=((GameFrame) SwingUtilities.getRoot(c));
		CurrentPlayerPanel cp=((GameFrame) SwingUtilities.getRoot(c)).getCp();
		ScorePanel sp=((GameFrame) SwingUtilities.getRoot(c)).getSp();
		GraveYardPanel gyd=((GameFrame) SwingUtilities.getRoot(c)).getGyd(); 
			try {if(p!=null)
				((ActivatablePowerHero) user).usePower(direction, dead, p);
			else
				((ActivatablePowerHero) user).usePower(direction, dead, null);
			} catch (InvalidPowerDirectionException | InvalidPowerTargetException | PowerAlreadyUsedException
					| WrongTurnException e2) {
				
				new ErrorFrame(e2,g);
			}
			catch(ClassCastException e1){
				new ErrorFrame (new ClassCastException("This Piece doesn't have a Power Ability"),g);
			}
			catch(NullPointerException e1){
			}
gf.getBp().refresh(g);reset();
			
			cp.refresh(g);sp.refresh(g);gyd.refresh(g);didWin(g,gf);
			((JButton) e.getSource()).setActionCommand("use");
			break;
		case "unmute":((GameFrame) SwingUtilities.getRoot(c)).song();((JButton) e.getSource()).setActionCommand("mute");mute=false;((JButton) e.getSource()).setText("Mute");break;
		case "mute":try{((GameFrame) SwingUtilities.getRoot(c)).getClip().stop();
		((JButton) e.getSource()).setActionCommand("unmute");mute=true;((JButton) e.getSource()).setActionCommand("unmute");((JButton) e.getSource()).setText("Unmute");}
		catch(Exception b){}
		break;
		case "end": Component c1 = (Component) e.getSource();
		((WinningPanel) SwingUtilities.getRoot(c1)).dispose();
		break;
		case "dead1":GameFrame gf4=((GameFrame) SwingUtilities.getRoot(c));
			dead=((CellButton)e.getSource()).getCell().getPiece();turnTarget(gf4.getBp());break;
		case "dead":
			dead=((DeadButton)e.getSource()).getPiece();break;
		case"restart":Component c2 = (Component) e.getSource();
			new StartFrame(new StartListener(),false);((WinningPanel) SwingUtilities.getRoot(c2)).dispose();break;
		case "help": new HelpFrame(g);;break;
		case "gotit":Component component1 = (Component) e.getSource();
		HelpFrame hf=((HelpFrame) SwingUtilities.getRoot(component1));
		hf.dispose();break;
		case "error": Component component = (Component) e.getSource();
		ErrorFrame ef=((ErrorFrame) SwingUtilities.getRoot(component));
		ef.dispose();break;
		case "move":GameFrame gf2=((GameFrame) SwingUtilities.getRoot(c));
		CurrentPlayerPanel cp1=((GameFrame) SwingUtilities.getRoot(c)).getCp();
		ScorePanel sp1=((GameFrame) SwingUtilities.getRoot(c)).getSp();
		GraveYardPanel gyd1=((GameFrame) SwingUtilities.getRoot(c)).getGyd();
			if(!usePower){
			
			try {
				((CellButton) e.getSource()).getCell().getPiece().move(direction);
			} catch (OccupiedCellException | UnallowedMovementException | WrongTurnException e1) {
				
				new ErrorFrame(e1,g);
			}
			catch (NullPointerException e1){
				new ErrorFrame(new NullPointerException("Please choose a direction then a hero"),g);
			}
			
			gf2.getBp().refresh(g);reset();
			
			cp1.refresh(g);sp1.refresh(g);gyd1.refresh(g);didWin(g,gf2);}
		else{
		user=((CellButton) e.getSource()).getCell().getPiece();
		turnDead(gf2.getBp());
		}
		break;
		case "d":
			d(((DirectionButton) e.getSource()).getDirection());
			break;
		}
	}
	public void d(Direction d){
		direction=d;
	}
	public void didWin(Game g,GameFrame gf){
	Player	winner=(g.getCurrentPlayer().equals(g.getPlayer1()))?g.getPlayer2():g.getPlayer1();
	if(winner.getPayloadPos()>=g.getPayloadPosTarget()){
		
	gf.dispose();
		WinningPanel wp= new WinningPanel(g);
				
		
	}
	}
	public void reset(){
		direction=null;
		user=null;
		p=null;
		dead=null;
		usePower=false;
	}
	public void turnUser(BoardPanel bp){
		for(int i=0;i<bp.getButtons().size();i++){
		bp.getButtons().get(i).setToolTipText(((CellButton) bp.getButtons().get(i)).getCell().toString()+ " Choose power user");
		}}
	public void turnDead(BoardPanel bp){
		for(int i=0;i<bp.getButtons().size();i++){
			bp.getButtons().get(i).setActionCommand("dead1");

			bp.getButtons().get(i).setToolTipText(((CellButton) bp.getButtons().get(i)).getCell().toString()+ " You are now choosing a target");
		}
	}
	public void turnTarget(BoardPanel bp){
		for(int i=0;i<bp.getButtons().size();i++){
			bp.getButtons().get(i).setActionCommand("target");
			bp.getButtons().get(i).setToolTipText(((CellButton) bp.getButtons().get(i)).getCell().toString()+ " You are now choosing a point");
		}
	}
	public void turnMove(BoardPanel bp){
		for(int i=0;i<bp.getButtons().size();i++){
			bp.getButtons().get(i).setActionCommand("move");

			bp.getButtons().get(i).setToolTipText(((CellButton) bp.getButtons().get(i)).getCell().toString());
		}
	}
	
	public void saber(){
		File file=null;
			
			file=new File("light.wav");
			Clip c=null;
			
				try {
					c = AudioSystem.getClip();
				} catch (Exception e) {
				}
			
			try {
				c.open(AudioSystem.getAudioInputStream(file));
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
				
			}
			c.start();
			
		
		}
	public void blast(){
			File file=null;
				
				file=new File("blast.wav");
				Clip c=null;
				
					try {
						c = AudioSystem.getClip();
					} catch (Exception e) {
					}
				
				try {
					c.open(AudioSystem.getAudioInputStream(file));
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
					
				}
				c.start();
				
			
			
	}
	public void lightsaber(){
		File file=null;
			
			file=new File("lightsaber.wav");
			Clip c=null;
			
				try {
					c = AudioSystem.getClip();
				} catch (Exception e) {
				System.out.print("test");
				}
			
			try {
				c.open(AudioSystem.getAudioInputStream(file));
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
				
			}
			c.start();
			
		
		}
	public void growl(){
		File file=null;
			
			file=new File("growl.wav");
			Clip c=null;
			
				try {
					c = AudioSystem.getClip();
				} catch (Exception e) {
				}
			
			try {
				c.open(AudioSystem.getAudioInputStream(file));
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
				
			}
			c.start();
			
		
		}
	public void beep(){
		File file=null;
			
			file=new File("beep.wav");
			Clip c=null;
			
				try {
					c = AudioSystem.getClip();
				} catch (Exception e) {
				}
			
			try {
				c.open(AudioSystem.getAudioInputStream(file));
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
				
			}
			c.start();
			
		
		}
	public void whoosh(){
		File file=null;
			
			file=new File("whoosh.wav");
			Clip c=null;
			
				try {
					c = AudioSystem.getClip();
				} catch (Exception e) {
				}
			
			try {
				c.open(AudioSystem.getAudioInputStream(file));
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
				
			}
			c.start();
			
		
		}
	public void lightning(){
		File file=null;
			
			file=new File("lightning.wav");
			Clip c=null;
			
				try {
					c = AudioSystem.getClip();
				} catch (Exception e) {
				}
			
			try {
				c.open(AudioSystem.getAudioInputStream(file));
			} catch (LineUnavailableException | IOException | UnsupportedAudioFileException  | NullPointerException w) {
				
			}
			c.start();
			
		
		}
	
}
