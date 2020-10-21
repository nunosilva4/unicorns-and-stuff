package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class TrapStuff extends GameObject {

    public TrapStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public Player check() {
        Player player = super.check();
        if (player == null) {
            return null;
        }

        player.setStunned(true);

        return player;
    }

    @Override
    public void delete() {
        Player player = super.check();
        if (player != null) {
            player.setStunned(false);
        }

        super.delete();
    }
}
