package com.techelevator;

// GrandfatherClock.java
public class GrandfatherClock extends Clock {

    public GrandfatherClock() {
        super();
    }

    public GrandfatherClock(int hour, int minute, int second) {
        super(hour, minute, second);
    }

    public void tick() {
        super.tick();
        if (getSecond() % 2 == 0) {
            System.out.println("tick");
        } else {
            System.out.println("tock");
        }
    }
}
