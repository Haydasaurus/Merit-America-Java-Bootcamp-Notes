package com.techelevator;

// CuckooClock.java
public class CuckooClock extends Clock {

    public CuckooClock() {
        super();
    }

    public CuckooClock(int hour, int minute, int second) {
        super(hour, minute, second);
    }

    public void tick() {
        super.tick();
        if (getSecond() == 0 && getMinute() == 0) {
            System.out.println("cuckoo cuckoo");
        }
    }
}
