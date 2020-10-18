package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Projectile {
    private Ellipse projectile;
    private int x;
    private int y;
    private int damageAmount;
    private Direction direction;
    private int projectileSpeed;

    public Projectile(int x, int y, int damageAmount, Direction direction) {
        this.x = x;
        this.y = y;
        this.damageAmount = damageAmount;
        this.direction = direction;
        projectile = new Ellipse(x, y, 15, 15);
        projectileSpeed = 3;

        projectile.fill();
    }

    // TODO add different velocity
    public void move() {
        switch (direction) {
            case UP:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectile.translate(0, -1);
                }
                break;
            case DOWN:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectile.translate(0, 1);
                }
                break;
            case LEFT:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectile.translate(-1, 0);
                }
                break;
            case RIGHT:
                for (int i = 0; i < projectileSpeed; i++) {
                    projectile.translate(1, 0);
                }
                break;
        }
    }

    public int getX() {
        return projectile.getX();
    }

    public int getY() {
        return projectile.getY();
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    // TODO Erase from memory
    public void remove() {
        projectile.delete();
    }
}
