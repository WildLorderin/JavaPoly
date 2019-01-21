package de.scholzf.javapoly.Entity.Base;

import java.util.List;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.Exceptions.PurchaseException;

public interface EntityBase {

	boolean isCreditWorth(double value);

	String getName();
	void setName(String name);
	
	double getMoney();
	void setMoney(double money);

	GameObjectType getType();
	void setType(GameObjectType type);
	
	Player getPlayer();
	
	EntityFigure getFigure();
	void setFigure(EntityFigure figure);
	
	List<Purchaseable> getItems();
	void purchaseItem(Purchaseable purchaseable) throws PurchaseException;
	void clearItems();

	void setJail(Jail jail);

	boolean isImprisoned();
	void setImprisioned(boolean imprisioned);

}
