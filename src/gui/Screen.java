package gui;

import javax.swing.JPanel;

import gui.MainFrame;

public abstract class Screen extends JPanel {

	protected MainFrame mainFrame;

	public Screen(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setLayout(null);
	}

}
