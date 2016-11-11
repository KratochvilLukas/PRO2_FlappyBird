package gui;

import javax.swing.JFrame;

import gui.Screen;

public class MainFrame extends JFrame {
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	
	protected Screen actualScreen;
	
	public MainFrame(){
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Flappy Bird Pro2");
		setResizable(false);
	}
	
	public void setScreen(Screen screen){
		if (actualScreen !=null){
			remove(actualScreen);
		}
		actualScreen = screen;
		add(screen);
		revalidate();
	}

}
