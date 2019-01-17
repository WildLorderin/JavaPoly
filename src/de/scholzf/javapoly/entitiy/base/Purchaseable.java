package de.scholzf.javapoly.entitiy.base;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Entity;

public interface Purchaseable {

	boolean isPurchased();
	boolean canPurchase();
	void setPurchased(boolean purchased);
	
	double getValue();
	void setValue(double value);
	
	Entity getOwner();
	void setOwner(Entity owner);
	
	void setName(String name);
	String getName();
	
}
