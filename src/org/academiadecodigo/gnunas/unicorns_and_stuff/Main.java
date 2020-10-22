package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.KeyBindings;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.menu.Menu;
import org.academiadecodigo.gnunas.unicorns_and_stuff.sound.Sound;

public class Main {
    public static void main(String[] args) {

        KeyBindings.init();
        Menu menu = new Menu();
        Game game = new Game();

        while (!menu.isGameStarted()){
            menu.init();
        }

        menu.clear();
        game.start(MapType.STANDARD, 3, 3);
    }
}
