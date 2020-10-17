package org.academiadecodigo.gnunas.unicorns_and_stuff;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Handler;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.Map;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Map map;

    private Player[] players;

    public Game(MapType mapType) {
        map = MapFactory.makeMap(mapType);

        players = new Player[2];

        Picture[] playerOnePictures = {new Picture(250, 250, "resources/UniCorn/unicornLeft.png"), new Picture(250, 250, "resources/UniCorn/UnicornRight.png")};
        Picture[] playerTwoPictures = {new Picture(50, 50, "resources/NaziCorn/nazicornLeft.png"), new Picture(50, 50, "resources/NaziCorn/nazicornRight.png")};

        players[0] = new Player(Handler.getPlayerOneMovement(), playerOnePictures);
        players[1] = new Player(Handler.getPlayerTwoMovement(), playerTwoPictures);

        drawScreen(800, 600);

        process();
    }

    private void drawScreen(int width, int height) {
        Rectangle screen = new Rectangle(0,0,width,height);
        screen.draw();
    }

    private void process() {
        final int FRAMES_PER_SECOND = 120;
        final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;

        long nextGameTick = System.currentTimeMillis();

        long sleepTime = 0;

        boolean gameRunning = true;

        while( gameRunning ) {
            updateGame();
            render();

            nextGameTick += SKIP_TICKS;
            sleepTime = nextGameTick - System.currentTimeMillis();
            if( sleepTime >= 0 ) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void updateGame() {
        players[0].move();
        players[1].move();
    }

    private void render() {

    }
}