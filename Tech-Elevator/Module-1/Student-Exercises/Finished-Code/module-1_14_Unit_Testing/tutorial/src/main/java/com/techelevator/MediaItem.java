package com.techelevator;

public abstract class MediaItem implements Purchasable {
    protected String title;
    protected double price;

    public MediaItem(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean isTaxable() {
        return true;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
