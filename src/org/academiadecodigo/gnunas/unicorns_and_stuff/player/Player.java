package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    //Trying out stuff
    private PlayerMovement direction;
    private Picture[] sprites;
    private final int NUMBER_OF_PICTURES = 8;

    public Player(int x, int y) {
        sprites = new Picture[NUMBER_OF_PICTURES];

        sprites[0] = new Picture(x, y, "resources/unicorn.png");
        sprites[0].draw();
    }

}
