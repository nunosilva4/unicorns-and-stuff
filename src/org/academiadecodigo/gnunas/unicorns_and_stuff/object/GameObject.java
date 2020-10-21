package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public abstract class GameObject {

    protected Player player;

    private final Picture picture;

    public GameObject(int x, int y, String string) {
        picture = new Picture(x, y, string);
    }

    public abstract void interact();

    public Player checkPlayer() {
        for (Player player : Game.getPlayers()) {
            if (isHitting(player)) {
                this.player = player;
                picture.delete();
                interact();
                return player;
            }
        }

        return null;
    }

    public void show() {
        picture.draw();
    }

    public void delete() {
        picture.delete();
    }

    public boolean isHitting(Player player) {
        return getX() + Game.PADDING <= player.getX() &&
                getY() + Game.PADDING >= player.getY();
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
