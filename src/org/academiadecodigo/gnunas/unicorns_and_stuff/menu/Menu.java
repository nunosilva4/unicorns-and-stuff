package org.academiadecodigo.gnunas.unicorns_and_stuff.menu;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {
    private Picture background;
    private Picture arrow;
    private Picture play;
    private Picture exit;
    private Keyboard keyboard;
    private KeyboardEvent goToQuit;
    private KeyboardEvent goToPlay;
    private KeyboardEvent pressKey;
    public static boolean draw;

    public Menu() {
        background = new Picture(Game.PADDING, Game.PADDING, "resources/Menu/background.jpg");
        arrow = new Picture(800/2 -150 -120,600/2 - 44, "resources/Menu/pixil-frame-0.png");
        play = new Picture(800/2 - 150,600/2 - 44, "resources/Menu/Play.jpg");
        exit = new Picture(800/2 - 150,600/2 + 44, "resources/Menu/Exit.jpg");
        keyboard = new Keyboard(this);

        //MOVE ARROW
        goToQuit = new KeyboardEvent();
        goToQuit.setKey(KeyboardEvent.KEY_Z);
        goToQuit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goToQuit);

        goToPlay = new KeyboardEvent();
        goToPlay.setKey(KeyboardEvent.KEY_X);
        goToPlay.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goToPlay);

        //START
        pressKey = new KeyboardEvent();
        pressKey.setKey(KeyboardEvent.KEY_C);
        pressKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressKey);

    }

    public void init() {
        background.draw();
        arrow.draw();
        play.draw();
        exit.draw();
    }

    //TODO: Make the movement by differences to be dynamic
    public void goToQuit() {
        arrow.translate(0, 88);
    }

    public void goToPlay() {
        arrow.translate(0, -88);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_Z && arrow.getX() == 800/2 -150 -120 && arrow.getY() == 600/2 -44) {
            goToQuit();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_X && arrow.getX() == 800/2 -150 -120 && arrow.getY() == 600/2 + 44) {
            goToPlay();
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_C && arrow.getX() == 800/2 -150 -120 && arrow.getY() == 600/2 - 44) {
            arrow.delete();
            background.delete();
            play.delete();
            exit.delete();
            draw = true;
            System.out.println("Entrar");
        }

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_C && arrow.getX() == 800/2 -150 -120 && arrow.getY() == 600/2 + 44) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
