package org.academiadecodigo.gnunas.unicorns_and_stuff.map;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.GameObject;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.StuffFactory;
import org.academiadecodigo.gnunas.unicorns_and_stuff.object.StuffType;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardMap implements Map {

    private Picture picture;
    private Player[] players;
    private int numberOfObjects;

    public StandardMap(Player[] players, int numberOfObjects) {
        picture = new Picture(0, 0, "resources/background.jpg");
        picture.draw();
        this.numberOfObjects = numberOfObjects;

        this.players = players;

        StuffFactory stuffFactory = new StuffFactory();
        for (int i = 0; i < numberOfObjects; i++) {
            GameObject gameObject = stuffFactory.creatNewStuff(StuffType.TRAP, MapType.STANDARD, (int) (Math.random() * Game.WIDTH), (int) (Math.random() * Game.HEIGHT), players);
            if (gameObject != null) {
                gameObject.show();
            }
        }
    }

}
