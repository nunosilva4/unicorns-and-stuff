package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Handler;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.sound.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.sound.Sound;

public class UnicornsTest {
    public static void main(String[] args) {

        Sound sound = new Sound("/resources/Sound/test.wav");
        sound.play(true);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Handler keyBindings = new Handler();
        Keyboard keyboard = new Keyboard(keyBindings);

        //Player One Events
        KeyboardEvent playerOneGoUp = new KeyboardEvent();
        KeyboardEvent playerOneGoDown = new KeyboardEvent();
        KeyboardEvent playerOneGoLeft = new KeyboardEvent();
        KeyboardEvent playerOneGoRight = new KeyboardEvent();
        KeyboardEvent playerOneDeleteUp = new KeyboardEvent();
        KeyboardEvent playerOneDeleteDown = new KeyboardEvent();
        KeyboardEvent playerOneDeleteLeft = new KeyboardEvent();
        KeyboardEvent playerOneDeleteRight = new KeyboardEvent();
        KeyboardEvent playerOneShoot = new KeyboardEvent();
        KeyboardEvent playerOneStopShoot = new KeyboardEvent();
        //Player Two Events
        KeyboardEvent playerTwoGoUp = new KeyboardEvent();
        KeyboardEvent playerTwoGoDown = new KeyboardEvent();
        KeyboardEvent playerTwoGoLeft = new KeyboardEvent();
        KeyboardEvent playerTwoGoRight = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteUp = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteDown = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteLeft = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteRight = new KeyboardEvent();
        KeyboardEvent playerTwoShoot = new KeyboardEvent();
        KeyboardEvent playerTwoStopShoot = new KeyboardEvent();

        //Player One
        //SHOOT
        playerOneShoot.setKey(KeyboardEvent.KEY_L);
        playerOneShoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerOneShoot);
        playerOneStopShoot.setKey(KeyboardEvent.KEY_L);
        playerOneStopShoot.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerOneStopShoot);
        //UP
        playerOneGoUp.setKey(KeyboardEvent.KEY_UP);
        playerOneGoUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerOneGoUp);
        playerOneDeleteUp.setKey(KeyboardEvent.KEY_UP);
        playerOneDeleteUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerOneDeleteUp);
        //DOWN
        playerOneGoDown.setKey(KeyboardEvent.KEY_DOWN);
        playerOneGoDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerOneGoDown);
        playerOneDeleteDown.setKey(KeyboardEvent.KEY_DOWN);
        playerOneDeleteDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerOneDeleteDown);
        //LEFT
        playerOneGoLeft.setKey(KeyboardEvent.KEY_LEFT);
        playerOneGoLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerOneGoLeft);
        playerOneDeleteLeft.setKey(KeyboardEvent.KEY_LEFT);
        playerOneDeleteLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerOneDeleteLeft);
        //RIGHT
        playerOneGoRight.setKey(KeyboardEvent.KEY_RIGHT);
        playerOneGoRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerOneGoRight);
        playerOneDeleteRight.setKey(KeyboardEvent.KEY_RIGHT);
        playerOneDeleteRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerOneDeleteRight);
        //Player Two
        //SHOOT
        playerTwoShoot.setKey(KeyboardEvent.KEY_SPACE);
        playerTwoShoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerTwoShoot);
        playerTwoStopShoot.setKey(KeyboardEvent.KEY_SPACE);
        playerTwoStopShoot.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerTwoStopShoot);
        //UP
        playerTwoGoUp.setKey(KeyboardEvent.KEY_W);
        playerTwoGoUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerTwoGoUp);
        playerTwoDeleteUp.setKey(KeyboardEvent.KEY_W);
        playerTwoDeleteUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerTwoDeleteUp);
        //DOWN
        playerTwoGoDown.setKey(KeyboardEvent.KEY_S);
        playerTwoGoDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerTwoGoDown);
        playerTwoDeleteDown.setKey(KeyboardEvent.KEY_S);
        playerTwoDeleteDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerTwoDeleteDown);
        //LEFT
        playerTwoGoLeft.setKey(KeyboardEvent.KEY_A);
        playerTwoGoLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerTwoGoLeft);
        playerTwoDeleteLeft.setKey(KeyboardEvent.KEY_A);
        playerTwoDeleteLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerTwoDeleteLeft);
        //RIGHT
        playerTwoGoRight.setKey(KeyboardEvent.KEY_D);
        playerTwoGoRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(playerTwoGoRight);
        playerTwoDeleteRight.setKey(KeyboardEvent.KEY_D);
        playerTwoDeleteRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(playerTwoDeleteRight);

        new Game(MapType.STANDARD);
    }
}
