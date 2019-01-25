package de.scholzf.javapoly.Manager;

public class CommunityCard {

    private String name;
    private String action;
    private int id;

    public CommunityCard(String name, String action, int id) {
        this.name = name;
        this.action = action;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void print() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("0   Name: " + name);
        System.out.println("0   Action: " + action);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
    }

}
