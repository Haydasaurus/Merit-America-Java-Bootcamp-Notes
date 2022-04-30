package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter a series of decimal values seperated by spaces:");

		String input = keyboard.nextLine();
		String[] userInput = input.split(" ");

		for (int i = 0; i < userInput.length; i++) {
			int decimalValue = Integer.parseInt(userInput[i]);
			String binaryString = new String("");

			for (; decimalValue > 0; ) {
				binaryString = (decimalValue % 2) + binaryString;
				decimalValue = decimalValue / 2;
			}
			System.out.println(userInput[i] + " in binary is " + binaryString);
		}
	}
}