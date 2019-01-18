package de.scholzf.javapoly.entitiy.Events;

/***
 * Id is the keycode in dec
 */

public enum KeyCode {

    DONT_BUY(79),
    BUY(80);

    private final int id;

    KeyCode(int id) {
        this.id = id;
    }

    public int id() {
        return this.id;
    }

}
