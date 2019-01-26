package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.Base.Purchaseable;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Buildings.House;

import java.util.ArrayList;
import java.util.List;

public class HouseManager {

    private static List<Purchaseable> purchaseables = new ArrayList<>();

    public void create() {
        purchaseables.add(null);
        purchaseables.add(new House("Sportplatz", 300, 250));
        purchaseables.add(new House("Uni-Bad", 250, 200));
        purchaseables.add(null);
        purchaseables.add(new House("NW1", 800, 600));
        purchaseables.add(new House("NW2", 800, 600));
        purchaseables.add(null);
        purchaseables.add(new House("SFG", 350, 150));
        purchaseables.add(new House("Cartesium", 350, 150));
        purchaseables.add(null);
        purchaseables.add(new House("GEO", 400, 150));
        purchaseables.add(new House("IW3", 550, 250));
        purchaseables.add(null);
        purchaseables.add(new House("Galileo Residenz", 1500, 800));
        purchaseables.add(null);
        purchaseables.add(new House("Mensa", 1500, 900));
        purchaseables.add(new House("SuUB", 1150, 750));
        purchaseables.add(new House("VWG", 1300, 950));
        purchaseables.add(null);
        purchaseables.add(new House("MZH", 1300, 900));
        purchaseables.add(null);
        purchaseables.add(new House("Universum", 1450, 1000));
        purchaseables.add(new House("GW1", 500, 250));
        purchaseables.add(new House("GW1-HS", 650, 400));
    }

    public static Purchaseable getPurchaseable(int index) {
        return purchaseables.get(index);
    }

    public static  List<Purchaseable> getPurchaseables() {
        return purchaseables;
    }

}
