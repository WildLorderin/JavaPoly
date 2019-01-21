package de.scholzf.javapoly.Entity.GameObjects.Tiles;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;

import java.util.List;

public interface TileBase {

    List<Entity> getEntities();
    TileType getTileType();
    String getName();
    void setEntity(Entity entity);

}
