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
        cards.add(new CommunityCard("BAföG Rückzahlung", "Du musst leider einen Teil Deines BAföG zurückzahlen. Zahle 250€"));
        cards.add(new CommunityCard("Semesterbeitrag steht an! ", "Zahle 349€"));
    }

    public CommunityCard getCard() {
        int index = ThreadLocalRandom.current().nextInt(cards.size());
        return cards.get(index);
    }

}
