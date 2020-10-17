package org.academiadecodigo.gnunas.unicorns_and_stuff;

import org.academiadecodigo.gnunas.unicorns_and_stuff.input.Handler;
import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapType;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class UnicornsTest {
    public static void main(String[] args) {

        //TODO siga pessoal


        /*Rectangle rectangle = new Rectangle(0, 0, 1500, 500);
        rectangle.draw();
        Picture picture = new Picture(1200, 0, "resources/unicorn.png");
        picture.draw();
        Picture picture2 = new Picture(0, 0, "resources/unicorn2.png");
        picture2.draw();*/

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
        //Player Two Events
        KeyboardEvent playerTwoGoUp = new KeyboardEvent();
        KeyboardEvent playerTwoGoDown = new KeyboardEvent();
        KeyboardEvent playerTwoGoLeft = new KeyboardEvent();
        KeyboardEvent playerTwoGoRight = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteUp = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteDown = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteLeft = new KeyboardEvent();
        KeyboardEvent playerTwoDeleteRight = new KeyboardEvent();

        //Player One
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
