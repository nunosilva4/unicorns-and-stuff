package org.academiadecodigo.gnunas.unicorns_and_stuff.menu;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Key;
import org.academiadecodigo.gnunas.unicorns_and_stuff.sound.Sound;
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
        background = new Picture(Game.PADDING, Game.PADDING, "resources/menu/background.jpg");
        arrow = new Picture((float) Game.WIDTH / 2 - 150 - 120, (float) Game.HEIGHT / 2 - 44, "resources/menu/pixil-frame-0.png");
        play = new Picture((float) Game.WIDTH / 2 - 150, (float) Game.HEIGHT / 2 - 44, "resources/menu/Play.jpg");
        exit = new Picture((float) Game.WIDTH / 2 - 150, (float) Game.HEIGHT / 2 + 44, "resources/menu/Exit.jpg");
        title = new Picture(60, 80, "resources/menu/title.png");
        instructions = new Picture((float) Game.WIDTH - 250, (float) Game.HEIGHT - 260, "resources/menu/instructions.png");

        Sound sound = new Sound("/resources/sound/vodka.wav");
        sound.play(true);
        sound.setLoop(10);
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
