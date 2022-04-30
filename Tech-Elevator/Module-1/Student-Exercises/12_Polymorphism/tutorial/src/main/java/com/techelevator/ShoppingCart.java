package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart
 */
public class ShoppingCart {

	private List<MediaItem> itemsToBuy = new ArrayList<>();

	public void add(MediaItem itemToAdd) {
	    itemsToBuy.add(itemToAdd);
	}

	public double getTotalPrice() {
	    double total = 0.0;
	    for (MediaItem item : itemsToBuy) {
	        total += item.getPrice();
	    }
	    return total;
	}

	public String receipt() {
	    String receipt = "\nReceipt\n";
	    for (MediaItem item : itemsToBuy) {
	        receipt += item;
	        receipt += "\n";
	    }

	    receipt += "\nTotal: $" + getTotalPrice();

	    return receipt;
	}
}
