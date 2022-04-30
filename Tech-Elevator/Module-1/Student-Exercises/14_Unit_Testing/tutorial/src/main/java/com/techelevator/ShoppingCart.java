package com.techelevator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart
 */
public class ShoppingCart {

	private List<Purchasable> itemsToBuy = new ArrayList<>();
	private double taxRate;

	public ShoppingCart(double taxRate) {
		this.taxRate = taxRate;
	}
	public void add(Purchasable itemToAdd) {
	    itemsToBuy.add(itemToAdd);
	}

	public double getSubtotalPrice() {
		// Sum the prices of all items
		double subtotal = 0.0;
		for (Purchasable item : itemsToBuy) {
			subtotal += item.getPrice();
		}
		return subtotal;
	}

	public double getTax() {
		// Apply the tax rate to the price of all the taxable items
		double tax = 0.0;
		for (Purchasable item : itemsToBuy) {
			tax += item.getPrice() * this.taxRate;
		}
		return tax;
	}

	public double getTotalPrice() {
		// Sum the price of all items, plus the tax rate applied to the price of only taxable items
		return getSubtotalPrice() + getTax();
	}

	public String receipt() {
	    String receipt = "\nReceipt\n\n";
	    for (Purchasable item : itemsToBuy) {
	        receipt += item;
	        receipt += "\n";
	    }

		DecimalFormat money = new DecimalFormat ("$0.00");
		receipt += "\nSubtotal: " + money.format(getSubtotalPrice());
		receipt += "\nTax: " + money.format(getTax());
		receipt += "\nTotal: " + money.format(getTotalPrice());

	    return receipt;
	}
}
