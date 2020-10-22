package org.academiadecodigo.gnunas.unicorns_and_stuff.input;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public enum KeyType {
    Z(KeyboardEvent.KEY_Z),
    X(KeyboardEvent.KEY_X),
    C(KeyboardEvent.KEY_C),
    ESC(KeyboardEvent.KEY_ESC);

    private final int key;

    KeyType(int key) {
        this.key = key;
    }

    public void init(Keyboard keyboard, KeyboardEventType keyboardEventType) {
        KeyboardEvent action = new KeyboardEvent();
        action.setKey(key);
        action.setKeyboardEventType(keyboardEventType);
        keyboard.addEventListener(action);
    }
}
