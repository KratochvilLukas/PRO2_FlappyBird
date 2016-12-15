package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import gui.Canvas;
import gui.MainFrame;

public class Tube {

	private static final int GAP = 200;
	private static final int WIDTH = 50;

	private float height;
	private Color color;
	private boolean counted;



	private Rectangle topRectangle;
	private Rectangle bottomRectangle;

	public Tube(float positionX, float height, Color color) {
		super();
		bottomRectangle = new Rectangle((int)positionX - WIDTH/2, (int) height+Canvas.BOUND_DOWN, WIDTH, (int) ((MainFrame.HEIGHT - height-Canvas.BOUND_DOWN) ));
		topRectangle = new Rectangle((int) positionX -WIDTH/2, 0+Canvas.BOUND_UP, WIDTH, (int) height - GAP-Canvas.BOUND_UP);
		this.height = height;
		this.color = color;
	}

	public void paint(Graphics g, BufferedImage img) {
		g.drawImage(img,(int)topRectangle.getX(), (int)topRectangle.getY(), (int)topRectangle.getWidth(),
				(int)topRectangle.getHeight(), null);
		g.drawImage(img,(int) bottomRectangle.getX(), (int) bottomRectangle.getY(), (int) bottomRectangle.getWidth(),
				(int) bottomRectangle.getHeight(),null);
	}

	public void update(float deltaTime) {
		topRectangle.x -= World.SPEED * deltaTime;
		bottomRectangle.x -= World.SPEED * deltaTime;
	}

	public void setCounted(boolean counted) {

		this.counted = counted;
	}

	public int getMaxX(){

		return bottomRectangle.x + (WIDTH / 2);
	}

	public static float getRandomHeight(){

		return (new Random().nextInt(MainFrame.HEIGHT-GAP)+GAP);
	}

	public boolean isCounted() {

		return counted;
	}

	public int getMinX(){

		return bottomRectangle.x - (WIDTH / 2);
	}

	public float getPositionX() {

		return bottomRectangle.x;
	}

	public void setPositionX(float positionX) {

		bottomRectangle.x = (int) positionX;
		topRectangle.x = (int) positionX;
	}

	public void setHeight(float randomHeight) {
		this.height = randomHeight;
	}

	public float getHeight() {

		return height;
	}

	public Color getColor() {

		return color;
	}


	public int getCenterY(){
		return (int) (height - GAP/2.0);
	}

	public Rectangle getTopRectangle() {
		return topRectangle;
	}

	public Rectangle getBottomRectangle() {
		return bottomRectangle;
	}
}
