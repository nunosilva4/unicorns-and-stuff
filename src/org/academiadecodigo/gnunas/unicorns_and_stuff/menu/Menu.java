package org.academiadecodigo.gnunas.unicorns_and_stuff.menu;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Key;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {
    private boolean gameStarted;

    private Picture background;
    private Picture arrow;
    private Picture play;
    private Picture exit;
    private Picture title;
    private Picture instructions;

    private Keyboard keyboard;

    public Menu() {

        keyboard = new Keyboard(this);

        background = new Picture(Game.PADDING, Game.PADDING, "resources/Menu/background.jpg");
        arrow = new Picture((float) Game.WIDTH / 2 - 150 - 120, (float) Game.HEIGHT / 2 - 44, "resources/Menu/pixil-frame-0.png");
        play = new Picture((float) Game.WIDTH / 2 - 150, (float) Game.HEIGHT / 2 - 44, "resources/Menu/Play.jpg");
        exit = new Picture((float) Game.WIDTH / 2 - 150, (float) Game.HEIGHT / 2 + 44, "resources/Menu/Exit.jpg");
        title = new Picture(60, 80, "resources/Menu/title.png");
        instructions = new Picture((float) Game.WIDTH - 250, (float) Game.HEIGHT - 260, "resources/Menu/instructions.png");

        Key.Z.init(keyboard, KeyboardEventType.KEY_PRESSED); //Arrow goes down!
        Key.X.init(keyboard, KeyboardEventType.KEY_PRESSED); //Arrow goes up!
        Key.C.init(keyboard, KeyboardEventType.KEY_PRESSED); //Press key!
        Key.ESC.init(keyboard, KeyboardEventType.KEY_PRESSED); //Leave game!
    }

    public void init() {
        background.draw();
        arrow.draw();
        play.draw();
        exit.draw();
        title.draw();
        instructions.draw();
    }

    //TODO: Make the movement by differences to be dynamic
    public void goToQuit() {
        arrow.translate(0, 88);
    }

    public void goToPlay() {
        arrow.translate(0, -88);
    }

    public void clear() {
        arrow.delete();
        background.delete();
        play.delete();
        exit.delete();
        title.delete();
        instructions.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Z &&
                arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 - 44) {

            goToQuit();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_X &&
                arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 + 44) {

            goToPlay();
        }

        if (!gameStarted && keyboardEvent.getKey() == KeyboardEvent.KEY_C &&
                arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 - 44) {

            gameStarted = true;
        }

        if (!gameStarted && keyboardEvent.getKey() == KeyboardEvent.KEY_C &&
                arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 + 44) {

            System.exit(0);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_ESC) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
}
