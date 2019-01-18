package de.scholzf.javapoly.manager;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Player;
import de.scholzf.javapoly.entitiy.GameObjects.GameObject;
import de.scholzf.javapoly.entitiy.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.entitiy.GameObjects.Tiles.Tile;
import de.scholzf.javapoly.entitiy.GameObjects.Utils.Die;
import de.scholzf.javapoly.entitiy.base.GameObjectType;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static int first, second;
    private static Player player;
    private static Die die;

    public void rollDie() {
        die = new Die();
        die.rollDie();
        first = die.getFirst();
        second = die.getSecond();
    }

    public void create() {
        new Tile(0, 0, "floor");
        new Tile(1, 0, "floor");
        new Tile(2, 0, "floor");
        new Tile(3, 0, "floor");
        new Tile(4, 0, "floor");
        new Tile(5, 0, "floor");

        new Tile(0, 1, "floor");
        new Tile(0, 2, "floor");
        new Tile(0, 3, "floor");
        new Tile(0, 4, "floor");
        new Tile(0, 5, "floor");

        new Tile(1, 5, "floor");
        new Tile(2, 5, "floor");
        new Tile(3, 5, "floor");
        new Tile(4, 5, "floor");
        new Tile(5, 5, "floor");

        new Tile(5, 1, "floor");
        new Tile(5, 2, "floor");
        new Tile(5, 3, "floor");
        new Tile(5, 4, "floor");

        Jail jail = new Jail();

        player = new Player("flo", 5, 0, 1, "player", 1500, GameObjectType.PLAYER, null, jail);
    }

    public Player getPlayer() {
        return player;
    }

    public int getKey() {
        return GameObject.Canvas.getInstance().getNextKey();
    }

    public Die getDie() {
        return die;
    }

    public int checkPosition() {
        if(player.getX() == 5 && player.getY() == 5) {
            player.setRotation(2);
            return 2;
        } else if(player.getX() == 0 && player.getY() == 5) {
            player.setRotation(3);
            return 3;
        } else if(player.getX() == 0 && player.getY() == 0) {
            player.setRotation(0);
           return 0;
        } else {
            return player.getRotation();
        }
    }

}
