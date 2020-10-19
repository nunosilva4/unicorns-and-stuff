package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Direction;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.Map;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.TimerTask;

public abstract class GameObject {

    private final Rectangle rectangle;
    private final Player[] players;

    public GameObject(int x, int y, Player[] players) {
        rectangle = new Rectangle(x, y, 25, 25);

        this.players = players;
    }

    public void show() {
        rectangle.fill();
    }

    public void delete() {
        rectangle.delete();
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getHeight() {
        return rectangle.getHeight();
    }

    public int getWidth() {
        return rectangle.getWidth();
    }

    public Player[] getPlayers() {
        return players;
    }
}
