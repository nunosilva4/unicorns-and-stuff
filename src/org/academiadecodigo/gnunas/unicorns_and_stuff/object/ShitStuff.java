package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class ShitStuff extends GameObject {

    public ShitStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public Player check() {
        Player player = super.check();
        if (player == null) {
            return null;
        }

        player.setSliding(true);

        return player;
    }

    @Override
    public void delete() {
        Player player = super.check();
        if (player != null) {
            player.setSliding(false);
        }

        super.delete();
    }
}
