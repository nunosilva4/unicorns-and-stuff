package org.academiadecodigo.gnunas.unicorns_and_stuff.input;

import org.academiadecodigo.gnunas.unicorns_and_stuff.menu.Menu;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Handler implements KeyboardHandler {

    private static Set<Direction> playerOneMovement;
    private static Set<Direction> playerTwoMovement;
    private static Set<Boolean> playerOneShooting;
    private static Set<Boolean> playerTwoShooting;

    public Handler() {
        playerOneMovement = new LinkedHashSet<>();
        playerTwoMovement = new LinkedHashSet<>();
        playerOneShooting = new LinkedHashSet<>();
        playerTwoShooting = new LinkedHashSet<>();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KEY_L:
                playerOneShooting.add(true);
                break;
            case KEY_UP:
                playerOneMovement.add(Direction.UP);
                break;
            case KEY_DOWN:
                playerOneMovement.add(Direction.DOWN);
                break;
            case KEY_LEFT:
                playerOneMovement.add(Direction.LEFT);
                break;
            case KEY_RIGHT:
                playerOneMovement.add(Direction.RIGHT);
                break;
            case KEY_W:
                playerTwoMovement.add(Direction.UP);
                break;
            case KEY_S:
                playerTwoMovement.add(Direction.DOWN);
                break;
            case KEY_A:
                playerTwoMovement.add(Direction.LEFT);
                break;
            case KEY_D:
                playerTwoMovement.add(Direction.RIGHT);
                break;
            case KEY_SPACE:
                playerTwoShooting.add(true);
                break;
            case KEY_Z:
                Menu.goToQuit();
                break;
            case KEY_X:
                Menu.goToPlay();
                break;
            case KEY_C:
                Menu.select();
                break;
            case KEY_ESC:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KEY_L:
                playerOneShooting.clear();
                break;
            case KEY_UP:
                playerOneMovement.remove(Direction.UP);
                break;
            case KEY_DOWN:
                playerOneMovement.remove(Direction.DOWN);
                break;
            case KEY_LEFT:
                playerOneMovement.remove(Direction.LEFT);
                break;
            case KEY_RIGHT:
                playerOneMovement.remove(Direction.RIGHT);
                break;
            case KEY_W:
                playerTwoMovement.remove(Direction.UP);
                break;
            case KEY_S:
                playerTwoMovement.remove(Direction.DOWN);
                break;
            case KEY_A:
                playerTwoMovement.remove(Direction.LEFT);
                break;
            case KEY_D:
                playerTwoMovement.remove(Direction.RIGHT);
            case KEY_SPACE:
                playerTwoShooting.clear();
        }
    }

    public static Set<Direction> getPlayerOneMovement() {
        return playerOneMovement;
    }

    public static Set<Direction> getPlayerTwoMovement() {
        return playerTwoMovement;
    }

    public static Set<Boolean> getPlayerOneShooting() {
        return playerOneShooting;
    }

    public static Set<Boolean> getPlayerTwoShooting() {
        return playerTwoShooting;
    }
}
