package org.academiadecodigo.gnunas.unicorns_and_stuff.input;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public enum Key {
    Z(KeyboardEvent.KEY_Z),
    X(KeyboardEvent.KEY_X),
    C(KeyboardEvent.KEY_C),
    ESC(KeyboardEvent.KEY_ESC),
    L(KeyboardEvent.KEY_L),
    UP(KeyboardEvent.KEY_UP),
    LEFT(KeyboardEvent.KEY_LEFT),
    RIGHT(KeyboardEvent.KEY_RIGHT),
    DOWN(KeyboardEvent.KEY_DOWN),
    SPACE(KeyboardEvent.KEY_SPACE),
    W(KeyboardEvent.KEY_W),
    D(KeyboardEvent.KEY_D),
    A(KeyboardEvent.KEY_A),
    S(KeyboardEvent.KEY_S);

    private final int key;

    Key(int key) {
        this.key = key;
    }

    public void init(Keyboard keyboard, KeyboardEventType keyboardEventType) {
        KeyboardEvent action = new KeyboardEvent();
        action.setKey(key);
        action.setKeyboardEventType(keyboardEventType);
        keyboard.addEventListener(action);
    }
}
