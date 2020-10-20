package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class ShitStuff extends GameObject {


    public ShitStuff(int x, int y) {
        super(x, y, "resources/Objects/shit.png");
    }

    @Override
    public void check() {
        for (Player player : Game.getPlayers()) {
            if (isHitting(player)) {
                System.out.println("Object hitting");
                return;
            }
        }
    }
}
