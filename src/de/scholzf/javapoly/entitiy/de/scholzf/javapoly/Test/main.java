
package de.scholzf.javapoly.entitiy.de.scholzf.javapoly.Test;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Player;
import de.scholzf.javapoly.entitiy.GameObjects.Utils.Buildings.House;
import de.scholzf.javapoly.manager.GameManager;


public class main {

	void onEnable() {
		GameManager g = new GameManager();
		g.create();
		g.rollDie();

		House house = new House("myHouse", 100);

		Player player = g.getPlayer();

		player.purchaseItem(house);

	}

	public static void main(String[] args) {
		new main().onEnable();
	}

}
