package de.scholzf.javapoly.entitiy.GameObjects;

import de.scholzf.javapoly.entitiy.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.entitiy.GameObjects.Tiles.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class GameObjectManager {

    private List<Tile> tiles;
    private Jail jail;

    public GameObjectManager(List<Tile> tiles) {
        this.tiles = tiles;
        fetchJail();
    }

    private void fetchJail() {
        Optional<Tile> optTile = tiles.stream().filter(o -> o.getName().equals("jail")).findFirst();
        jail = (Jail) optTile.get();
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public void add(Tile tile) {
        this.tiles.add(tile);
    }

    public Jail getJail() {
        return this.jail;
    }

}
