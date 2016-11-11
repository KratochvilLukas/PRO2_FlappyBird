package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JButton;
import javax.swing.Timer;

import game.Game;
import model.Bird;
import model.Heart;
import model.Tube;
import model.World;

public class GameScreen extends Screen {

	private long lastTimeMillis;
	private Timer timer;

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
				}else {
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
				}

			}
		});

		// WORLD
		Bird bird = new Bird("Bird", 240, 400);
		World world = new World(bird);

		world.addTube(new Tube(400, 400, Color.green));
		world.addTube(new Tube(600, 300, Color.green));
		world.addTube(new Tube(800, 500, Color.green));

		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));

		System.out.println(world);
		Canvas canvas = new Canvas(world);
		canvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);

		add(canvas);

		timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();

				float delta = (currentTimeMillis - lastTimeMillis)/1000.0f;
				world.update(delta);
				canvas.repaint();
				
				System.out.println(world.getBird().getPositionX());

				lastTimeMillis = currentTimeMillis;

			}
		});
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}
}
