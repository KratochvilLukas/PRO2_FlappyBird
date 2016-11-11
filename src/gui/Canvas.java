package gui;


import java.awt.Graphics;


import model.Bird;
import model.Heart;
import model.Tube;
import model.World;

public class Canvas extends java.awt.Canvas{
	
	private World world;
	
	public Canvas(World world){
		this.world = world;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		world.getBird().paint(g);
		for (Heart heart : world.getHearts()) {
			heart.paint(g);
		}
		for (Tube tube : world.getTubes()){
			tube.paint(g);
		}
	}
	

}
