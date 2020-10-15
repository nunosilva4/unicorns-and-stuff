package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.map.Map;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Map map;

    private Player[] players;

    public Game(MapType mapType) {
        map = MapFactory.makeMap(mapType);

        players = new Player[2];

        players[0] = new Player(50,50);
        players[1] = new Player(200, 200);

        drawScreen(800, 600);
    }

    private void drawScreen(int width, int height) {
        Rectangle screen = new Rectangle(0,0,width,height);
        screen.draw();
    }

    private void process() {
        final int FRAMES_PER_SECOND = 60;
        final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;

        long next_game_tick = System.currentTimeMillis();

        long sleep_time = 0;

        boolean game_is_running = true;

        while( game_is_running ) {
            update_game();
            display_game();

            next_game_tick += SKIP_TICKS;
            sleep_time = next_game_tick - System.currentTimeMillis();
            if( sleep_time >= 0 ) {
                try {
                    Thread.sleep(sleep_time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void update_game() {

    }

    private void display_game() {

    }
}