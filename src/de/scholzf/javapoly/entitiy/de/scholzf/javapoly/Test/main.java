
package de.scholzf.javapoly.entitiy.de.scholzf.javapoly.Test;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Player;
import de.scholzf.javapoly.entitiy.GameObjects.Utils.Buildings.House;
import de.scholzf.javapoly.entitiy.GameObjects.Utils.Die;
import de.scholzf.javapoly.entitiy.base.Purchaseable;
import de.scholzf.javapoly.manager.GameManager;

public class main {

	void onEnable() {
		GameManager g = new GameManager();
		g.create();
		g.rollDie();

		House house = new House("myHouse", 1200);

		Player player = g.getPlayer();

		System.out.println("Pre purchase: " + player.getMoney() + "$");

		player.purchaseItem(house);

		for (Purchaseable item : player.getItems()) {
			System.out.println(item.getName());
			System.out.println(item.getValue() + "$");
			System.out.println(item.getOwner());
			System.out.println(item.getOwner().getName());
			System.out.println("Post purchase: " + item.getOwner().getMoney() + "$");
		}

		Die die = g.getDie();

		for(int i = 0; i < 5; i++) {
			die.rollDie();
			System.out.println("Throw " + i + ": " + die.getFirst() + " and " + die.getSecond() + "  -  isDoublets: " + die.isDoublets());
		}

	}

	public static void main(String[] args) {
		new main().onEnable();
	}

}
