package de.scholzf.javapoly.Manager;

import de.scholzf.javapoly.Entity.Base.EntityFigure;
import de.scholzf.javapoly.Entity.Base.GameObjectType;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Entity;
import de.scholzf.javapoly.Entity.GameObjects.Entities.Player;
import de.scholzf.javapoly.Entity.GameObjects.GameObject;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Jail;
import de.scholzf.javapoly.Entity.GameObjects.Tiles.Tile;
import de.scholzf.javapoly.Entity.GameObjects.Utils.Die;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static int first, second;
    private static Player localPlayer;
    private static Die die;
    private static List<Entity> players = new ArrayList<>();
    private static boolean firstRound = true;
    public int stepsLeft = 0;

    public void rollDie() {
        die = new Die();
        die.rollDie();
        first = die.getFirst();
        second = die.getSecond();
    }

    public void add(Entity entity) {
        players.add(entity);
    }

    public void next() {
        localPlayer.setIds();

        if(localPlayer.isImprisoned()) {
            int tries = 0;

            while(tries < 3) {
                getDie().rollDie();

                if(getDie().isDoublets()) {
                    ConsoleManager.print("Du hast einen Pasch mit " + getDie().getFirst() + " und " + getDie().getSecond() + " gewürfelt.");
                    ConsoleManager.print("Du bist aus dem Gefängnis draußen!");
                    localPlayer.setImprisioned(false);
                    return;
                } else {
                    ConsoleManager.print("Du hast mit " + getDie().getFirst() + " und " + getDie().getSecond()  + " leinder keinen Pasch gewürfelt.");
                    ConsoleManager.print("Du hast noch " + (3 - tries) + " Versuche um aus dem Gefängnis zu kommen!");
                    tries++;
                }
            }
        }

        rollDie();

        int sum = 1;
        stepsLeft = sum;
        localPlayer.stepsLeft = stepsLeft;

        for(int i = 0; i < sum; i++) {
            try {
                Thread.sleep(250);
                localPlayer.move();
                localPlayer.stepsLeft--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        localPlayer.checkCurrentField();

        firstRound = false;
    }

    public void create() {
        new Tile(1, 0, "yellow");
        new Tile(2, 0, "community_field");
        new Tile(3, 0, "lapis");
        new Tile(4, 0, "lapis");
        new Tile(5, 0, "lapis");
        new Tile(6, 0, "start");

        new Tile(0, 1, "yellow");
        new Tile(0, 2, "diamond");
        new Tile(0, 3, "diamond");
        new Tile(0, 4, "community_field");
        new Tile(0, 5, "orange");
        new Tile(0, 6, "emerald");

        new Tile(1, 6, "orange");
        new Tile(2, 6, "orange");
        new Tile(3, 6, "community_field");
        new Tile(4, 6, "lime");
        new Tile(5, 6, "lime");
        new Tile(6, 5, "magenta");
        new Tile(6, 6, "jail");

        new Tile(6, 1, "lightblue");
        new Tile(6, 2, "lightblue");
        new Tile(6, 3, "community_field");
        new Tile(6, 4, "magenta");

        Jail jail = new Jail();

        localPlayer = new Player("Florian", 6, 0, 1, "student", 1000000, GameObjectType.PLAYER, EntityFigure.SHOE, jail);
        add(localPlayer);
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }

    public List<Entity> getPlayers() {
        return players;
    }

    public int getKey() {
        return GameObject.Canvas.getInstance().getNextKey();
    }

    public Die getDie() {
        return die;
    }

    public void onGoSpace(Entity entity) {
        if(!firstRound)
            entity.setMoney(entity.getMoney() + 450);
    }

}
