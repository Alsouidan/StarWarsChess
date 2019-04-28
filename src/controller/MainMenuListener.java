package controller;

import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import view.Fonts;
import view.MainMenu;
import view.StartFrame;

public class MainMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String s= ((JButton) e.getSource()).getActionCommand();
		switch(s){
		case "newgame":try {
			Fonts.font();
		} catch (FontFormatException | IOException e1) {}
		StartFrame sf=new StartFrame(new StartListener(),true);
		case "exit":Component c = (Component) e.getSource();
		MainMenu mm= ((MainMenu) SwingUtilities.getRoot(c));
		mm.dispose();if(mm.getClip()!=null)
			mm.getClip().stop();
		}
		
	}

}
