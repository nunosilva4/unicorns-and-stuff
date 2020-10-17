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

        Picture playerOnePicture = new Picture(725, 275, "resources/Unicorn/unicornLeft.png");
        Picture playerTwoPicture = new Picture(20, 275, "resources/Nazicorn/nazicornRight.png");

        String[] playerOneImagePaths = {
                "resources/Unicorn/unicornLeft.png",
                "resources/Unicorn/unicornRight.png"
        };

        String[] playerTwoImagePaths = {
                "resources/Nazicorn/nazicornLeft.png",
                "resources/Nazicorn/nazicornRight.png"
        };

        players[0] = new Player("Unicorn", Handler.getPlayerOneMovement(), playerOnePicture, playerOneImagePaths);
        players[1] = new Player("Nazicorn", Handler.getPlayerTwoMovement(), playerTwoPicture, playerTwoImagePaths);

        drawScreen(800, 600);

        process();
    }

    private void drawScreen(int width, int height) {
        Rectangle screen = new Rectangle(0, 0, width, height);
        screen.draw();
    }

    private void process() {
        final int FRAMES_PER_SECOND = 120;
        final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;

        long nextGameTick = System.currentTimeMillis();

        long sleepTime = 0;

        boolean gameRunning = true;

        while (gameRunning) {
            updateGame();
            render();

            nextGameTick += SKIP_TICKS;
            sleepTime = nextGameTick - System.currentTimeMillis();
            if (sleepTime >= 0) {
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