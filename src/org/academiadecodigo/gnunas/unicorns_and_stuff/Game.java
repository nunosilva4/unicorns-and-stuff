package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.map.Map;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class Game {

    private Map map;

    private Player[] players;

    public Game(MapType mapType) {
        map = MapFactory.makeMap(mapType);

        players = new Player[2];

        players[0] = new Player(50,50);
        players[1] = new Player(200, 200);
    }

    //TODO everything else
}