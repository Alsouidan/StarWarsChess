package controller;

import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.game.Player;
import view.Fonts;
import view.GameFrame;
import view.PlayerOK;
import view.PlayerPanel;
import view.StartFrame;

public class StartListener implements ActionListener {

	
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		JPanel jp=(JPanel) ((JButton) e.getSource()).getParent();
		switch(s){
		
		case "ok2":try {
			Fonts.font();
		} catch (FontFormatException | IOException e1) {
			
		}
			startgame(((PlayerPanel) jp).getInp().getText(),((PlayerPanel) jp).getInp1().getText(),e,((PlayerOK) e.getSource()).isFirstTime());
			;break;
		}
	}
	public void startgame(String s1,String s2, ActionEvent e,boolean firstTime){
		Component component = (Component) e.getSource();
		StartFrame sf=((StartFrame) SwingUtilities.getRoot(component));
        sf.setP1(new Player (s1));
        sf.setP2(new Player (s2));
        GameFrame gf=new GameFrame(sf.getP1(),sf.getP2(),firstTime);
        sf.dispose();
	}
}
