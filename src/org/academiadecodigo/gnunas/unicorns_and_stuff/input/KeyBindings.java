package org.academiadecodigo.gnunas.unicorns_and_stuff.input;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public final class KeyBindings {

    public static void init() {

        Handler keyBindings = new Handler();
        Keyboard keyboard = new Keyboard(keyBindings);

        Key.Z.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.X.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.C.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.ESC.init(keyboard, KeyboardEventType.KEY_PRESSED);

        Key.L.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.UP.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.RIGHT.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.LEFT.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.DOWN.init(keyboard, KeyboardEventType.KEY_PRESSED);

        Key.SPACE.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.W.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.D.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.A.init(keyboard, KeyboardEventType.KEY_PRESSED);
        Key.S.init(keyboard, KeyboardEventType.KEY_PRESSED);

        Key.L.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.UP.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.RIGHT.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.LEFT.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.DOWN.init(keyboard, KeyboardEventType.KEY_RELEASED);

        Key.SPACE.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.W.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.D.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.A.init(keyboard, KeyboardEventType.KEY_RELEASED);
        Key.S.init(keyboard, KeyboardEventType.KEY_RELEASED);
    }
}
