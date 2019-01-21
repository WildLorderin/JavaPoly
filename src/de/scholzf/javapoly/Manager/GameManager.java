package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Entity.GameObjects.GameObject;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Tile;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Die;
import de.scholzf.javapoly.Entity.Base.EntityFigure;
import de.scholzf.javapoly.Entity.Base.GameObjectType;

import java.util.List;

public class GameManager {

    private static int first, second;
    private static Player localPlayer;
    private static Die die;
    private static List<Entity> players;

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

        localPlayer = new Player("flo", 5, 0, 1, "player", 1500, GameObjectType.PLAYER, EntityFigure.SHOE, jail);
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }

    public List<Entity> getPlayers() {
        return players;
    }

    public int getKey() {
        return GameObject.Canvas.getInstance().getNextKey();
    }

    public Die getDie() {
        return die;
    }

}
