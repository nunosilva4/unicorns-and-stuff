package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

import java.util.LinkedList;

public class Projectile {
    private Ellipse projectileSprite;
    private int damageAmount;
    private Direction direction;
    private int projectileSpeed;

    private Player player;

    public Projectile(int x, int y, int damageAmount, Direction direction, Player player) {
        this.damageAmount = damageAmount;
        this.direction = direction;
        projectileSprite = new Ellipse(x, y, 15, 15);
        projectileSpeed = 3;
        this.player = player;
        projectileSprite.fill();
    }

    // TODO add different velocity
    public void move() {
        if (getX() + (getWidth() / 2) >= Game.WIDTH - Game.PADDING || getX() <= Game.PADDING) {
            remove(player.getProjectilesList());
        }

        if (getY() - (getHeight() / 2) >= Game.HEIGHT - Game.PADDING || getY() <= Game.PADDING) {
            remove(player.getProjectilesList());
        }

        switch (direction) {
            case UP:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(0, -1);
                }
                break;
            case DOWN:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(0, 1);
                }
                break;
            case LEFT:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(-1, 0);
                }
                break;
            case RIGHT:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectileSprite.translate(1, 0);
                }

        }
    }

    public void hit(Player player) {
        player.hit(damageAmount);

        remove(player.getProjectilesList());
    }

    // TODO Erase from memory
    public void remove(LinkedList<Projectile> projectiles) {
        projectiles.remove(this);
        projectileSprite.delete();
    }

    public int getX() {
        return projectileSprite.getX();
    }

    public int getY() {
        return projectileSprite.getY();
    }

    public int getWidth() {
        return projectileSprite.getWidth();
    }

    public int getHeight() {
        return projectileSprite.getHeight();
    }

    public int getDamageAmount() {
        return damageAmount;
    }
}
