package de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.base.BuildingBase;
import de.scholzf.javapoly.Entity.base.GameObjectType;

public class Building implements BuildingBase {

	private String name;
	private double value;
	private GameObjectType type;
	private Entity owner;
	
	public Building(String name, double value, GameObjectType type, Entity owner) {
		setName(name);
		setValue(value);
		setType(type);
		setOwner(owner);
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public GameObjectType getType() {
		return this.type;
	}

	@Override
	public void setType(GameObjectType type) {
		this.type = type;
	}

	@Override
	public Entity getOwner() {
		return this.owner;
	}

	@Override
	public void setOwner(Entity owner) {
		this.owner = owner;
	}



}
