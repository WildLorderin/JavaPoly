package de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.Base.GameObjectType;
import de.scholzf.javapoly.Entity.Base.Purchaseable;

public class House extends Building implements Purchaseable {

	public boolean isPurchased;
	
	public House(String name, double value, GameObjectType type) {
		super(name, value, type,null, 0);
	}
	
	public House(String name, double value, GameObjectType type, Entity owner) {
		super(name, value, type, owner, 0);
	}
	
	public House(String name, double value) {
		super(name, value, GameObjectType.BUILDING, null, 0);
	}
	
	public House(String name, double value, Entity owner) {
		super(name, value, GameObjectType.BUILDING, owner, 0);
	}

	public House(String name, double value, double rent) {
		super(name, value, GameObjectType.BUILDING, null, rent);
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

	@Override
	public double getRent() {
		return super.getRent();
	}

	@Override
	public void setRent(double rent) {
		super.setRent(rent);
	}

}
