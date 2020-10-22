package org.academiadecodigo.gnunas.unicorns_and_stuff.menu;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Key;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {
    private static boolean gameStarted;

    private Picture background;
    private static Picture arrow;
    private Picture play;
    private Picture exit;
    private Picture title;
    private Picture instructions;

    private Keyboard keyboard;

    public Menu() {
        background = new Picture(Game.PADDING, Game.PADDING, "resources/Menu/background.jpg");
        arrow = new Picture((float) Game.WIDTH / 2 - 150 - 120, (float) Game.HEIGHT / 2 - 44, "resources/Menu/pixil-frame-0.png");
        play = new Picture((float) Game.WIDTH / 2 - 150, (float) Game.HEIGHT / 2 - 44, "resources/Menu/Play.jpg");
        exit = new Picture((float) Game.WIDTH / 2 - 150, (float) Game.HEIGHT / 2 + 44, "resources/Menu/Exit.jpg");
        title = new Picture(60, 80, "resources/Menu/title.png");
        instructions = new Picture((float) Game.WIDTH - 250, (float) Game.HEIGHT - 260, "resources/Menu/instructions.png");
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
    public static void goToQuit() {
        if (arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 - 44) {
            arrow.translate(0, 88);
        }
    }

    public static void goToPlay() {
        if (arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 + 44) {
            arrow.translate(0, -88);
        }
    }

    public static void select() {
        if (!gameStarted && arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 - 44) {
            gameStarted = true;
            return;
        }

        if (!gameStarted && arrow.getX() == 800 / 2 - 150 - 120 && arrow.getY() == 600 / 2 + 44) {
            System.exit(0);
        }
    }


    public void clear() {
        arrow.delete();
        background.delete();
        play.delete();
        exit.delete();
        title.delete();
        instructions.delete();
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
}
