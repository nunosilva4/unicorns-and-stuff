package org.academiadecodigo.gnunas.unicorns_and_stuff.input;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import java.util.ArrayList;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Handler implements KeyboardHandler {

    private ArrayList<MovementType> playerOneMovement;
    private ArrayList<MovementType> playerTwoMovement;

    public Handler() {
        playerOneMovement = new ArrayList<>();
        playerTwoMovement = new ArrayList<>();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KEY_UP:
                if (!playerOneMovement.contains(MovementType.UP)) {
                    playerOneMovement.add(MovementType.UP);
                }
                break;
            case KEY_DOWN:
                if (!playerOneMovement.contains(MovementType.DOWN)) {
                    playerOneMovement.add(MovementType.DOWN);
                }
                break;
            case KEY_LEFT:
                if (!playerOneMovement.contains(MovementType.LEFT)) {
                    playerOneMovement.add(MovementType.LEFT);
                }
                break;
            case KEY_RIGHT:
                if (!playerOneMovement.contains(MovementType.RIGHT)) {
                    playerOneMovement.add(MovementType.RIGHT);
                }
                break;
            case KEY_W:
                if (!playerTwoMovement.contains(MovementType.UP)) {
                    playerTwoMovement.add(MovementType.UP);
                }
                break;
            case KEY_S:
                if (!playerTwoMovement.contains(MovementType.DOWN)) {
                    playerTwoMovement.add(MovementType.DOWN);
                }
                break;
            case KEY_A:
                if (!playerTwoMovement.contains(MovementType.LEFT)) {
                    playerTwoMovement.add(MovementType.LEFT);
                }
                break;
            case KEY_D:
                if (playerTwoMovement.contains(MovementType.RIGHT)) {
                    playerTwoMovement.add(MovementType.RIGHT);
                    break;
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KEY_UP:
                playerOneMovement.remove(MovementType.UP);
                break;
            case KEY_DOWN:
                playerOneMovement.remove(MovementType.DOWN);
                break;
            case KEY_LEFT:
                playerOneMovement.remove(MovementType.LEFT);
                break;
            case KEY_RIGHT:
                playerOneMovement.remove(MovementType.RIGHT);
                break;
            case KEY_W:
                playerTwoMovement.remove(MovementType.UP);
                break;
            case KEY_S:
                playerTwoMovement.remove(MovementType.DOWN);
                break;
            case KEY_A:
                playerTwoMovement.remove(MovementType.LEFT);
                break;
            case KEY_D:
                playerTwoMovement.remove(MovementType.RIGHT);
        }
    }
}
