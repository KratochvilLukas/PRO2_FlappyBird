package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Heart {

	private static final int SIZE = 50;

	private Rectangle heart;

	public Heart(float positionX, float positionY) {
		super();
		heart = new Rectangle((int) positionX - SIZE/2, (int) positionY - SIZE/2, SIZE, SIZE);
	}

	public void update(float deltaTime) {
		heart.x -= World.SPEED * deltaTime;
	}

	public void paint(Graphics g, BufferedImage img) {
		g.drawImage(img,heart.x, heart.y, SIZE, SIZE, null);
	}

	public static float getRandomY(){
		return (new Random().nextFloat()*300) + 200;
	}

	public Rectangle getHeart() {
		return heart;
	}
	public void setX(float x){
		heart.x = (int) x;
	}
	public void setY(float y){
		heart.y = (int) y;
	}
}
