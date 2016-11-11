package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen {
	public ScoreScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton back = new JButton("BACK");
		add(back);
		back.setBounds(20,20,60,60);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
				
			}
		});
	}

}
