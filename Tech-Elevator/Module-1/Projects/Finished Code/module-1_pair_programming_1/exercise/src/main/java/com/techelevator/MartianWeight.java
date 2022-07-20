package com.techelevator;

import java.util.Scanner;
/*
In case you've ever pondered how much you weigh on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

$ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth is 37 lbs. on Mars.
 235 lbs. on Earth is 88 lbs. on Mars.
 185 lbs. on Earth is 69 lbs. on Mars. 
 */

public class MartianWeight {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		double firstWeight = 0;
		double secondWeight = 0;
		double thirdWeight = 0;
		String input = "";

		System.out.println("Please Enter Your first Weight");
		input = keyboard.nextLine();
		firstWeight = Double.parseDouble(input);

		System.out.println("Please Enter Your second Weight");
		input = keyboard.nextLine();
		secondWeight = Double.parseDouble(input);

		System.out.println("Please Enter Your third Weight");
		input = keyboard.nextLine();
		thirdWeight = Double.parseDouble(input);

		System.out.printf(" %.2f lbs. on Earth is %.2f lbs. on Mars \n", firstWeight, (firstWeight * 0.378) );
		System.out.printf(" %.2f lbs. on Earth is %.2f lbs. on Mars \n", secondWeight, (secondWeight * 0.378) );
		System.out.printf(" %.2f lbs. on Earth is %.2f lbs. on Mars \n", thirdWeight, (thirdWeight * 0.378)  );

	}

}
