package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.menu.Menu;
import org.academiadecodigo.gnunas.unicorns_and_stuff.sound.Sound;

public class Main {
    public static void main(String[] args) {

        Sound sound = new Sound("/resources/Sound/omerda.wav");
        sound.play(true);
        sound.setLoop(10);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();

        while (!Menu.gameStarted){
            menu.init();
        }
        new Game().start(MapType.STANDARD, 3, 3);

    }
}
