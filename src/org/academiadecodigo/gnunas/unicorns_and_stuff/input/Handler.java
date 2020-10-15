package org.academiadecodigo.gnunas.unicorns_and_stuff.input;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ArrayList;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Handler implements KeyboardHandler {

    private ArrayList<MovementType> playerOneMovement;
    private ArrayList<MovementType> playerTwoMovement;

    //TODO finish constructor and implement keybindings and behaviour
    public Handler() {
        playerOneMovement = new ArrayList<>();
        playerTwoMovement = new ArrayList<>();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KEY_UP:
                playerOneMovement.add(MovementType.UP);
                break;
            case KEY_DOWN:
                //TODO register
                break;
            case KEY_LEFT:
                //TODO register
                break;
            case KEY_RIGHT:
                //TODO register
                break;
            case KEY_W:
                //TODO register
                break;
            case KEY_S:
                //TODO register
                break;
            case KEY_A:
                //TODO register
                break;
            case KEY_D:
                //TODO register

                //TODO finish rest of the keybinds

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
