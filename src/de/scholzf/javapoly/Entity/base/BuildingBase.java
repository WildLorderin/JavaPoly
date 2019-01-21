package de.scholzf.javapoly.Entity.base;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;

public interface BuildingBase {
	
	String getName();
	void setName(String name);
	
	double getValue();
	void setValue(double value);

	GameObjectType getType();
	void setType(GameObjectType type);
	
	Entity getOwner();
	void setOwner(Entity owner);
}
