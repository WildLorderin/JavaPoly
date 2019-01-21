
package de.scholzf.javapoly.Test;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings.House;
import de.scholzf.javapoly.Manager.ConsoleManager;
import de.scholzf.javapoly.Manager.GameManager;

import java.awt.event.KeyEvent;

public class main {

	void onEnable() {
		GameManager g = new GameManager();
		ConsoleManager c = new ConsoleManager();
		g.create();
		g.rollDie();

		House house = new House("Schlossallee", 500);
		House house2 = new House("Parkallee", 500);

		Player player = g.getPlayer();

		player.purchaseItem(house);
		player.purchaseItem(house2);

		while(true) {
			int key = g.getKey();

			if(key == KeyEvent.VK_S) {
				c.stats(player);
			}
		}

	}

	public static void main(String[] args) {
		new main().onEnable();
	}

}
