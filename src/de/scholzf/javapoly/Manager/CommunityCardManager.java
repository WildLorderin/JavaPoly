package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommunityCardManager {

    private String name;
    private String action;
    private List<Entity> entities;
    private List<CommunityCard> cards = new ArrayList<>();

    public CommunityCardManager(List<Entity> entities) {
        this.entities = entities;
    }

    public void create() {
        cards.add(new CommunityCard("BAföG Rückzahlung", "Du musst leider einen Teil Deines BAföG zurückzahlen. Zahle 250€", 0));
        cards.add(new CommunityCard("Semesterbeitrag steht an! ", "Zahle 349€", 1));
        cards.add(new CommunityCard("Vorläufiges BAföG", "Du bekommst Dein BaföG schon heute! Gehe zurück zum Start und kassieren 450€", 2));
        cards.add(new CommunityCard("Nachhilfe", "Um das Semester zu bestehen musst Du Dir Nachhilfe nehmrn. Zahle 50€", 3));
        cards.add(new CommunityCard("Nachhilfe", "Du gibts Nachhilfe und bekommst 100€", 4));
        cards.add(new CommunityCard("Mensakarte", "Du musst Geld auf deine Karte einzahlen. Zahle 100€", 5));
        cards.add(new CommunityCard("Auf mein Nacken!", "Im Suff hast Du zu viel Akohol ausgegeben. Zahle 400€ ", 6));
        cards.add(new CommunityCard("Geburtstag!", "Du bekommst von Deinen Freunden 1500€ zum Geburstag!", 7));
    }

    public CommunityCard getCard() {
        int index = ThreadLocalRandom.current().nextInt(cards.size());
        return cards.get(index);
    }

}
