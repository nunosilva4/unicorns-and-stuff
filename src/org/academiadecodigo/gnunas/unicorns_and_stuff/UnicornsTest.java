package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.sound.Sound;

public class UnicornsTest {
    public static void main(String[] args) {

        /*Sound sound = new Sound("/resources/Sound/sound.wav");
        sound.play(true);
        */
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Game(MapType.STANDARD);
    }
}
