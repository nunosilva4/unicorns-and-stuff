package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

import java.util.LinkedList;
import java.util.TimerTask;

public class StuffFactory {

    public static final int NUMBEROFMAXSTUFF = 2;
    public static int CURRENTNUMBEROFSTUFF = 0;

    public static GameObject createNewStuff(StuffType stuffType, int x, int y) {
        switch (stuffType) {
            case TRAP:
                return new TrapStuff(x, y);
            case SHIT:
                break;
            case METEORS:
                break;
        }

        return null;
    }
}
