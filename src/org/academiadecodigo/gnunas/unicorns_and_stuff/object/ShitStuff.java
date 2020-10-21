package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class ShitStuff extends GameObject {

    public ShitStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public void interact() {
        if (player == null) {
            return;
        }

        player.setSliding(true);
    }

    @Override
    public void delete() {
        if (player != null) {
            player.setSliding(false);
        }

        super.delete();
    }
}
