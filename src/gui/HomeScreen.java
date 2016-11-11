package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {
	
	
	
	public HomeScreen(MainFrame mainFrame){
		super(mainFrame);
		
		JLabel label = new JLabel("Fim BIRD");
		label.setFont(new Font("Arial",Font.BOLD,40));
		label.setBounds(10, 10, 460, 100);
		
		JButton play = new JButton("PLAY");
		play.setBounds(100, 400, 280, 50);
		JButton score = new JButton("SCORE");
		score.setBounds(100,460,280,50);
		JButton sound = new JButton("SOUND");
		sound.setBounds(100,520,280,50);
		
		add(play);
		add(score);
		add(sound);
		add(label);
		
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
				
			}
		});
		score.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));
				
			}
		});
		sound.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
	}
	

}
