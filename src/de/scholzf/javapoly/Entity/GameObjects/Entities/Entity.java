package de.scholzf.javapoly.Entity.GameObjects.Entities;

import de.scholzf.javapoly.Entity.GameObjects.GameObject;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.Entity.Base.EntityBase;
import de.scholzf.javapoly.Entity.Base.EntityFigure;
import de.scholzf.javapoly.Entity.Base.GameObjectType;
import de.scholzf.javapoly.Entity.Base.Purchaseable;
import de.scholzf.javapoly.Exceptions.PurchaseException;

import java.util.ArrayList;
import java.util.List;


public abstract class Entity extends GameObject implements EntityBase {

	private Player player;
	private String name;
	private boolean imprisoned;
	private Jail jail;
	private GameObjectType type;
	private EntityFigure figure;
	private double money;
	private List<Purchaseable> items = new ArrayList<Purchaseable>();

	@Override
	public void setJail(Jail jail) {
		this.jail = jail;
	}

	public void rollDie() {
		this.jail.rollDie();
	}

	@Override
	public boolean isImprisoned() {
		return this.imprisoned;
	}

	@Override
	public void setImprisioned(boolean imprisioned) {

		if(imprisioned) {
			this.imprisoned = true;
			this.jail.imprison(this);
			this.jail.setPlayer(this.player);
		} else {
			this.imprisoned = false;
			this.jail.getImprisoned().remove(player);
		}

	}

	{
		imprisoned = false;
	}

	public Entity(String name, int x, int y, int rotation, String fileName, double money, GameObjectType type, EntityFigure figure, Jail jail){
		super(name, x, y, rotation, fileName, money, type, figure, jail);
		setName(name);
		setType(type);
		setFigure(figure);
		setMoney(money);
		setJail(jail);
	}

	public Entity(String name, GameObjectType type, EntityFigure figure, double money, Jail jail) {
		super(name, type, figure, money, jail);
		setName(name);
		setType(type);
		setFigure(figure);
		setMoney(money);
		setJail(jail);
	}

	@Override
	public List<Purchaseable> getItems() {
		return items;
	}

	@Override
	public void purchaseItem(Purchaseable purchaseable){
		if(this.isCreditWorth(purchaseable.getValue())) {
			if(!this.getItems().contains(purchaseable)) {
				purchaseable.setOwner(this);
				purchaseable.setPurchased(true);
				this.setMoney(this.getMoney() - purchaseable.getValue());
				this.items.add(purchaseable);
			} else {
				System.out.println("Du hast " + purchaseable.getName() + " bereits gekauft.");
			}
		} else {
			System.out.println("Du hast zu wenig Geld. " + this.getMoney() + " $ / " + purchaseable.getValue() + " $");
		}
	}

	@Override
	public void clearItems() {
		this.items.clear();
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
	public double getMoney() {
		return this.money;
	}

	@Override
	public void setMoney(double money) {
		this.money = money;
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
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public EntityFigure getFigure() {
		return this.figure;
	}

	@Override
	public boolean isCreditWorth(double value) {
		return this.getMoney() >= value;
	}

	@Override
	public void setFigure(EntityFigure figure) {
		this.figure = figure;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public abstract void moveLeft();

	public abstract void moveUp();

	public abstract void moveRight();

	public abstract void moveDown();

}
