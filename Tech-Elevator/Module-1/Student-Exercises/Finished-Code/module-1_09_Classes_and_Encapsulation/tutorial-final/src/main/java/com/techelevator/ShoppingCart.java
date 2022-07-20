package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart
 */
public class ShoppingCart {

	private List<Book> booksToBuy = new ArrayList<>();

	public void add(Book bookToAdd) {
	    booksToBuy.add(bookToAdd);
	}

	public double getTotalPrice() {
	    double total = 0.0;
	    for(Book book : booksToBuy) {
	        total += book.getPrice();
	    }
	    return total;
	}

	public String receipt() {
	    String receipt = "\nReceipt\n";
	    for(Book book : booksToBuy) {
	        receipt += book.bookInfo();
	        receipt += "\n";
	    }

	    receipt += "\nTotal: $" + getTotalPrice();

	    return receipt;
	}
}