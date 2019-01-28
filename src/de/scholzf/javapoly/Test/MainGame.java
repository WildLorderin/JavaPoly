
package de.scholzf.javapoly.Test;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Server.ServerConnection;
import de.scholzf.javapoly.Manager.CommunityCardManager;
import de.scholzf.javapoly.Manager.ConsoleManager;
import de.scholzf.javapoly.Manager.GameManager;
import de.scholzf.javapoly.Manager.HouseManager;

import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class MainGame {

	private static CommunityCardManager communityCardManager;
	private static GameManager gameManager;
	private static HouseManager houseManager;
	private static ConsoleManager consoleManager;
	private static ServerConnection serverConnection;
	private static List<Integer> exitCodes = new ArrayList<>();

	public static CommunityCardManager getCommunityCardManager() {
		return communityCardManager;
	}

	public static GameManager getGameManager() { return gameManager; }

	public static HouseManager getHouseManager() { return houseManager; }

	public static ConsoleManager getConsoleManager() { return consoleManager; }

	public static ServerConnection getServerConnection() { return serverConnection; }

	void setupManager() {
		gameManager = new GameManager();
		houseManager = new HouseManager();
		consoleManager = new ConsoleManager();
		communityCardManager = new CommunityCardManager(gameManager.getPlayers());

		serverConnection = new ServerConnection("localhost");

		consoleManager.allocate();

		gameManager.create();
		communityCardManager.create();
		houseManager.create();

		exitCodes.add(0);
		exitCodes.add(3);
		exitCodes.add(6);
		exitCodes.add(9);
		exitCodes.add(12);
		exitCodes.add(14);
		exitCodes.add(18);
		exitCodes.add(20);
	}

	void onEnable() {

		setupManager();

		Player player = gameManager.getLocalPlayer();

		while(true) {
			int key = gameManager.getKey();

			if(key == KeyEvent.VK_S) {
				//Show player stats
				consoleManager.stats(player);
			} else if(key == KeyEvent.VK_D) {
				//Roll next die
				gameManager.next();
				//Starts the game
			} else if(key == KeyEvent.VK_P) {
				//Purchase
				if(exitCodes.contains(player.getFieldId())) {
					ConsoleManager.print("Du kannst das Feld nicht kaufen.");
				} else {
					player.purchaseItem(houseManager.getPurchaseable(player.getFieldId()));
				}
			} else if(key == KeyEvent.VK_T) {
				//Show stats of card you are currently on
				if(exitCodes.contains(player.getFieldId()))
					ConsoleManager.print("Zu diesen Feld gibt es keine weiteren Informationen.");
				else
					consoleManager.showTileStats(player);
			} else if(key == KeyEvent.VK_C) {
				ConsoleManager.clear();
			} else if(key == KeyEvent.VK_O) {

				//Frei kaufen im Gefängnis
				if(player.isImprisoned())
					player.payRent();
				else
					ConsoleManager.print("Du musst im Gefängnis sein um Dich freizukaufen.");
			} else if(key == KeyEvent.VK_L) {
				//Mit L kann man das Spiel liken
				serverConnection.add("JavaPoly", System.getProperty("user.name"));
				ConsoleManager.print(System.getProperty("user.name") + " hat JavaPoly geliked");
			} else if(key == KeyEvent.VK_G) {
				//Mit G kann man die aktuellen likes abrufen
				int likes = serverConnection.get("JavaPoly");
				ConsoleManager.print("JavaPoly hat " + likes + " Likes");
			}
		}
	}

	public static void main(String[] args) {
		new MainGame().onEnable();
	}

}
