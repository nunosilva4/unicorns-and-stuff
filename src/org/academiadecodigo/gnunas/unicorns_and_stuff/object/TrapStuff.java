package org.academiadecodigo.gnunas.unicorns_and_stuff.object;


public class TrapStuff extends GameObject {

    public TrapStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public void interact() {
        if (player == null) {
            return;
        }

        player.setStunned(true);
    }

    @Override
    public void delete() {
        if (player != null) {
            player.setStunned(false);
        }

        super.delete();
    }
}
