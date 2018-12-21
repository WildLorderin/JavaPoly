package de.scholzf.javapoly.entitiy.base;

import java.util.ArrayList;
import java.util.List;

import de.scholzf.javapoly.entitiy.Player;

public class Entity implements EntityBase {
	
	private Player player;
	private String name;
	private EntityType type;
	private EntityFigure figure;
	private double money;
	private List<Purchaseable> items = new ArrayList<Purchaseable>();

	public Entity(String name, EntityType type, EntityFigure figure, double money) {
		setName(name);
		setType(type);
		setFigure(figure);
		setMoney(money);
	}
	
	@Override
	public List<Purchaseable> getItems() {
		return items;
	}
	
	@Override
	public void purchaseItem(Purchaseable purchaseable) {
		purchaseable.setOwner(this);
		this.items.add(purchaseable);
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
	public EntityType getType() {
		return this.type;
	}

	@Override
	public void setType(EntityType type) {
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
	public void setFigure(EntityFigure figure) {
		this.figure = figure;
	}
	
}
