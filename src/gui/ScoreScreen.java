package gui;

import game.ScoreManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen {
    public ScoreScreen(MainFrame mainFrame) {
        super(mainFrame);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Arial", Font.PLAIN, 7));
        back.setBounds(20, 20, 60, 60);
        back.addActionListener(e ->
                mainFrame.setScreen(new HomeScreen(mainFrame)));
        add(back);
        int max = ScoreManager.getItemsIndex(0);
        int position = 0;
        for (int i = 0; i < ScoreManager.getItemsNumber(); i++) {
            if (ScoreManager.getItemsIndex(i)>max){
                max = ScoreManager.getItemsIndex(i);
                position = i;
            }
        }
        ScoreItem scoreItemMax = new ScoreItem(position,max,true);
        scoreItemMax.setBounds(50,100,300,100);
        add(scoreItemMax);
        for (int i = 0; i < 5; i++) {
            int score = ScoreManager.getItemsIndex(i);

            ScoreItem scoreItem = new ScoreItem(i, score,false);
            scoreItem.setBounds(50, 200 + i * 50, 300, 50);

            add(scoreItem);
        }
    }

}
