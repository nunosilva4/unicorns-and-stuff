package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapCollision;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Player {

    private String name;
    private Set<Direction> movement;
    private Direction lastDirection;

    // TODO change to Game class?
    private LinkedList<Projectile> projectiles;

    private Picture currentSprite;
    private String[] imagePath;
    private int health = 100;

    public Player(String name, Set<Direction> movement, Picture startingSprite, String[] imagePath) {
        this.name = name;
        this.movement = movement;
        if (this.name.equals("Unicorn")) {
            this.lastDirection = Direction.LEFT;
        }
        if (this.name.equals("Nazicorn")) {
            this.lastDirection = Direction.RIGHT;
        }
        projectiles = new LinkedList<>();
        this.imagePath = imagePath;
        currentSprite = startingSprite;
        currentSprite.draw();
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void hit(int damage) {
        if (health > 0) {
            health = health - damage;
        }
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

        if (movement.contains(Direction.UP) && movement.contains(Direction.LEFT)) {
            if (MapCollision.hittingLeft(this) || MapCollision.hittingTop(this)) {
                return;
            }
            currentSprite.translate(-1, -1);
            currentSprite.load(imagePath[0]);
            return;
        }

        if (movement.contains(Direction.UP) && movement.contains(Direction.RIGHT)) {
            if (MapCollision.hittingRight(this) || MapCollision.hittingTop(this)) {
                return;
            }
            currentSprite.translate(1, -1);
            currentSprite.load(imagePath[1]);
            return;
        }

        if (movement.contains(Direction.DOWN) && movement.contains(Direction.LEFT)) {
            if (MapCollision.hittingLeft(this) || MapCollision.hittingBottom(this)) {
                return;
            }
            currentSprite.translate(-1, 1);
            currentSprite.load(imagePath[0]);
            return;
        }

        if (movement.contains(Direction.DOWN) && movement.contains(Direction.RIGHT)) {
            if (MapCollision.hittingRight(this) || MapCollision.hittingBottom(this)) {
                return;
            }
            currentSprite.translate(1, 1);
            currentSprite.load(imagePath[1]);
            return;
        }

        switch (direction) {
            case UP:
                lastDirection = Direction.UP;
                if (MapCollision.hittingTop(this)) {
                    break;
                }
                currentSprite.translate(0, -1);
                break;
            case DOWN:
                lastDirection = Direction.DOWN;
                if (MapCollision.hittingBottom(this)) {
                    break;
                }
                currentSprite.translate(0, 1);
                break;
            case LEFT:
                lastDirection = Direction.LEFT;
                if (MapCollision.hittingLeft(this)) {
                    break;
                }
                currentSprite.translate(-1, 0);
                currentSprite.load(imagePath[0]);
                break;
            case RIGHT:
                lastDirection = Direction.RIGHT;
                if (MapCollision.hittingRight(this)) {
                    break;
                }
                currentSprite.translate(1, 0);
                currentSprite.load(imagePath[1]);
                break;
            default:
                break;
        }
    }

    public void shoot() {
        if (!projectiles.isEmpty()){
            return;
        }
        projectiles.add(new Projectile(getX(), getY(), 10, lastDirection));
    }

    //TODO Understand what would be the best place for this method, change to Game class?
    public void updateProjectile() {
        for (Projectile projectile : projectiles) {

            if (projectile.getX() >= Game.WIDTH + Game.PADDING || projectile.getX() <= Game.PADDING) {
                projectile.remove();
                projectiles.remove(projectile);
                continue;
            }
            if (projectile.getY() >= Game.HEIGHT + Game.PADDING || projectile.getY() <= Game.PADDING) {
                projectile.remove();
                projectiles.remove(projectile);
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

    public int getHeight() {
        return currentSprite.getHeight();
    }

    public int getWidth() {
        return currentSprite.getWidth();
    }

}
