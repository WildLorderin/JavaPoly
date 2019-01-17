package de.scholzf.javapoly.entitiy.GameObjects;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Entity;
import de.scholzf.javapoly.entitiy.GameObjects.Entities.Player;
import de.scholzf.javapoly.entitiy.GameObjects.Tiles.Tile;
import de.scholzf.javapoly.entitiy.base.EntityFigure;
import java.util.ArrayList;
import java.util.List;

public final class BoardManager {

    public BoardManager() {
        createBoard();
    }

    private static List<Entity> entities = new ArrayList<>();
    private static Player player;

    public Player getPlayer() {
        return player;
    }

    private static void createBoard() {
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

        new Tile(6, 0, "floor");
        new Tile(6, 1, "floor");
        new Tile(6, 2, "floor");
        new Tile(6, 3, "floor");
        new Tile(6, 4, "floor");
        new Tile(6, 5, "floor");

        player = new Player("Flo", 0, 0, 0, "player", 1500, GameObjectType.PLAYER, EntityFigure.SHOE, null);

        entities.add(player);
    }

}
