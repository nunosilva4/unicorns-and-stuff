package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class StuffFactory {

    public static final int MAXSTUFF = 10;
    private static int currentNumberOfStuff;

    public static GameObject createNewStuff(StuffType stuffType, int x, int y, Player[] players) {

        if (currentNumberOfStuff >= MAXSTUFF) {
            return null;
        }

        currentNumberOfStuff++;

        switch (stuffType) {
            case TRAP:
                return new TrapStuff(x, y, players);
            case SHIT:
                break;
            case METEORS:
                break;
        }


        return null;
    }
}
