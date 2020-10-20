package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public abstract class GameObject {

    private final Rectangle rectangle;

    public GameObject(int x, int y) {
        rectangle = new Rectangle(x, y, 25, 25);
    }

    public abstract void check();

    public void show() {
        rectangle.fill();
    }

    public void delete() {
        rectangle.delete();
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
        return rectangle.getX() + getWidth() / 2;
    }

    public int getY() {
        return rectangle.getY() + getHeight() / 2;
    }

    public int getHeight() {
        return rectangle.getHeight();
    }

    public int getWidth() {
        return rectangle.getWidth();
    }

}
