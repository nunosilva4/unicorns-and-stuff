package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class MapFactory {

    public static Map makeMap(MapType mapType, Player[] players) {

        switch (mapType) {
            case STANDARD:
                return new StandardMap(players, 10);
            default:
                //TODO continue implementation when there are new maps
                throw new IllegalArgumentException();
        }
    }
}