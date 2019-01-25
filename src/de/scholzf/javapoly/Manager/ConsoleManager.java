package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Test.MainGame;

public class ConsoleManager {

    public void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }

    public void stats(Entity entity) {
        System.out.println("Das sind deine Stats:");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x");
        System.out.println("x   Häuser: [" + entity.getItems().size() + "]");
        entity.getItems().forEach(item -> System.out.println("x   Name: " + item.getName() + "\nx   Preis: " + item.getValue() + "$\n0"));
        System.out.println("x");
        printf("x   Geld: %f$\n", entity.getMoney());

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void showTileStats(Player player) {

        System.out.println(HouseManager.getPurchaseable(player.getFieldId()).getName());
    }
}
