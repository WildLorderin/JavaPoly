package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;

public class ConsoleManager {

    public void printf(String format, Object ... args) {
        System.out.printf(format, args);
    }

    public void stats(Entity entity) {

        System.out.println("Das sind deine Stats:");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");

        entity.getItems().forEach(item -> System.out.println("0   Häuser: " + item.getName() + "\n0   Kosten: " + item.getValue() + "\n\n"));

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");

    }

}
