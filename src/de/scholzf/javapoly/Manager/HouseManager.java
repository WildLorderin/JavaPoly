package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.Base.Purchaseable;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings.House;

import java.util.ArrayList;
import java.util.List;

public class HouseManager {

    private List<Purchaseable> purchaseables = new ArrayList<>();

    public void create() {
        purchaseables.add(new House("Sportplatz", 300));
        purchaseables.add(new House("Uni-Bad", 250));

        purchaseables.add(new House("NW1", 800));
        purchaseables.add(new House("NW2", 800));

        purchaseables.add(new House("SFG", 350));
        purchaseables.add(new House("Cartesium", 350));

        purchaseables.add(new House("GEO", 400));
        purchaseables.add(new House("IW3", 550));
        purchaseables.add(new House("SuUB", 1150));

        purchaseables.add(new House("Mensa", 1500));
        purchaseables.add(new House("Galileo Residenz", 1500));

        purchaseables.add(new House("VWG", 1300));
        purchaseables.add(new House("MZH", 1300));

        purchaseables.add(new House("Universum", 1300));
        purchaseables.add(new House("GW1", 500));
        purchaseables.add(new House("GW1-HS", 650));
    }

    public Purchaseable getPurchaseable(int index) {
        return this.purchaseables.get(0);
    }

    public List<Purchaseable> getPurchaseables() {
        return this.purchaseables;
    }

}
