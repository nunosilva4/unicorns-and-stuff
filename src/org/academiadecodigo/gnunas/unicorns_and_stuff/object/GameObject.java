package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public abstract class GameObject {

    private final Rectangle picture;

    public GameObject(int x, int y) {
        picture = new Rectangle(x, y, 25, 25);
    }

    public abstract Player check();

    public void show() {
        picture.fill();
    }

    public void delete() {
        picture.delete();
    }

    public boolean isHitting(Player player) {
        int playerBodyMaxX = player.getX() + player.getWidth() / 2;
        int playerBodyMinX = player.getX() - player.getWidth() / 2;
        int playerBodyMaxY = player.getY() + player.getHeight() / 2;
        int playerBodyMinY = player.getY() - player.getHeight() / 2;

        return (getX() - (getWidth() / 2)) + (getWidth() / 2) + Game.PADDING <= playerBodyMaxX &&
                (getX() - (getWidth() / 2)) + (getWidth() / 2) + Game.PADDING >= playerBodyMinX &&
                (getY() - (getHeight() / 2)) + (getHeight() / 2) + Game.PADDING <= playerBodyMaxY &&
                (getY() - (getHeight() / 2)) + (getHeight() / 2) + Game.PADDING >= playerBodyMinY;
    }

    public int getX() {
        return picture.getX() + getWidth() / 2;
    }

    public int getY() {
        return picture.getY() + getHeight() / 2;
    }

    public int getHeight() {
        return picture.getHeight();
    }

    public int getWidth() {
        return picture.getWidth();
    }
}
