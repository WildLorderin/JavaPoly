
package de.scholzf.javapoly.Test;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings.House;
import de.scholzf.javapoly.Manager.CommunityCard;
import de.scholzf.javapoly.Manager.CommunityCardManager;
import de.scholzf.javapoly.Manager.ConsoleManager;
import de.scholzf.javapoly.Manager.GameManager;

import java.awt.event.KeyEvent;

public class main {

	void onEnable() {
		GameManager gameManager = new GameManager();
		ConsoleManager consoleManager = new ConsoleManager();
		CommunityCardManager communityCardManager = new CommunityCardManager(gameManager.getPlayers());

		gameManager.create();
		communityCardManager.create();

		House house = new House("Schlossallee", 500);
		House house2 = new House("Parkallee", 500);

		Player player = gameManager.getLocalPlayer();

		player.purchaseItem(house);
		player.purchaseItem(house2);

		while(true) {
			int key = gameManager.getKey();

			if(key == KeyEvent.VK_S) {
				consoleManager.stats(player);
			}else if(key == KeyEvent.VK_Y) {
				CommunityCard card = communityCardManager.getCard();
				card.print();
			}
		}

	}

	public static void main(String[] args) {
		new main().onEnable();
	}

}
