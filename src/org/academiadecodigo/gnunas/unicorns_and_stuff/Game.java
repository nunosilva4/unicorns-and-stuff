package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Handler;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.KeyBindings;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.Map;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.*;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Projectile;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.*;

import static org.academiadecodigo.gnunas.unicorns_and_stuff.object.StuffFactory.createNewStuff;

public class Game {

    private Map map;

    private static Player[] players;
    private static LinkedHashMap<GameObject, Player> stuffList;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int PADDING = 10;
    private Timer stuffTimer;
    private Text playerOneHp = new Text(WIDTH - 200, HEIGHT + 20, "100");
    private Text playerTwoHp = new Text(220, HEIGHT + 20, "100");
    private Text playerOneLives = new Text(WIDTH - 80, HEIGHT + 20, "Lives: ");
    private Text playerTwoLives = new Text(50, HEIGHT + 20, "");
    private static boolean gameFinished = false;

    public void start(MapType mapType, int playerOneLives, int playerTwoLives) {
        KeyBindings.init();
        new Text(WIDTH - 250, HEIGHT + 20, "Health:").draw();
        playerOneHp.draw();
        new Text(170, HEIGHT + 20, "Health:").draw();
        playerTwoHp.draw();
        this.playerOneLives.setText("Lives: " + playerOneLives);
        this.playerTwoLives.setText("Lives: " + playerTwoLives);
        this.playerOneLives.draw();
        this.playerTwoLives.draw();

        map = MapFactory.makeMap(mapType);

        stuffList = new LinkedHashMap<>();

        players = new Player[2];

        players[0] = new Player("Unicorn", Handler.getPlayerOneMovement(), Handler.getPlayerOneShooting(), this);
        players[1] = new Player("Nazicorn", Handler.getPlayerTwoMovement(), Handler.getPlayerTwoShooting(), this);

        players[0].setLives(playerOneLives);
        players[1].setLives(playerTwoLives);

        stuffTimer = new Timer();

        stuffTimer.scheduleAtFixedRate(createStuff(), 300, 2000);

        drawScreen();

        process();
    }

    private void drawScreen() {
        Rectangle screen = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        screen.draw();
    }

    private void process() {
        final int FRAMES_PER_SECOND = 240;
        final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;

        long nextGameTick = System.currentTimeMillis();

        long sleepTime;

        boolean gameRunning = true;

        while (gameRunning) {
            try {
                updateGame();

                nextGameTick += SKIP_TICKS;
                sleepTime = nextGameTick - System.currentTimeMillis();
                if (sleepTime >= 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException | ConcurrentModificationException e) {
                e.getMessage(); //not doing anything on purpose
            }
        }
    }

    private void updateGame() {
        for (GameObject stuff : stuffList.keySet()) {
            if (stuffList.get(stuff) != null) {
                continue;
            }

            Player player = stuff.process();
            if (player == null) {
                continue;
            }

            stuffList.put(stuff, player);
        }

        for (Player player : players) {
            player.move();
            player.shoot();

            Iterator<Projectile> iterator = player.getProjectilesList().iterator();

            while (iterator.hasNext()) {
                Projectile projectile = iterator.next();
                if (projectile.isDestroyed()) {
                    iterator.remove();
                }
                projectile.move();

            }

            if (player.isDead()) {
                if (player.getLives() > 0) {
                    player.setLives(player.getLives() - 1);
                    playerOneHp.setText("100");
                    playerTwoHp.setText("100");
                    while (true) {
                        stuffList.clear();
                        start(MapType.STANDARD, players[0].getLives(), players[1].getLives());
                    }
                }
                gameFinished = true;
                player.getCurrentSprite().load("resources/grave.png");
            }
        }
    }

    private TimerTask createStuff() {
        return new TimerTask() {
            @Override
            public void run() {
                if (gameFinished){
                    return;
                }
                GameObject gameObject = createNewStuff(StuffType.values()[getRandomNumber(StuffType.values().length)], getRandomNumber(50, WIDTH - 50),
                        getRandomNumber(50, HEIGHT - 50));
                if (gameObject == null) {
                    return;
                }
                gameObject.show();
                stuffList.put(gameObject, null);

                stuffTimer.schedule(deleteStuff(), 5000);
            }
        };
    }

    private TimerTask deleteStuff() {
        return new TimerTask() {
            @Override
            public void run() {
                for (GameObject stuff : stuffList.keySet()) {
                    stuff.delete();
                    stuffList.remove(stuff);
                    break;
                }
            }
        };
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int getRandomNumber(int max) {
        return (int) (Math.random() * max);
    }

    public static Player[] getPlayers() {
        return players;
    }

    public Text getPlayerOneHp() {
        return playerOneHp;
    }

    public Text getPlayerTwoHp() {
        return playerTwoHp;
    }

}