package model;

import java.awt.Color;
import java.awt.Graphics;

public class Bird {
	private String name;
	private int positionX,positionY;
	private float speed;
	private int lives;
	
	public Bird(String name,int x,int y){
		super();
		this.name = name;
		positionX = x;
		positionY = y;
		lives = 0;
		speed = 0;
	}
	
	public String getName(){
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
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		
		g.fillRect((int) (getPositionX())-25, (int)(getPositionY())-25, 50, 50);
	}
	
	public void update(float deltaTime){
		positionX += World.SPEED * deltaTime;
	}

	public void goUp(){
		
	}
	
	public void catchHeart(){
		
	}
	
	public void die(){
		
	}
	
	public void addLife(){
		
	}
	
	public void removeLife(){
		
	}
	
	
	

}
