package com.techelevator;

import java.text.DecimalFormat;

public class Movie extends MediaItem {
    private String rating;
    private int runLength;

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public int getRunLength() {
        return runLength;
    }
    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    public Movie(String title, String rating, int runLength, double price) {
        super(title, price);
        this.rating = rating;
        this.runLength = runLength;
    }

    @Override
    public String toString() {
        DecimalFormat money = new DecimalFormat ("$0.00");
        return "Movie: '" + title + "'(" + rating + "), Price: " + money.format(price);
    }
}
