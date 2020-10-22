package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.map.MapCollision;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

public class MeteorStuff extends GameObject {

    private final int DAMAGE = 20;

    public MeteorStuff(int x, int y, String string) {
        super(x, y, string);
    }

    @Override
    public Player process() {
        move();
        return super.process();
    }

    @Override
    public void interact() {
        if (player == null) {
            return;
        }

        player.hit(DAMAGE);
    }

    public void move(){
        getPicture().translate(1, 1);

        if (MapCollision.hittingBottom(this) ||
                MapCollision.hittingLeft(this) ||
                MapCollision.hittingRight(this) ||
                MapCollision.hittingTop(this)) {
            delete();
        }
    }
}
