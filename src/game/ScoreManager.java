package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreManager {

    public static ScoreManager instance;

    public void addScore(int score) {
        List<Integer> scoreList = getAll();
        scoreList.add(score);
        FileWriter filewriter;

        try {
            filewriter = new FileWriter(Game.SCORE_FILE);
            for (int value : scoreList) {
                filewriter.append(String.valueOf(value));
                filewriter.append(";");
                filewriter.append(new Date().toGMTString());
                filewriter.append("\n");
            }
            filewriter.flush();
            filewriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getAll() {
        List<Integer> scoreList = new ArrayList<>();
        FileReader fileReader;
        try {
            fileReader = new FileReader(Game.SCORE_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            for(int i=0;i<10;i++) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split(";");
                    scoreList.add(Integer.valueOf(values[0]));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return scoreList;
    }

    public static ScoreManager getInstance(){
        if (instance == null){
            instance = new ScoreManager();
        }
        return instance;
    }

    public static void putScore(int score){
        getInstance().addScore(score);


    }

    public static List<Integer> getList(){
        return getInstance().getAll();
    }

    public static int getItemsNumber(){
        return ScoreManager.getList().size();
    }

    public static int getItemsIndex(int i){
        return ScoreManager.getList().get(i);
    }
}
