package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

public class StuffFactory {

    public static GameObject createNewStuff(StuffType stuffType, int x, int y) {
        switch (stuffType) {
            case TRAP:
                return new TrapStuff(x, y);
            case SHIT:
                break;
            case METEORS:
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return null;
    }
}
