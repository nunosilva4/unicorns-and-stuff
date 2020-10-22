package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

public class MapFactory {

    public static Map makeMap(MapType mapType) {

        switch (mapType) {
            case STANDARD:
                return new StandardMap();
            default:
                throw new IllegalArgumentException();
        }
    }
}