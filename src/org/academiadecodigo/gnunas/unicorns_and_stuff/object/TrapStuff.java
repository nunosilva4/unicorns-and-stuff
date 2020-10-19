package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;


public class TrapStuff extends GameObject {

    private final int DAMAGE = 10;

    public TrapStuff(int x, int y, Player[] players) {
        super(x, y, players);
    }

    public void hit() {
        for (Player player : getPlayers()){
            if (!player.isDead()){
                player.hit(DAMAGE);
            }
        }
    }


}
