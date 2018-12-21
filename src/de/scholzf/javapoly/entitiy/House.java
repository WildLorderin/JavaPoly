package de.scholzf.javapoly.entitiy;

import de.scholzf.javapoly.entitiy.base.Building;
import de.scholzf.javapoly.entitiy.base.Entity;
import de.scholzf.javapoly.entitiy.base.EntityType;
import de.scholzf.javapoly.entitiy.base.Purchaseable;

public class House extends Building implements Purchaseable {

	public boolean isPurchased;
	
	public House(String name, double value, EntityType type) {
		super(name, value, type, null);
	}
	
	public House(String name, double value, EntityType type, Entity owner) {
		super(name, value, type, owner);
	}
	
	public House(String name, double value) {
		super(name, value, EntityType.BUILDING, null);
	}
	
	public House(String name, double value, Entity owner) {
		super(name, value, EntityType.BUILDING, owner);
	}
	
	@Override
	public boolean isPurchased() {
		return isPurchased;
	}

	@Override
	public boolean canPurchase() {
		return isPurchased = false;
	}

	@Override
	public void setPurchased(boolean purchased) {
		this.isPurchased = purchased;
	}

}
