package controller;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.game.Game;
import view.CellButton;
import view.SuperButton;

public abstract class SuperListener implements ActionListener {
public Game getGame(ActionEvent e){
	return ((SuperButton) e.getSource()).getGame();
}
public JPanel getJPanel(ActionEvent e){
	return (JPanel) (((JButton) e.getSource()).getParent());
}
public JButton getButton(ActionEvent e){
	return (JButton) e.getSource();
}

}
