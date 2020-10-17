package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.Set;

public class Player {

    //Trying out stuff
    private String name;
    private Set<Direction> movement;
    private Direction lastDirection;
    private Picture currentSprite;
    private String[] imagePath;

    public Player(String name, Set<Direction> movement, Picture startingSprite, String[] imagePath) {
        this.imagePath = imagePath;
        this.movement = movement;
        this.name = name;

        currentSprite = startingSprite;
        currentSprite.draw();
    }

    public void move() {
        Iterator<Direction> iterator = movement.iterator();
        Direction direction = null;

        while (iterator.hasNext()) {
            direction = iterator.next();
        }

        if (direction == null) {
            return;
        }

        switch (direction) {
            case UP:
                currentSprite.translate(0, -1);
                break;
            case DOWN:
                currentSprite.translate(0, 1);
                break;
            case LEFT:
                currentSprite.translate(-1, 0);
                currentSprite.load(imagePath[0]);
                break;
            case RIGHT:
                currentSprite.translate(1, 0);
                currentSprite.load(imagePath[1]);
                break;
            default:
                break;
        }
    }

    public void attack() {
        Projectile projectile = new Projectile(getX(), getY(), 10, lastDirection);
    }

    public int getX() {
        return currentSprite.getX();
    }

    public int getY() {
        return currentSprite.getY();
    }
}
