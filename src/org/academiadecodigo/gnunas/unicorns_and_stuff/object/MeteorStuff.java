package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

public class MeteorStuff extends GameObject {

    private final int DAMAGE = 20;

    public MeteorStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public void interact() {
        if (player == null) {
            return;
        }

        player.hit(DAMAGE);
    }

    public void move(){

    }
}
