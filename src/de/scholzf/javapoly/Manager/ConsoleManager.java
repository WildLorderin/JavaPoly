package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;

import javax.swing.*;
import java.awt.*;

public class ConsoleManager extends JFrame {

    public JFrame frame;
    private static JTextArea textArea = new JTextArea(24, 85);

    public static void clear() {
        textArea.selectAll();
        textArea.replaceSelection("");
    }

    public void allocate() {
        frame = new JFrame("JavaPoly");
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));

        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.setResizable(false);

        frame.add(scroll);

        frame.pack();
        frame.setVisible(true);

        print("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        print("Herzlich Willkommen zu JavaPoly");
        print("");
        print("         Steuerung");
        print("D: Würfeln");
        print("P: Aktuelles Feld kaufen");
        print("S: Zeige deine Stats");
        print("T: Zeige die Stats des aktuellen Felds");
        print("C: Console clearen");
        print("O: Aus dem Gefängnis freikaufen");
        print("");
        print("         Regeln:");
        print("   Versuche so viel wie möglich zu kaufen ohne dabei pleite zu gehen!");
        print("   Solltest du kein Geld mehr haben oder alles besitzen ist das Spiel vorbei!");
        print("   Viel Spaß wünschen euch Florian Scholz und Jona Andresen");
        print("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public static void print(Object x) {
        textArea.append(x == null ? "null\n" : "x   " + x.toString() + "\n");
    }

    public JFrame getFrame() {
        return frame;
    }

    public void stats(Entity entity) {
        print("Das sind deine Stats:");
        print("xxxxxxxxxxxxxxxxxxxxxxxxx");
        print("");
        print("Häuser: [" + entity.getItems().size() + "]");
        entity.getItems().forEach(item -> print("Name: " + item.getName() + "\nPreis: " + item.getValue() + "$\n0"));
        print("");
        print("Geld: " + entity.getMoney() + "€\n");
        print("xxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public void showTileStats(Player player) {
        print("xxxxxxxxxxxxxxxxxxxxxxxxx");
        print("Name: " + HouseManager.getPurchaseable(player.getFieldId()).getName());
        print("Kaufpreis: " + HouseManager.getPurchaseable(player.getFieldId()).getValue());

        if(HouseManager.getPurchaseable(player.getFieldId()).getOwner() != null) {
            print("Besitzer: " + HouseManager.getPurchaseable(player.getFieldId()).getOwner().getName());
        } else {
            print("Es gibt noch keinen Besitzer");
        }

        print("Mietpreis: " + HouseManager.getPurchaseable(player.getFieldId()).getRent());
    }
}
