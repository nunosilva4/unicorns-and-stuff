package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.map.Map;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;

public class Game {

    private Map map;

    public Game(MapType mapType) {
        map = MapFactory.makeMap(mapType);
    }

    //TODO everything else
}