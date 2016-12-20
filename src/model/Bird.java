package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gui.Canvas;
import gui.MainFrame;

public class Bird {


    public static final int DEFAULT_SCORE = 0;
    public static final int DEFAULT_LIVES = 3;
    private static final int GRAVITY = 500;
    private static final int FLY = 750;
    private static final int BODY_SIZE = 65;

    private String name;
    private Rectangle body;
    private float speed;
    private int lives;
    private int score;

    public Bird(String name, float x, float y) {
        super();
        this.name = name;
        body = new Rectangle((int) x, (int) y, BODY_SIZE, BODY_SIZE);
        lives = DEFAULT_LIVES;
        score = DEFAULT_SCORE;
        speed = FLY / 2;
    }

    public void paint(Graphics g, BufferedImage img) {
        g.setColor(Color.BLUE);
        g.drawImage(img, body.x, body.y, BODY_SIZE, BODY_SIZE, null);
    }

    public void update(float deltaTime) {
        body.y -= speed * deltaTime;
        body.y += GRAVITY * deltaTime;
        speed -= speed * deltaTime;
    }

    public boolean isOutOf() {
        if (body.getY() > Canvas.BOUND_UP && body.getY() < MainFrame.HEIGHT - Canvas.BOUND_DOWN) {
            return false;
        } else
            return true;
    }


    public void goUp() {
        speed = FLY;
    }


    public boolean collideWith(Tube tube) {

        return body.intersects(tube.getTopRectangle()) || body.intersects(tube.getBottomRectangle());

    }

    public boolean collideWith(Heart heart) {

        return body.intersects(heart.getHeart());
    }


    public void catchHeart() {
        lives++;
    }

    public void addPoint() {
        score++;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getLives() {
        return lives;
    }

    public int getPositionX() {
        return body.x;
    }

    public void setPositionY(int positionY) {
        body.y = positionY;
    }

    public int getScore() {
        return score;
    }

    public void removeLive() {
        lives--;
    }

    public int getFly() {
        return FLY;
    }
}
