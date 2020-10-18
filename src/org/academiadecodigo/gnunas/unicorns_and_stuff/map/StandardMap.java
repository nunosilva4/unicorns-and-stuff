package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardMap implements Map {
    private Picture picture;

    public StandardMap() {
        picture = new Picture(Game.PADDING, Game.PADDING, "resources/rsz_cenas.png");
        picture.draw();
    }
}
