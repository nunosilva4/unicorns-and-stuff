package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Projectile {
    private Ellipse projectile;
    private int x;
    private int y;
    private int damageAmount;
    private Direction direction;

    public Projectile(int x, int y, int damageAmount, Direction direction) {
        this.x = x;
        this.y = y;
        this.damageAmount = damageAmount;
        this.direction = direction;
        this.projectile = new Ellipse(x, y, 50, 50);
    }

    public void move() {
        switch (direction) {
            case UP:
                projectile.translate(0, -1);
                break;
            case DOWN:
                projectile.translate(0, 1);
                break;
            case LEFT:
                projectile.translate(-1, 0);
                break;
            case RIGHT:
                projectile.translate(1, 0);
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamageAmount() {
        return damageAmount;
    }


}
