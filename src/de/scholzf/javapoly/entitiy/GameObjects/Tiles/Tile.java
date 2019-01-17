package de.scholzf.javapoly.entitiy.GameObjects.Tiles;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Entity;
import de.scholzf.javapoly.entitiy.GameObjects.GameObject;

import java.util.List;

public class Tile extends GameObject implements TileBase {

    private List<Entity> entities;
    private TileType tileType;
    private String name;

    public Tile(int x, int y, String name) {
        super(x, y, name);
    }

    public Tile(TileType tileType, String objectName, String fileName) {
        super(tileType, objectName, fileName);
    }

    public Tile(TileType tileType, String name) {
        super(tileType, name);
        this.tileType = tileType;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public TileType getTileType() {
        return this.tileType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setEntity(Entity entity) {
        this.entities.add(entity);
    }
}
