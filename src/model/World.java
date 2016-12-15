package model;

import java.awt.*;
import java.util.ArrayList;

import model.Bird;
import model.Heart;
import model.Tube;

public class World {
	
	public static final int SPEED = 100;
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEARTS = 450;
	
	private Bird bird;
	private ArrayList<Tube> tubes;
	private ArrayList<Heart> hearts;
	private WorldListener worldListener;
	private boolean generated = false;
	
	public World(Bird bird, WorldListener worldListener){
		
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener = worldListener;
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);

		if (generated){
			regenerate();
		}

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
				tube.setCounted(true);
			}
			else{
				if(bird.getPositionX() > tube.getMaxX()){
					if(!tube.isCounted()){
						bird.addPoint();
						System.out.println("Score: " + bird.getScore());
						tube.setCounted(true);
					}

				}
			}
		}
		
	}

	public void generateRandom(){
		for(int i =0; i<3;i++){
			float x = (SPACE_BETWEEN_TUBES + i * SPACE_BETWEEN_TUBES);
			addTube(new Tube(x, Tube.getRandomHeight(), Color.GREEN));
		}

		addHeart(new Heart(SPACE_BETWEEN_HEARTS, Heart.getRandomY()));

		generated = true;
	}

	public void regenerate(){
		for(Tube tube : tubes){
			if (tube.getPositionX() < -100){
				tube.setPositionX(tube.getPositionX() + tubes.size()  * SPACE_BETWEEN_TUBES);
				tube.setHeight(Tube.getRandomHeight());
				tube.setCounted(false);
			}
		}

		for(Heart heart : hearts){
			if(heart.getHeart().getX() < -100){
				heart.setX((float)heart.getHeart().getX() + (hearts.size() +1)*SPACE_BETWEEN_HEARTS);
				heart.setY(Heart.getRandomY());
			}
		}
	}

	public void addHeart(Heart heart){
		hearts.add(heart);

	}
	public void addTube(Tube tube){
		tubes.add(tube);
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

