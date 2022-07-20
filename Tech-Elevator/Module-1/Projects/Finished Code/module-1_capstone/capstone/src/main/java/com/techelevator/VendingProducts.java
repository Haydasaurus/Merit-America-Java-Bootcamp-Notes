package com.techelevator;

import java.text.NumberFormat;
import java.util.Locale;

public class VendingProducts implements Purchasable {
    public String slotId;
    public String name;
    public double price;
    public String category;
    public int inventory=5;
    boolean isInStock = true;
    static NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public VendingProducts(String slotId, String name, double price, String category, int inventory) {
        this.slotId = slotId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.inventory = inventory;
    }

    public VendingProducts(){}

    public String toString(){
        if(this.inventory==0){
            return slotId + " | " + name + " | " + nf.format(price) + " | " + category +" | "+ "SOLD OUT";
        }
        return slotId + " | " + name + " | " + nf.format(price) + " | " + category +" | "+ inventory;
    }

    public String toStringCategory(String category){
        if(category.equalsIgnoreCase("chip")){
            return "Crunch Crunch, Yum!";
        }else if (category.equalsIgnoreCase("candy")){
            return "Munch Munch, Yum!";
        }else if(category.equalsIgnoreCase("drink")){
            return "Glug Glug, Yum!";
        }else return "Chew Chew, Yum!";
    }

    @Override
    public double getTotal() {
        double sum = 0;
        sum += getPrice();
        return sum;
    }

    public boolean isInStock(){
        if(this.inventory<=0){
            isInStock=false;
        }
        return isInStock;
    }
}
