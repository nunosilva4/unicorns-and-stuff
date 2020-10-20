package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Meteor extends GameObject {

    private final int DAMAGE = 20;


    public Meteor(int x, int y) {
        super(x, y, "resources/Objects/meteor.png");
    }

    public void hit() {
        for (Player player : Game.getPlayers()) {
            if (!player.isDead()) {
                player.hit(DAMAGE);
            }
        }
    }

    public void moveMeteor(Rectangle rectangleMeteor){
        rectangleMeteor.translate(0, 1);
    }
}
