package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gui.MainFrame;

public class Bird {

	private static final int GRAVITY = 300;
	private static final int FLY = 500;

	private String name;
	private int positionX, positionY;
	private float speed;
	private int lives;

	public Bird(String name, int x, int y) {
		super();
		this.name = name;
		positionX = x;
		positionY = y;
		lives = 0;
		speed = 1;
	}

	public void update(float deltaTime) {
		positionY -= speed * deltaTime;
		positionY += GRAVITY * deltaTime;

		speed -= speed * deltaTime;
	}

	public void goUp() {
		speed += FLY;
	}

	public String getName() {
		return name;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		Rectangle rectangle = getRectangle();

		g.fillRect((int) rectangle.getX() - 25, (int) rectangle.getY() - 25,(int) rectangle.getWidth(),
				(int)rectangle.getHeight());
	}

	public Rectangle getRectangle() {
		return new Rectangle((int) getPositionX() - 25, (int) getPositionY() - 25, 50, 50);
	}
	public boolean collideWith (Tube tube){
		Rectangle rectangle = getRectangle();
		return rectangle.intersects(tube.getBottomRectangle());
	}
	public boolean collideWith(Heart heart){
		return getRectangle().intersects(heart.getRectangle());
	}
	public boolean isOutOf(){
		return getRectangle().contains(new Rectangle(MainFrame.HEIGHT, MainFrame.WIDTH));
	}

	public void catchHeart() {

	}

	public void die() {

	}

	public void addLife() {

	}

	public void removeLife() {

	}

}
