package de.scholzf.javapoly.entitiy.GameObjects.Entities;

import de.scholzf.javapoly.entitiy.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.entitiy.base.EntityFigure;
import de.scholzf.javapoly.entitiy.base.GameObjectType;

public class Player extends Entity {

	public Player(String name, double money, EntityFigure figure, Jail jail) {
		super(name, GameObjectType.PLAYER, figure, money, jail);
		super.setPlayer(this);
	}

	public Player(String name, int x, int y, int rotation, String fileName, double money, GameObjectType type, EntityFigure figure, Jail jail){
		super(name, x, y, rotation, fileName, money, type, figure, jail);
	}

	public void move(int i) {
		switch (i) {
			case 1:
				moveDown();
				break;
			case 2:
				moveLeft();
				break;
			case 3:
				moveUp();
				break;
			case 4:
				moveRight();
				break;
		}
	}

	@Override
	public void moveLeft() {
		this.setRotation(2);
		this.setLocation(this.getX() - 1, this.getY());
	}

	@Override
	public void moveUp() {
		this.setRotation(3);
		this.setLocation(this.getX(), this.getY() - 1);
	}

	@Override
	public void moveRight() {
		this.setRotation(4);
		this.setLocation(this.getX() + 1, this.getY());
	}

	@Override
	public void moveDown() {
		this.setRotation(1);
		this.setLocation(this.getX(), this.getY() + 1);
	}

	public void details() {
		System.out.println("Name: " + this.getName());
		System.out.println("Money: " + this.getMoney() + "$");
		System.out.println("Figure: " + this.getFigure().toString());
		System.out.println("Ist im Gefängnis: " + this.isImprisoned());
		System.out.println("GameObjectType: " + this.getType());
		this.getItems().forEach(item -> System.out.println("Name: " + item.getName() + "\n Kosten: " + item.getValue() + "\n Besitzer: " + item.getOwner().getName()));
	}

}
