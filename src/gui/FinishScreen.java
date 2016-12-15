package gui;

import game.ScoreManager;
import model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Krata on 15.12.2016.
 */
public class FinishScreen extends Screen {
    JLabel scoreLabel;
    JButton jButtonPlay = new JButton("PLAY");
    JButton jButtonScore = new JButton("SCORE");

    public FinishScreen(MainFrame mainFrame, World world) {
        super(mainFrame);

        scoreLabel = new JLabel(world.getBird().getScore() + "!");
        scoreLabel.setFont(new Font("Arial",Font.BOLD, 40));
        scoreLabel.setBounds(240, 100, 280, 50);

        ScoreManager.putScore(world.getBird().getScore());

        jButtonPlay.setBounds(100, 400, 280, 50);
        jButtonScore.setBounds(100, 450, 280, 50);

        jButtonPlay.addActionListener(e ->
                mainFrame.setScreen(new GameScreen(mainFrame)));

        jButtonScore.addActionListener(e ->
                mainFrame.setScreen(new ScoreScreen(mainFrame)));



        add(scoreLabel);
        add(jButtonPlay);
        add(jButtonScore);
    }
}
