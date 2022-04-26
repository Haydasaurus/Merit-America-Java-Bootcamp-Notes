package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coffee implements Purchasable {
    private String size;
    private String blend;
    private List<String> additions = new ArrayList<>();
    private double price;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBlend() {
        return blend;
    }

    public void setBlend(String blend) {
        this.blend = blend;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void add(String addition) {
        additions.add(addition);
    }

    public Coffee(String size, String blend, String[] additions, double price) {
        this.size = size;
        this.blend = blend;
        this.additions.addAll(Arrays.asList(additions));
        this.price = price;
    }

    @Override
    public String toString() {
        return size + " coffee, " +
                blend + " (" +
                String.join(",", additions) +
                "). Price: $" + price;
    }
}
