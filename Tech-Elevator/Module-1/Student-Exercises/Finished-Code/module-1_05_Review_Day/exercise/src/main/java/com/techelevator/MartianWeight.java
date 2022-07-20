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

		double firstEarthWeight = 0;
		double secondEarthWeight = 0;
		double thirdEarthWeight = 0;
		String input = "";

		System.out.println("Please Enter Your First Weight");
		input = keyboard.nextLine();
		firstEarthWeight = Double.parseDouble(input);

		System.out.println("Please Enter Your Second Weight");
		input = keyboard.nextLine();
		secondEarthWeight = Double.parseDouble(input);

		System.out.println("Please Enter Your Third Weight");
		input = keyboard.nextLine();
		thirdEarthWeight = Double.parseDouble(input);

		System.out.printf(" %.2f lbs. on Earth is %.2f lbs. on Mars \n", firstEarthWeight, (firstEarthWeight * 0.378) );
		System.out.printf(" %.2f lbs. on Earth is %.2f lbs. on Mars \n", secondEarthWeight, (secondEarthWeight * 0.378) );
		System.out.printf(" %.2f lbs. on Earth is %.2f lbs. on Mars \n", thirdEarthWeight, (thirdEarthWeight * 0.378)  );

	}

}
