package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.game.Game;

public class HelpFrame extends JFrame  {
public HelpFrame (Game g){
	setSize(1000,700);
	setVisible(true);
	getContentPane().setLayout(new GridLayout(27,1));
	ArrayList <JLabel> jl=new ArrayList() ;
	JLabel jl1=new JLabel("1-To win ,one must reach a Payload of 6");jl.add(jl1);
	JLabel jl2=new JLabel("2-Eliminating a hero advances your Paylod by one");jl.add(jl2);
	JLabel jl3=new JLabel ("3-Your Payload advances by one evry two Sidekick eliminations");jl.add(jl3);
	JLabel jl4=new JLabel("4-Player 1 is Lightside(Blue) , Player 2 is Darkside (Red)");jl.add(jl4);
	JLabel jl5=new JLabel("5-To move choose a direction then a piece");jl.add(jl5);
	JLabel jl6= new JLabel("6-A Speedster moves 2 cells in any direction");jl.add(jl6);
	JLabel jl7= new JLabel("7-A Ranged can move in any direction");jl.add(jl7);
	JLabel jl8=new JLabel("8-An Armored can move in any direction");jl.add(jl8);
	JLabel jl9=new JLabel("9-A Medic can only move up, right,left and down");jl.add(jl9);
	JLabel jl10=new JLabel("10-A Tech can only move in diagonals");jl.add(jl10);
	JLabel jl11=new JLabel("11-A Super can only move up, right,left and down");jl.add(jl11);
	JLabel jl12=new JLabel("12-Lightside's SideKick can't move down, downleft and downright");jl.add(jl12);
	JLabel jl13=new JLabel("13-Darkside's SideKick can't move up, upleft and upright");jl.add(jl13);
	JLabel jl14=new JLabel("14-An Armored is eliminated after two attacks");jl.add(jl14);
	JLabel jl26=new JLabel("15-The shield next to the Armored indicates whether he has taken his first hit or not");jl.add(jl26);
	JLabel jl15= new JLabel("16-If a SideKick eliminates a hero, it is promoted to that hero");jl.add(jl15);
	JLabel jl16=new JLabel("17-You can use the special ability of a hero by clicking the lightsaber then the hero who will use their power");jl.add(jl16);
	JLabel jl17=new JLabel("18-Special abilities can be used once per game");jl.add(jl17);
	JLabel jl25=new JLabel ("19-The Sword on the left of the heroes indicate whether they can use their ability ot not");jl.add(jl25);
	JLabel jl18=new JLabel("20-A Ranged can shoot his blaster up,down,left or right eliminating the first enemy");jl.add(jl18);
	JLabel jl19=new JLabel("21-A Medic can resurrect a dead piece in any direction");jl.add(jl19);
	JLabel jl20=new JLabel ("22-A Super can use his lightsaber to attack two enemies in a specified direction: up,left,right or down");jl.add(jl20);
	JLabel jl21=new JLabel("23-A Tech can use his ability to hack an enemy's ability or to restore an ally's ability ");jl.add(jl21);
	JLabel jl22=new JLabel("24-A tech can also teleport a friendly piece to any empty cell on the board");jl.add(jl22);
	JLabel jl23=new JLabel ("25-After clicking on the lightsaber and the hero ,choose direction,target and point respectivley if needed");jl.add(jl23);
	JLabel jl24=new JLabel("26-once you made all decisions and are ready to use the special ability, click on the lightsaber again to confirm ");jl.add(jl24);
	for(int i=0;i<jl.size();i++){
		jl.get(i).setFont(new Font("Star Jedi",Font.PLAIN,12));jl.get(i).setForeground(Color.YELLOW);
		getContentPane().add(jl.get(i));
	}
	getContentPane().add(new GotItButton ("Got it",g));
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	getContentPane().setBackground(Color.BLACK);
	setLocationRelativeTo(null);
	revalidate();
	repaint();
	
}
}
