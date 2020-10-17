package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Player {

    //Trying out stuff
    private String name;

    private Set<Direction> movement;
    private Direction lastDirection;

    // TODO change to Game class?
    private LinkedList<Projectile> projectiles;

    private Picture currentSprite;
    private String[] imagePath;

    public Player(String name, Set<Direction> movement, Picture startingSprite, String[] imagePath) {
        this.name = name;

        this.movement = movement;
        if (this.name == "Unicorn") {this.lastDirection = Direction.LEFT;}
        if (this.name == "Nazicorn") {this.lastDirection = Direction.RIGHT;}

        projectiles = new LinkedList<>();

        this.imagePath = imagePath;
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

    public void shoot() {
        projectiles.add(new Projectile(getX(), getY(), 10, lastDirection));
    }

    //TODO Understand what would be the best place for this method, change to Game class?
    public void updateProjectile() {
        for (Projectile projectile : projectiles) {
            if(projectile.getX() >= Game.WIDTH || projectile.getX() <= 0) {
                projectiles.remove(projectile);
                projectile.remove();
                continue;
            }

            projectile.move();
        }
    }

    public int getX() {
        return currentSprite.getX() + currentSprite.getWidth() / 2;
    }

    public int getY() {
        return currentSprite.getY() + currentSprite.getHeight() / 2;
    }
}
