package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class StuffFactory {

    public GameObject creatNewStuff(StuffType stuffType, MapType mapType, int x, int y, Player[] players) {

        switch (stuffType) {
            case TRAP:
                return new TrapStuff(x, y, mapType, players);
            case SHIT:
                break;
            case METEORS:
                break;
        }


        return null;
    }
}
