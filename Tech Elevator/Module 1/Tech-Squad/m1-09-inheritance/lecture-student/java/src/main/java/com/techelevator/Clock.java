package com.techelevator;

// Clock.java
public class Clock {
    private int hour;
    private int minute;
    private int second;

    // Overloaded Constructor
    public Clock() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    // Constructor
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void tick(int numberOfTimes) {
        for(int i = 1; i <= numberOfTimes; i++) {
            this.tick();
        }
    }

    public void tick() {
        this.second += 1;

        if (this.second >= 60) {
            this.minute += 1;
            this.second = 0;
        }

        if (this.minute >= 60) {
            this.hour += 1;
            this.minute = 0;
        }

        if (this.hour >= 24) {
            this.hour = 0;
        }
    }

    // Getters and setters
    public String getCurrentTime() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }
}