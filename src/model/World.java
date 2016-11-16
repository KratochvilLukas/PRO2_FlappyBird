package model;

import java.util.ArrayList;

import interfaces.WorldListener;
import model.Bird;
import model.Heart;
import model.Tube;

public class World {
	
	public static final int SPEED = 100; 
	
	private Bird bird;
	private ArrayList<Tube> tubes;
	private ArrayList<Heart> hearts;
	private WorldListener worldListener;
	
	public World(Bird bird, WorldListener worldListener){
		
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener = worldListener;
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);
		if (bird.isOutOf()){
			worldListener.outOf();
		}
		for (Heart heart : hearts) {
			heart.update(deltaTime);
			if (bird.collideWith(heart)){
				worldListener.catchHeart(heart);
			}
		}
		for (Tube tube : tubes) {
			tube.update(deltaTime);
			if (bird.collideWith(tube)){
				worldListener.crashTube(tube);
			}
		}
		
	}
	
	public void addTube(Tube tube){
		tubes.add(tube);
	}
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	public void removeHeart(){
		hearts.remove(hearts.size()-1);
	}
	public String toString(){
		return bird.getName() + " je na pozici [" + bird.getPositionX() + "," + bird.getPositionY() + "], pocet trubek: " +
				tubes.size() + ", pocet srdicek: " + hearts.size();
	}
	public Bird getBird(){
		return bird;
	}
	public ArrayList<Heart> getHearts(){
		return hearts;
	}
	public ArrayList<Tube> getTubes(){
		return tubes;
	}
	

}

