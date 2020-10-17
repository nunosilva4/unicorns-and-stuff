package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.Set;

public class Player {

    //Trying out stuff
    private Picture[] sprites;
    private final int NUMBER_OF_PICTURES = 8;
    private Set<Direction> movement;
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

        switch (direction){
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
}
