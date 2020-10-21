package org.academiadecodigo.gnunas.unicorns_and_stuff.animation;

public class Animation {

    public static final int FRAME_RATE = 10;

    String[] cutieImagePathLeft = new String[]{
            "resources/cutiecornLeft/cutiecornLeft00.png",
            "resources/cutiecornLeft/cutiecornLeft01.png",
            "resources/cutiecornLeft/cutiecornLeft02.png",
            "resources/cutiecornLeft/cutiecornLeft03.png",
            "resources/cutiecornLeft/cutiecornLeft04.png",
            "resources/cutiecornLeft/cutiecornLeft05.png",
    };

    String[] cutieImagePathRight = new String[]{
            "resources/cutiecornRight/cutiecornRight00.png",
            "resources/cutiecornRight/cutiecornRight01.png",
            "resources/cutiecornRight/cutiecornRight02.png",
            "resources/cutiecornRight/cutiecornRight03.png",
            "resources/cutiecornRight/cutiecornRight04.png",
            "resources/cutiecornRight/cutiecornRight05.png",
    };

    String[] cutieImagePathFront = new String[]{
            "resources/cutiecornFront/cutiecornFront00.png",
            "resources/cutiecornFront/cutiecornFront01.png",
            "resources/cutiecornFront/cutiecornFront02.png",
    };

    String[] cutieImagePathBack = new String[]{
            "resources/cutiecornBack/cutiecornBack00.png",
            "resources/cutiecornBack/cutiecornBack01.png",
            "resources/cutiecornBack/cutiecornBack02.png",
    };

    String[] nazicornImagePathLeft = new String[]{
            "resources/nazicorn2Left/nazicorn2Left.png",
            "resources/nazicorn2Left/nazicorn2Left01.png",
            "resources/nazicorn2Left/nazicorn2Left02.png",
            "resources/nazicorn2Left/nazicorn2Left03.png",
            "resources/nazicorn2Left/nazicorn2Left04.png",
            "resources/nazicorn2Left/nazicorn2Left05.png",
    };

    String[] nazicornImagePathRight = new String[]{
            "resources/nazicorn2Right/nazicorn2Right00.png",
            "resources/nazicorn2Right/nazicorn2Right01.png",
            "resources/nazicorn2Right/nazicorn2Right02.png",
            "resources/nazicorn2Right/nazicorn2Right03.png",
            "resources/nazicorn2Right/nazicorn2Right04.png",
            "resources/nazicorn2Right/nazicorn2Right05.png",
    };

    String[] nazicornImagePathFront = new String[]{
            "resources/nazicorn2Front/nazicorn2Front00.png",
            "resources/nazicorn2Front/nazicorn2Front01.png",
            "resources/nazicorn2Front/nazicorn2Front02.png",
    };

    String[] nazicornImagePathBack = new String[]{
            "resources/nazicorn2Back/nazicorn2Back00.png",
            "resources/nazicorn2Back/nazicorn2Back01.png",
            "resources/nazicorn2Back/nazicorn2Back02.png",
    };

    public String[] getCutieImagePathBack() {
        return cutieImagePathBack;
    }

    public String[] getCutieImagePathFront() {
        return cutieImagePathFront;
    }

    public String[] getCutieImagePathLeft() {
        return cutieImagePathLeft;
    }

    public String[] getCutieImagePathRight() {
        return cutieImagePathRight;
    }

    public String[] getNazicornImagePathBack() {
        return nazicornImagePathBack;
    }

    public String[] getNazicornImagePathFront() {
        return nazicornImagePathFront;
    }

    public String[] getNazicornImagePathLeft() {
        return nazicornImagePathLeft;
    }

    public String[] getNazicornImagePathRight() {
        return nazicornImagePathRight;
    }
}
