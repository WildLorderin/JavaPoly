package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;

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
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x   Name: " + HouseManager.getPurchaseable(player.getFieldId()).getName());
        System.out.println("x   Kaufpreis: " + HouseManager.getPurchaseable(player.getFieldId()).getValue());

        if(HouseManager.getPurchaseable(player.getFieldId()).getOwner() != null) {
            System.out.println("x   Besitzer: " + HouseManager.getPurchaseable(player.getFieldId()).getOwner().getName());
        } else {
            System.out.println("x   Es gibt noch keinen Besitzer");
        }

        System.out.println("x   Mietpreis: " + HouseManager.getPurchaseable(player.getFieldId()).getRent());
    }
}
