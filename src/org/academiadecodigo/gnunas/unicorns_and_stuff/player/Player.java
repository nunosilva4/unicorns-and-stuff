package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.Set;

public class Player {

    //Trying out stuff
    private Picture[] sprites;
    private Set<Direction> movement;
    private Direction lastDirection;
    private Picture currentSprite;

    public Player(Set<Direction> movement, Picture[] sprites) {
        this.sprites = sprites;
        this.movement = movement;

        currentSprite = sprites[0];
        sprites[0].draw();

    }

    public void move() {
        Iterator<Direction> iterator = movement.iterator();
        Direction direction = null;

        while (iterator.hasNext()){
            direction = iterator.next();
        }

        if (direction == null){
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
                currentSprite.translate(-1 , 0);
                break;
            case RIGHT:
                currentSprite.translate(1, 0);
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
