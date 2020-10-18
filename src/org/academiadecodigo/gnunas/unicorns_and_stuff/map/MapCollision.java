package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public abstract class MapCollision {

    public static boolean hittingTop(Player player) {
        return player.getY() - (player.getHeight() / 2) <= Game.PADDING;
    }

    public static boolean hittingBottom(Player player) {
        return player.getY() + (player.getHeight() / 2) >= Game.HEIGHT + Game.PADDING;
    }

    public static boolean hittingLeft(Player player) {
        return player.getX() - (player.getWidth() / 2) <= Game.PADDING;
    }

    public static boolean hittingRight(Player player) {
        return player.getX() + (player.getWidth() / 2) >= Game.WIDTH + Game.PADDING;
    }
}
