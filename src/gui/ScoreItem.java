package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Krata on 15.12.2016.
 */
public class ScoreItem extends JPanel {

    JLabel jLabelIndex, jLabelScore;

    public ScoreItem(int index, int score){
        jLabelIndex = new JLabel(index + ": ");
        jLabelScore = new JLabel(String.valueOf(score + "!"));

        jLabelIndex.setFont(new Font("Arial",Font.BOLD, 40));
        jLabelIndex.setBounds(240, 100, 280, 50);

        jLabelScore.setFont(new Font("Arial",Font.BOLD, 40));
        jLabelScore.setBounds(240, 100, 280, 50);

        add(jLabelIndex);
        add(jLabelScore);
    }
}
