package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.GameObject;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.StuffFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.StuffType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardMap implements Map {

    private final Picture picture;

    public StandardMap() {
        picture = new Picture(Game.PADDING, Game.PADDING, "resources/rsz_cenas.png");
        picture.draw();
    }
}
