package de.scholzf.javapoly.entitiy.GameObjects.Tiles;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Entity;

import java.util.List;

public interface TileBase {

    List<Entity> getEntities();
    TileType getTileType();
    String getName();
    void setEntity(Entity entity);

}
