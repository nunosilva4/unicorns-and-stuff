package org.academiadecodigo.gnunas.unicorns_and_stuff.object;

import org.academiadecodigo.gnunas.unicorns_and_stuff.Game;
import org.academiadecodigo.gnunas.unicorns_and_stuff.player.Player;

import java.util.LinkedList;
import java.util.TimerTask;

public class StuffFactory extends TimerTask {

    private static int NUMBEROFMAXSTUFF = 2;
    private static int CURRENTNUMBEROFSTUFF = 0;

    public static GameObject createNewStuff(StuffType stuffType, int x, int y, Player[] players) {
        switch (stuffType) {
            case TRAP:
                return new TrapStuff(x, y, players);
            case SHIT:
                break;
            case METEORS:
                break;
        }

        return null;
    }

    @Override
    public void run() {
        if (CURRENTNUMBEROFSTUFF >= NUMBEROFMAXSTUFF) {
            CURRENTNUMBEROFSTUFF--;

            for (GameObject stuffList: Game.getStuffList()) {
                stuffList.delete();
                Game.getStuffList().remove(stuffList);
                break;
            }

            return;
        }

        GameObject gameObject = createNewStuff(StuffType.TRAP, (int) (Math.random() * Game.WIDTH - Game.PADDING), (int) (Math.random() * Game.HEIGHT - Game.PADDING), Game.getPlayers());
        if (gameObject != null) {
            gameObject.show();
            Game.getStuffList().add(gameObject);
            CURRENTNUMBEROFSTUFF++;
        }
    }
}
