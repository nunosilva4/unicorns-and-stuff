package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.gnunas.unicorns_and_stuff.simple_gfx.SimpleGfxStandardMap;

public class MapFactory {

    public static Map makeMap(MapType mapType) {
        switch (mapType) {
            case STANDARD:
                return new SimpleGfxStandardMap();
            default:
                //TODO continue implementation
                return null;
        }
    }
}
