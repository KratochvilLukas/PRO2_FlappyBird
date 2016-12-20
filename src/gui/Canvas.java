package gui;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import model.Bird;
import model.Heart;
import model.Tube;
import model.World;

import javax.imageio.ImageIO;

public class Canvas extends java.awt.Canvas {

    private World world;

    private BufferedImage imageBird;
    private BufferedImage imageHeart;
    private BufferedImage imageTube;
    private BufferedImage imageTop;
    private BufferedImage imageBottom;
    private BufferedImage imageBackground;
    private BufferedImage countedTube;

    public static final int BOUND_UP = 100;
    public static final int BOUND_DOWN = 50;

    public Canvas(World world) {
        this.world = world;

        try {
            imageBird = ImageIO.read(new File("src/pictures/bird.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imageHeart = ImageIO.read(new File("src/pictures/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imageTube = ImageIO.read(new File("src/pictures/tube.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            countedTube = ImageIO.read(new File("src/pictures/tube2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imageTop = ImageIO.read(new File("src/pictures/top.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imageBottom = ImageIO.read(new File("src/pictures/bottom.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imageBackground = ImageIO.read(new File("src/pictures/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
        }
        Graphics g = bs.getDrawGraphics();

        paintGraphics(g);
        g.dispose();
        bs.show();
    }

    @Override
    public void paint(Graphics g) {
        render();

    }

    public void paintGraphics(Graphics g) {
        super.paint(g);
        g.drawImage(imageBackground, 0, BOUND_UP, MainFrame.WIDTH, MainFrame.HEIGHT - BOUND_DOWN - BOUND_UP, null);
        world.getBird().paint(g, imageBird);
        g.drawImage(imageTop, 0, 0, MainFrame.WIDTH, BOUND_UP, null);
        g.drawImage(imageBottom, 0, MainFrame.HEIGHT - BOUND_DOWN, MainFrame.WIDTH, BOUND_DOWN, null);

        for (Heart heart : world.getHearts()) {
            heart.paint(g, imageHeart);
        }
        for (Tube tube : world.getTubes()) {
            if (tube.isDamaged()) {
                tube.paint(g, countedTube);
            } else {
                tube.paint(g, imageTube);
            }

        }

    }


}
