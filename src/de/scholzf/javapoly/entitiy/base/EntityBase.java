package de.scholzf.javapoly.entitiy.base;

import java.util.List;

import de.scholzf.javapoly.entitiy.Player;

public interface EntityBase {
	
	public String getName();
	public void setName(String name);
	
	public double getMoney();
	public void setMoney(double money);
	
	public EntityType getType();
	public void setType(EntityType type);
	
	public Player getPlayer();
	
	public EntityFigure getFigure();
	public void setFigure(EntityFigure figure);
	
	List<Purchaseable> getItems();
	void purchaseItem(Purchaseable purchaseable);
	
}
