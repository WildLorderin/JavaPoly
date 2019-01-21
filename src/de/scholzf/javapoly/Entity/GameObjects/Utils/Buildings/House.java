package de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.Base.GameObjectType;
import de.scholzf.javapoly.Entity.Base.Purchaseable;

public class House extends Building implements Purchaseable {

	public boolean isPurchased;
	
	public House(String name, double value, GameObjectType type) {
		super(name, value, type,null);
	}
	
	public House(String name, double value, GameObjectType type, Entity owner) {
		super(name, value, type, owner);
	}
	
	public House(String name, double value) {
		super(name, value, GameObjectType.BUILDING, null);
	}
	
	public House(String name, double value, Entity owner) {
		super(name, value, GameObjectType.BUILDING, owner);
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
