package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;

import javax.swing.*;
import java.awt.*;

public class ConsoleManager extends JFrame {

    public JFrame frame;
    private static JTextArea textArea = new JTextArea(24, 80);

    public void allocate() {
        frame = new JFrame("JavaPoly");
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        frame.add(textArea);

        frame.pack();
        frame.setVisible(true);

        print("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        print("x	Herzlich Willkommen zu JavaPoly");
        print("x	Steuerung");
        print("x	P: Item kaufen");
        print("x	S: Zeige deine Stats");
        print("x	T: Zeige die Stats des aktuellen Blocks");
        print("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public static void print(Object x) {
        textArea.append(x == null ? "null\n" : x.toString() + "\n");
    }

    public JFrame getFrame() {
        return frame;
    }

    public void stats(Entity entity) {
        print("Das sind deine Stats:");
        print("xxxxxxxxxxxxxxxxxxxxxxxxx");
        print("x");
        print("x   Häuser: [" + entity.getItems().size() + "]");
        entity.getItems().forEach(item -> print("x   Name: " + item.getName() + "\nx   Preis: " + item.getValue() + "$\n0"));
        print("x");
        print("x   Geld: " + entity.getMoney() + "€\n");
        print("xxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void showTileStats(Player player) {
        print("xxxxxxxxxxxxxxxxxxxxxxxxx");
        print("x   Name: " + HouseManager.getPurchaseable(player.getFieldId()).getName());
        print("x   Kaufpreis: " + HouseManager.getPurchaseable(player.getFieldId()).getValue());

        if(HouseManager.getPurchaseable(player.getFieldId()).getOwner() != null) {
            print("x   Besitzer: " + HouseManager.getPurchaseable(player.getFieldId()).getOwner().getName());
        } else {
            print("x   Es gibt noch keinen Besitzer");
        }

        print("x   Mietpreis: " + HouseManager.getPurchaseable(player.getFieldId()).getRent());
    }
}
