package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardMap implements Map {
    private Picture picture;

    public StandardMap() {
        picture = new Picture(0, 0, "resources/background.jpg");
        picture.draw();
    }
}
