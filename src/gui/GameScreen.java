package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import model.Bird;
import model.Heart;
import model.Tube;
import model.World;

public class GameScreen extends Screen implements model.WorldListener {

	private long lastTimeMillis;
	private Timer timer;
	private Bird bird;
	private JLabel jLabelScore;
	private JLabel jLabelLives;

	public GameScreen(MainFrame mainFrame) {

		super(mainFrame);

		JButton back = new JButton("BACK");
		back.setBounds(20, 20, 60, 60);
		back.setFont(new Font("Arial", Font.PLAIN, 7));
		JButton pause = new JButton("PAUSE");
		pause.setBounds(400, 20, 60, 60);
		pause.setFont(new Font("Arial", Font.PLAIN, 7));

		add(back);
		add(pause);

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));

			}
		});
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()) {
					timer.stop();
				} else {
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
				}

			}

		});
		jLabelLives = new JLabel("Lives: " + Bird.DEFAULT_LIVES);
		jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);

		jLabelLives.setBounds(260, 20, 120, 60);
		jLabelScore.setBounds(100, 20, 120, 60);

		add(jLabelLives);
		add(jLabelScore);




		// WORLD

		bird = new Bird("Bird", 150, 400);
		World world = new World(bird,this);
		world.generateRandom();

		
		Canvas canvas = new Canvas(world);
		canvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);

		canvas.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				bird.goUp();
			}

		});

		add(canvas);

		timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				long currentTimeMillis = System.currentTimeMillis();
				float delta = (currentTimeMillis - lastTimeMillis) / 1000.0f;
				world.update(delta);

				jLabelLives.setText("Lives: " + bird.getLives());
				jLabelScore.setText("Score: " + bird.getScore());

				if(!bird.isAlive()){
					timer.stop();
					mainFrame.setScreen(new FinishScreen(mainFrame,world));
				}
				canvas.repaint();


				lastTimeMillis = currentTimeMillis;

			}
		});
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}

	@Override
	public void outOf() {
		bird.setPositionY(MainFrame.HEIGHT);
		bird.setSpeed(bird.getFly() / 2);
		bird.removeLive();
		System.out.println("out of space");
		
	}
	
	@Override
	public void crashTube(Tube tube) {
		if(!tube.isDamaged()) {
			bird.removeLive();
		}

		
	}
	
	@Override
	public void catchHeart(Heart heart) {
		heart.setY(-100);
		bird.catchHeart();
		System.out.println("catch heart");
		
	}
}
