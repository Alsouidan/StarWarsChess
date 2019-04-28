package view;

import javax.swing.JButton;

import controller.StartListener;

public class PlayerOK extends JButton {
private boolean firstTime;
	public PlayerOK(String s,StartListener l,boolean firstTime) {
		super(s);
		setActionCommand("ok2");
		this.addActionListener(l);
		this.firstTime=firstTime;
	}
	public boolean isFirstTime() {
		return firstTime;
	}
	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}

}
