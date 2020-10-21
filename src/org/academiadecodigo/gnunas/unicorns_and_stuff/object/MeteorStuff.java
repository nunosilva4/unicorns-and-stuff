package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class MeteorStuff extends GameObject {

    private final int DAMAGE = 20;

    public MeteorStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public void interact() {
        if (player == null) {
            return;
        }

        player.hit(DAMAGE);
    }

    public void move(){

    }
}
