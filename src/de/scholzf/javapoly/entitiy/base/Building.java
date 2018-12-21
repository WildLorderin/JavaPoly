package de.scholzf.javapoly.entitiy.base;

public class Building implements BuildingBase {

	private String name;
	private double value;
	private EntityType type;
	private Entity owner;
	
	public Building(String name, double value, EntityType type, Entity owner) {
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
	public EntityType getType() {
		return this.type;
	}

	@Override
	public void setType(EntityType type) {
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
