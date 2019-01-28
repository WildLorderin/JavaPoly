package de.scholzf.javapoly.Entity.GameObjects.Utils.Server;

public interface Likes {

    void add(String topic, String user);
    int get(String topic);

}
