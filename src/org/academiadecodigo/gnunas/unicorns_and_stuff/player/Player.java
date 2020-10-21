package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.animation.Animation;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapCollision;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.*;

public class Player {

    private Game game;
    private final String name;
    private final Set<Direction> movement;
    private Direction lastDirection;
    private Picture currentSprite;
    private String[] imagePath;
    private String[] imagePathRight;
    private String[] imagePathLeft;
    private String[] imagePathFront;
    private String[] imagePathBack;
    private int health = 100;
    private final Set<Boolean> shooting;
    private boolean dead;
    private boolean stunned;
    private boolean sliding;
    private int lives;
    private Animation animation;
    private short frame = 0;

    private final List<Projectile> projectiles;

    public Player(String name, Set<Direction> movement, Set<Boolean> shooting, Game game) {
        lives = 3;
        this.game = game;
        this.name = name;
        this.shooting = shooting;
        this.movement = movement;
        animation = new Animation();

        if (this.name.equals("Unicorn")) {
            currentSprite = new Picture(Game.WIDTH - 100, 300, "resources/cutiecornLeft/cutiecornLeft00.png");

            imagePath = new String[]{
                    "resources/cutiecornLeft/cutiecornLeft00.png",
                    "resources/cutiecornRight/cutiecornRight00.png"
            };

            imagePathFront = animation.getCutieImagePathFront();
            imagePathBack = animation.getCutieImagePathBack();
            imagePathRight = animation.getCutieImagePathRight();
            imagePathLeft = animation.getCutieImagePathLeft();

            this.lastDirection = Direction.LEFT;
        }
        if (this.name.equals("Nazicorn")) {
            currentSprite = new Picture(50, 300, "resources/nazicorn2Right/nazicorn2Right00.png");

            imagePath = new String[]{
                    "resources/nazicorn2Left/nazicorn2Left.png",
                    "resources/nazicorn2Right/nazicorn2Right00.png"
            };

            imagePathFront = animation.getNazicornImagePathFront();
            imagePathBack = animation.getNazicornImagePathBack();
            imagePathRight = animation.getNazicornImagePathRight();
            imagePathLeft = animation.getNazicornImagePathLeft();

            this.lastDirection = Direction.RIGHT;
        }
        projectiles = new LinkedList<>();
        Objects.requireNonNull(currentSprite).draw();
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
            if (name.equals("Unicorn")) {
                game.getPlayerOneHp().setText(String.valueOf(health));
            }
            if (name.equals("Nazicorn")) {
                game.getPlayerTwoHp().setText(String.valueOf(health));
            }
            System.out.println("HIT");
        }
    }

    public void move() {
        if (dead) {
            return;
        }

        if (stunned) {
            return;
        }

        Iterator<Direction> iterator = movement.iterator();
        Direction direction = null;

        while (iterator.hasNext()) {
            direction = iterator.next();
        }

        if (isSliding()) {
            direction = lastDirection;
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
                frame++;
                if (frame % Animation.FRAME_RATE == 0) {
                    currentSprite.load(imagePathBack[frame / Animation.FRAME_RATE % imagePathBack.length]);
                }
                break;
            case DOWN:
                lastDirection = Direction.DOWN;
                if (MapCollision.hittingBottom(this)) {
                    break;
                }
                currentSprite.translate(0, 1);
                frame++;
                if (frame % Animation.FRAME_RATE == 0) {
                    currentSprite.load(imagePathFront[frame / Animation.FRAME_RATE % imagePathFront.length]);
                }
                break;
            case LEFT:
                lastDirection = Direction.LEFT;
                if (MapCollision.hittingLeft(this)) {
                    break;
                }
                currentSprite.translate(-1, 0);
                frame++;
                if (frame % Animation.FRAME_RATE == 0) {
                    currentSprite.load(imagePathLeft[frame / Animation.FRAME_RATE % imagePathLeft.length]);
                }
                break;
            case RIGHT:
                lastDirection = Direction.RIGHT;
                if (MapCollision.hittingRight(this)) {
                    break;
                }
                currentSprite.translate(1, 0);
                frame++;
                if (frame % Animation.FRAME_RATE == 0) {
                    currentSprite.load(imagePathRight[frame / Animation.FRAME_RATE % imagePathRight.length]);
                }
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

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public void setSliding(boolean sliding) {
        this.sliding = sliding;
    }

    public boolean isStunned() {
        return stunned;
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

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isSliding() {
        return sliding;
    }
}
