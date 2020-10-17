package org.academiadecodigo.gnunas.unicorns_and_stuff.input;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Handler implements KeyboardHandler {

    private static Set<Direction> playerOneMovement;
    private static Set<Direction> playerTwoMovement;

    public Handler() {
        playerOneMovement = new LinkedHashSet<>();
        playerTwoMovement = new LinkedHashSet<>();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
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
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
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
        }
    }

    public static Set<Direction> getPlayerOneMovement() {
        return playerOneMovement;
    }

    public static Set<Direction> getPlayerTwoMovement() {
        return playerTwoMovement;
    }
}
