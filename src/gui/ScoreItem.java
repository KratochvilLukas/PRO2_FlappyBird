package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Krata on 15.12.2016.
 */
public class ScoreItem extends JPanel {

    JLabel jLabelIndex, jLabelScore,jLabelMax;

    public ScoreItem(int index, int score,boolean max){
        if (!max) {
            jLabelIndex = new JLabel(index+1  + ": ");
            jLabelScore = new JLabel(String.valueOf(score + "!"));

            jLabelIndex.setFont(new Font("Arial", Font.BOLD, 40));

            jLabelScore.setFont(new Font("Arial", Font.BOLD, 40));

            add(jLabelIndex);
            add(jLabelScore);
        }else{
            jLabelMax = new JLabel("Best: " + score);

            jLabelMax.setFont(new Font("Arial",Font.BOLD,60));

            add(jLabelMax);
        }
    }
}
