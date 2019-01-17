package de.scholzf.javapoly.entitiy.GameObjects.Tiles;

import de.scholzf.javapoly.entitiy.GameObjects.Entities.Entity;
import de.scholzf.javapoly.entitiy.GameObjects.Entities.Player;
import de.scholzf.javapoly.entitiy.GameObjects.Utils.Die;
import de.scholzf.javapoly.entitiy.exceptions.PurchaseException;

import java.util.ArrayList;
import java.util.List;

public class Jail extends Tile {

    private Die die;
    private Player player;
    private double rent;
    private List<Entity> imprisoned;


    public Jail() {
        super(TileType.JAIL, "floor");
        imprisoned = new ArrayList<>();
        rent = 50;
        die = new Die();
    }

    public List<Entity> getImprisoned() {
        return this.imprisoned;
    }

    public void payRent() throws PurchaseException {
        if(player.isCreditWorth(rent)) {
        } else {
            throw new PurchaseException("Du hast nicht genügent Geld um Dich freizukaufen.");
        }
    }

    public void rollDie() {

        int count = 0;

        do {
            die.rollDie();

            if(die.isDoublets()) {
                System.out.println("Du bist draußen!");
                this.imprisoned.remove(player);
                this.player.setImprisioned(false);
                return;
            } else {
                count++;
            }
        } while(count < 3);

        System.out.println("Du hast es leider nicht geschafft :(");
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void imprison(Entity entity) {
        this.imprisoned.add(entity);
    }

}
