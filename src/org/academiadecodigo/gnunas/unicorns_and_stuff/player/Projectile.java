package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Projectile {

    private boolean destroyed;
    private Ellipse projectileSprite;
    private int damageAmount;
    private Direction direction;
    private int projectileSpeed;
    private Player player;

    public Projectile(int x, int y, int damageAmount, Direction direction, Player player) {
        this.damageAmount = damageAmount;
        this.direction = direction;
        projectileSprite = new Ellipse(x, y, 17, 17);
        projectileSpeed = 4;
        this.player = player;
        projectileSprite.fill();
    }

    public boolean isHitting(Player player) {
        int playerBodyMaxX = player.getX() + player.getWidth() / 2;
        int playerBodyMinX = player.getX() - player.getWidth() / 2;
        int playerBodyMaxY = player.getY() + player.getHeight() / 2;
        int playerBodyMinY = player.getY() - player.getHeight() / 2;

        return getX() + Game.PADDING <= playerBodyMaxX &&
                getX() + Game.PADDING >= playerBodyMinX &&
                getY() + Game.PADDING <= playerBodyMaxY &&
                getY() + Game.PADDING >= playerBodyMinY;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void move() {
        if (hitsX() || hitsY()) {
            scheduleRemoval();
            return;
        }

        Player opponent = player == Game.getPlayers()[0] ? Game.getPlayers()[1] : Game.getPlayers()[0];

        if (isHitting(opponent)) {
            opponent.hit(damageAmount);
            scheduleRemoval();
            return;
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

    public void scheduleRemoval() {
        projectileSprite.delete();
        destroyed = true;
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

    private boolean hitsY() {
        return getY() + getHeight() >= Game.HEIGHT || getY() <= Game.PADDING;
    }

    private boolean hitsX() {
        return getX() + getWidth() >= Game.WIDTH || getX() <= Game.PADDING;
    }
}
