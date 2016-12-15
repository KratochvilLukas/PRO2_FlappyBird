package game;

import gui.HomeScreen;
import gui.MainFrame;

import java.io.File;
import java.io.IOException;

public class Game {

	public static final String SCORE_FILE = "scores.csv";

	public static void main(String[] args) {

		File file = new File(SCORE_FILE);

		if(!file.exists()){
			try {
				file.createNewFile();
			}catch (IOException e){
				System.out.println("Nejde vytvorit soubor");
			}
		}
		
		MainFrame mainFrame = new MainFrame();
		HomeScreen homeScreen = new HomeScreen(mainFrame); 
		mainFrame.setScreen(homeScreen);
		

	}

}
