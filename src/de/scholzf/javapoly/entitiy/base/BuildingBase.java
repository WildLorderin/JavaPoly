package de.scholzf.javapoly.entitiy.base;

public interface BuildingBase {
	
	public String getName();
	public void setName(String name);
	
	public double getValue();
	public void setValue(double value);

	public EntityType getType();
	public void setType(EntityType type);
	
	public Entity getOwner();
	public void setOwner(Entity owner);
}
