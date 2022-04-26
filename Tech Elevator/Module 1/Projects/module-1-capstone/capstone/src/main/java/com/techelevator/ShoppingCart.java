package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public List<Purchasable> itemsToBuy = new ArrayList<>();

    public void addItems(Purchasable itemsToAdd){
        itemsToBuy.add(itemsToAdd);
    }

    public double getPrice(){
        double total = 0;
        for(Purchasable items : itemsToBuy){
            total+= items.getTotal();
        }
        return total;
    }
}
