package de.scholzf.javapoly.Entity.GameObjects.Utils;

import java.util.concurrent.ThreadLocalRandom;

public class Die {

    private int first, second;

    public boolean isDoublets() {
        return first == second;
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }

    public int getSum() {
        return getFirst() + getSecond();
    }

    public void rollDie() {
        first = ThreadLocalRandom.current().nextInt(1, 6);
        second = ThreadLocalRandom.current().nextInt(1, 6);
    }

}
