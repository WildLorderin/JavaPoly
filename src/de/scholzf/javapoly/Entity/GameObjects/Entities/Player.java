package de.scholzf.javapoly.Entity.GameObjects.Entities;

import de.scholzf.javapoly.Entity.Base.EntityFigure;
import de.scholzf.javapoly.Entity.Base.GameObjectType;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings.House;
import de.scholzf.javapoly.Manager.CommunityCard;
import de.scholzf.javapoly.Manager.CommunityCardManager;
import de.scholzf.javapoly.Manager.GameManager;
import de.scholzf.javapoly.Test.main;

public class Player extends Entity {

	private GameManager gameManager = main.getGameManager();
	private CommunityCardManager communityCardManager = main.getCommunityCardManager();
	public int stepsLeft;

	public Player(String name, double money, EntityFigure figure, Jail jail) {
		super(name, GameObjectType.PLAYER, figure, money, jail);
		super.setPlayer(this);
	}

	public Player(String name, int x, int y, int rotation, String fileName, double money, GameObjectType type, EntityFigure figure, Jail jail){
		super(name, x, y, rotation, fileName, money, type, figure, jail);
	}

	public void move(int stepsLeft) {
		checkRotation(stepsLeft);
		switch (this.getRotation()) {
			case 1:
				moveDown();
				break;
			case 2:
				moveLeft();
				break;
			case 3:
				moveUp();
				break;
			case 0:
				moveRight();
				break;
		}

		if(stepsLeft == 0)
			checkCurrentField();
	}

	public void checkCurrentField() {
		//Community card action
		if((this.getX() == 2 && this.getY() == 0) || (this.getX() == 0 && this.getY() == 4) || (this.getX() == 6 && this.getY() == 3) || (this.getX() == 3 && this.getY() == 6)) {
			CommunityCard card = communityCardManager.getCard();
			card.print();
			performAction(card.getId());
		}else if(this.getX() == 6 && this.getY() == 0) {
			//Über Los
			gameManager.onGoSpace(this);
		} else if(this.getX() == 6 && this.getY() == 1) {
			//Erstes blaues Kärtchen

			

		}

	}

	public void performAction(int id) {
		switch (id) {
			case 0:
				setMoney(getMoney() - 250);
				break;
			case 1:
				setMoney(getMoney() - 349);
				break;
			default:
				break;
		}
	}

	public void checkRotation(int stepsLeft) {
		if(this.getX() == 6 && this.getY() == 6) {
			setRotation(2);
		} else if(this.getX() == 0 && this.getY() == 6) {
			setRotation(3);
		} else if(this.getX() == 0 && this.getY() == 0) {
			setRotation(0);
		} else if(this.getX() == 6 && this.getY() == 0) {
			setRotation(1);
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
		this.setRotation(0);
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
		this.getItems().forEach(item -> System.out.println("Name: " + item.getName() + "\n Kosten: " + item.getValue() + "$\n Besitzer: " + item.getOwner().getName()));
	}

}
