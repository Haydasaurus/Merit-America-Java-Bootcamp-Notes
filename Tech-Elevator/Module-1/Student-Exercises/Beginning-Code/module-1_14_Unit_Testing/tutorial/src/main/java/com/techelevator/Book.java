package com.techelevator;

import java.text.DecimalFormat;

/**
 * Book
 */
public class Book extends MediaItem {

	private String author;

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String title, String author, double price) {
		super(title, price);
	    this.author = author;
	}
	
	@Override
	public String toString() {
		DecimalFormat money = new DecimalFormat ("$0.00");
		return "Book: '" + title + "' by " + author + ", Price: " + money.format(price);
	}
}
