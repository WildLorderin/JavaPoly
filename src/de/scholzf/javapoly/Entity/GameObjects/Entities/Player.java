package de.scholzf.javapoly.Entity.GameObjects.Entities;

import de.scholzf.javapoly.Entity.Base.EntityFigure;
import de.scholzf.javapoly.Entity.Base.GameObjectType;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.Manager.CommunityCard;
import de.scholzf.javapoly.Manager.CommunityCardManager;
import de.scholzf.javapoly.Manager.ConsoleManager;
import de.scholzf.javapoly.Manager.GameManager;
import de.scholzf.javapoly.Test.MainGame;

public class Player extends Entity {

	private GameManager gameManager = MainGame.getGameManager();
	private CommunityCardManager communityCardManager = MainGame.getCommunityCardManager();
	public int stepsLeft;
	private int fieldId;
	public Jail jail;

	public Player(String name, double money, EntityFigure figure, Jail jail) {
		super(name, GameObjectType.PLAYER, figure, money, jail);
		super.setPlayer(this);
		this.jail = jail;
	}

	public Player(String name, int x, int y, int rotation, String fileName, double money, GameObjectType type, EntityFigure figure, Jail jail) {
		super(name, x, y, rotation, fileName, money, type, figure, jail);
		this.jail = jail;
	}

	public void move() {
		setIds();
		checkRotation();
		switch (this.getRotation()) {
			case 1:
				moveDown();
				setIds();
				break;
			case 2:
				moveLeft();
				setIds();
				break;
			case 3:
				moveUp();
				setIds();
				break;
			case 0:
				moveRight();
				setIds();
				break;
		}
	}

	public Jail getJail() {
		return this.jail;
	}

	public void setFieldId(int id) {
		this.fieldId = id;
	}

	public int getFieldId() {
		return this.fieldId;
	}

	public void setIds() {
		if(this.getX() == 6 && this.getY() == 0) {
			setFieldId(0);
		} else if(this.getX() == 6 && this.getY() == 1) {
			setFieldId(1);
		} else if(this.getX() == 6 && this.getY() == 2) {
			setFieldId(2);
		} else if(this.getX() == 6 && this.getY() == 3) {
			setFieldId(3);
		} else if(this.getX() == 6 && this.getY() == 4) {
			setFieldId(4);
		} else if(this.getX() == 6 && this.getY() == 5) {
			setFieldId(5);
		} else if(this.getX() == 6 && this.getY() == 6) {
			setFieldId(6);
		} else if(this.getX() == 5 && this.getY() == 6) {
			setFieldId(7);
		} else if(this.getX() == 4 && this.getY() == 6) {
			setFieldId(8);
		} else if(this.getX() == 3 && this.getY() == 6) {
			setFieldId(9);
		} else if(this.getX() == 2 && this.getY() == 6) {
			setFieldId(10);
		} else if(this.getX() == 1 && this.getY() == 6) {
			setFieldId(11);
		} else if(this.getX() == 0 && this.getY() == 6) {
			setFieldId(12);
		} else if(this.getX() == 0 && this.getY() == 5) {
			setFieldId(13);
		} else if(this.getX() == 0 && this.getY() == 4) {
			setFieldId(14);
		} else if(this.getX() == 0 && this.getY() == 3) {
			setFieldId(15);
		} else if(this.getX() == 0 && this.getY() == 2) {
			setFieldId(16);
		} else if(this.getX() == 0 && this.getY() == 1) {
			setFieldId(17);
		} else if(this.getX() == 0 && this.getY() == 0) {
			setFieldId(18);
		} else if(this.getX() == 1 && this.getY() == 0) {
			setFieldId(19);
		} else if(this.getX() == 2 && this.getY() == 0) {
			setFieldId(20);
		} else if(this.getX() == 3 && this.getY() == 0) {
			setFieldId(21);
		} else if(this.getX() == 4 && this.getY() == 0) {
			setFieldId(22);
		} else if(this.getX() == 5 && this.getY() == 0) {
			setFieldId(23);
		}
	}

	public void checkCurrentField() {
		//Community card action
		if((this.getX() == 2 && this.getY() == 0) || (this.getX() == 0 && this.getY() == 4) || (this.getX() == 6 && this.getY() == 3) || (this.getX() == 3 && this.getY() == 6)) {
			CommunityCard card = communityCardManager.getCard();
			card.print();
			performAction(card.getId());
		} else if(this.getX() == 6 && this.getY() == 0) {
			//Über Los
			setMoney(getMoney() + 450);
		} else if(this.getX() == 0 && this.getY() == 0 && this.stepsLeft == 0) {
			ConsoleManager.print(stepsLeft);
			this.setImprisioned(true);
			this.setLocation(6, 6);
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
			case 2:
				setLocation(6, 0);
				ConsoleManager.print("Du musst Nachsitzen und wurdest in die Bibliothek verbannt!");
				break;
			case 3:
				setMoney(getMoney() - 50);
				break;
			case 4:
				setMoney(getMoney() + 150);
				break;
			case 5:
				setMoney(getMoney() - 100);
				break;
			case 6:
				setMoney(getMoney() - 400);
				break;
			case 7:
				setMoney(getMoney() + 1500);
				break;
			default:
				break;
		}
	}

	public void checkRotation() {
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

	@Override
	public void payRent() {
		if(isCreditWorth(250)) {
			setImprisioned(false);
			setMoney(getMoney() - 250);
			ConsoleManager.print("Du hast sich aus der Bibliothek für " + 250 + "€ freigekauft.");
			return;
		} else {
			ConsoleManager.print("Du hast nicht genügent Geld um Dich freizukaufen.");
		}
	}

}
