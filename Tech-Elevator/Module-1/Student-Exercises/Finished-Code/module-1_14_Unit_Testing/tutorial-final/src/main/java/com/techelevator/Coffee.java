package com.techelevator;

import java.text.DecimalFormat;
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

    @Override
    public boolean isTaxable() {
        return false;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getAdditions() {
        return additions.toArray(new String[0]);
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
        DecimalFormat money = new DecimalFormat ("$0.00");
        return "Coffee: " + size + " " +
                blend + " (" +
                String.join(",", additions) +
                "). Price: " + money.format(price);
    }
}
