package de.scholzf.javapoly.Manager;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommunityCard {

    private String name;
    private String action;

    public CommunityCard(String name, String action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Action: " + action);
    }

}
