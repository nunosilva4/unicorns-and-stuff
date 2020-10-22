package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

public class ShitStuff extends GameObject {

    public ShitStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public void interact() {
        if (player == null) {
            return;
        }

        player.setSliding(true);
        getPicture().delete();
    }

    @Override
    public void delete() {

        super.delete();
    }
}
