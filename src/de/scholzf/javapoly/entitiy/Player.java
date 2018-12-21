package de.scholzf.javapoly.entitiy;

import de.scholzf.javapoly.entitiy.base.Entity;
import de.scholzf.javapoly.entitiy.base.EntityFigure;
import de.scholzf.javapoly.entitiy.base.EntityType;

public class Player extends Entity {

	public Player(String name, double money, EntityFigure figure) {
		super(name, EntityType.PLAYER, figure, money);
	}
	
}
