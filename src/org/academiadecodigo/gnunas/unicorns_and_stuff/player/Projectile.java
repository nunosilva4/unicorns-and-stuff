package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

import java.util.LinkedList;

public class Projectile {
    private Ellipse projectileSprite;
    private int damageAmount;
    private Direction direction;

    private Player player;

    public Projectile(int x, int y, int damageAmount, Direction direction, Player player) {
        this.damageAmount = damageAmount;
        this.direction = direction;

        this.player = player;

        projectileSprite = new Ellipse(x, y, 10, 10);
        projectileSprite.fill();
    }

    // TODO add different velocity
    public void move() {
        if (getX() - getWidth() >= Game.WIDTH || getX() <= 0) {
            remove(player.getProjectilesList());
        }

        if (getY() - getHeight() >= Game.HEIGHT || getY() <= 0) {
            remove(player.getProjectilesList());
        }

        switch (direction) {
            case UP:
                projectileSprite.translate(0, -1);
                break;
            case DOWN:
                projectileSprite.translate(0, 1);
                break;
            case LEFT:
                projectileSprite.translate(-1, 0);
                break;
            case RIGHT:
                projectileSprite.translate(1, 0);
                break;
        }
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
