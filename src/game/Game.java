package game;

import gui.HomeScreen;
import gui.MainFrame;

public class Game {

	public static void main(String[] args) {
		
		MainFrame mainFrame = new MainFrame();
		HomeScreen homeScreen = new HomeScreen(mainFrame); 
		mainFrame.setScreen(homeScreen);
		

	}

}
