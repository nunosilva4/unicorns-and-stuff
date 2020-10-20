package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class TrapStuff extends GameObject {

    public TrapStuff(int x, int y) {
        super(x, y);
    }

    @Override
    public Player check() {
        for (Player player : Game.getPlayers()) {
            if (isHitting(player)) {
                return player;
            }
        }

        return null;
    }
}
