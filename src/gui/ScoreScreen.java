package gui;

import game.ScoreManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen {
	public ScoreScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JButton back = new JButton("BACK");
		back.setFont(new Font("Arial", Font.PLAIN, 7));
		add(back);
		back.setBounds(20,20,60,60);
		back.addActionListener(e ->
				mainFrame.setScreen(new HomeScreen(mainFrame)));

		for(int i = 0; i< ScoreManager.getItemsNumber(); i++){
			int score = ScoreManager.getItemsIndex(i);

			ScoreItem scoreItem = new ScoreItem(i, score);
			scoreItem.setBounds(50, 200 + i *50, 300, 50);

			add(scoreItem);
		}
	}

}
