package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardMap implements Map {

    private final Picture picture;

    public StandardMap() {
        picture = new Picture(Game.PADDING, Game.PADDING, "resources/grass.jpg");
        picture.draw();
    }
}
