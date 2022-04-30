package com.techelevator;

import java.util.Scanner;

public class MakeChange {

	/*
	Write a command line program which prompts the user for the total bill, and the amount tendered.
	It should then display the change required.
	
	C:\dir\to\the\project\target\classes> java com.techelevator.MakeChange
	
	Please enter the amount of the bill: 23.65
	Please enter the amount tendered: 100.00
	The change required is 76.35
	*/

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
			double totalBill = 0;
			double amountTendered = 0;
			double change = 0;

		String input ="";

		System.out.println("Please enter the amount of the bill.");
			input = keyboard.nextLine();
			totalBill = Double.parseDouble(input);

		System.out.println("Please enter the amount of the tendered.");
			input = keyboard.nextLine();
			amountTendered = Double.parseDouble(input);

		change = (amountTendered - totalBill);
			System.out.printf("Bill total %.2f\n", totalBill);
			System.out.printf("Amount tendered %.2f\n", amountTendered);
			System.out.printf("Change %.2f\n", change);
	}

}
