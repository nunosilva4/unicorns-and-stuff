package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;

public class StuffFactory {

    public static GameObject createNewStuff(StuffType stuffType, int x, int y) {
        switch (stuffType) {
            case TRAP:
                return Math.random() < 0.6 ? new TrapStuff(x, y, "resources/Stuff/trappy.png") : new MeteorStuff(x, Game.PADDING, "resources/Objects/meteor.png");
            case SHIT:
                return Math.random() < 0.6 ? new ShitStuff(x, y, "resources/Stuff/poopy.png") : new MeteorStuff(x, Game.PADDING, "resources/Objects/meteor.png");
            case METEORS:
                return new MeteorStuff(x, Game.PADDING + Game.getRandomNumber(Game.PADDING, Game.HEIGHT / 4), "resources/Objects/meteor.png");
        }
        return null;
    }
}
