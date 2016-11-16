package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Heart {

	private float positionX, positionY;

	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public Rectangle getRectangle() {
		return new Rectangle((int) getPositionX() - 25, (int) getPositionY() - 25, 50, 50);
	}

	public void update(float deltaTime) {
		positionX -= World.SPEED * deltaTime;
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);

		Rectangle rectangle = getRectangle();

		g.fillRect((int) rectangle.getX() - 25, (int) rectangle.getY() - 25, (int) rectangle.getWidth(),
				(int) rectangle.getHeight());
	}

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

}
