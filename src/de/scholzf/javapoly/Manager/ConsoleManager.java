package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Test.main;

public class ConsoleManager {

    Player player = main.getGameManager().getLocalPlayer();

    public void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }

    public void stats(Entity entity) {
        System.out.println("Das sind deine Stats:");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");

        System.out.println("0   Häuser:");
        entity.getItems().forEach(item -> System.out.println("0   Name: " + item.getName() + "\n0   Preis: " + item.getValue() + "\n0"));

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void showTileStats() {



    }
}
