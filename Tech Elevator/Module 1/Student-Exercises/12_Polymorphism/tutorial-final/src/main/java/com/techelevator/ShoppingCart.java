package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart
 */
public class ShoppingCart {

	private List<Purchasable> itemsToBuy = new ArrayList<>();

	public void add(Purchasable itemToAdd) {
	    itemsToBuy.add(itemToAdd);
	}

	public double getTotalPrice() {
	    double total = 0.0;
	    for (Purchasable item : itemsToBuy) {
	        total += item.getPrice();
	    }
	    return total;
	}

	public String receipt() {
	    String receipt = "\nReceipt\n";
	    for (Purchasable item : itemsToBuy) {
	        receipt += item;
	        receipt += "\n";
	    }

	    receipt += "\nTotal: $" + getTotalPrice();

	    return receipt;
	}
}
