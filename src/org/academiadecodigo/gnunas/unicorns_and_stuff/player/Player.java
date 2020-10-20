package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapCollision;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.*;

public class Player {

    private String name;
    private Set<Direction> movement;
    private Direction lastDirection;
    private Picture currentSprite;
    private String[] imagePath;
    private int health = 100;
    private Set<Boolean> shooting;
    private boolean dead;

    private List<Projectile> projectiles;

    public Player(String name, Set<Direction> movement, Picture startingSprite, String[] imagePath, Set<Boolean> shooting) {
        this.name = name;
        this.shooting = shooting;
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
        if (health <= 0) {
            dead = true;
        }
        return health <= 0;
    }

    public void hit(int damage) {
        if (health > 0) {
            health -= damage;
            System.out.println("HIT");
        }
    }

    public void move() {
        if (dead) {
            return;
        }

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
        if (playerIsShooting()) {
            if (isDead() || cantShoot()) {
                return;
            }
            projectiles.add(new Projectile(getX(), getY(), 10, lastDirection, this));
        }
    }

    public List<Projectile> getProjectilesList() {
        return projectiles;
    }

    public int getX() {
        return currentSprite.getX() + currentSprite.getWidth() / 2;
    }

    public int getY() {
        return currentSprite.getY() + currentSprite.getHeight() / 2;
    }

    public int getWidth() {
        return currentSprite.getWidth();
    }

    public int getHeight() {
        return currentSprite.getHeight();
    }

    private boolean playerIsShooting() {
        return shooting.contains(true);
    }

    private boolean cantShoot() {
        return !projectiles.isEmpty();
    }

    public Picture getCurrentSprite() {
        return currentSprite;
    }

    public int getHealth() {
        return health;
    }
}
