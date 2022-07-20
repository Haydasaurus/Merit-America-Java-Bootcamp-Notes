package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		double userTemperature = 0;
		double convertedTemperature;
		String input = "";
		String degreesIn = "";

		System.out.println(" Please enter the temperature:");
		input = keyboard.nextLine();
		userTemperature = Double.parseDouble(input);

		System.out.println("Is the temperature in [C]elcius, or [F]arenheit?");
		degreesIn = keyboard.nextLine();


		if(degreesIn.equalsIgnoreCase("c") ) {
			convertedTemperature = userTemperature * 1.8 + 32;
			System.out.printf("%.1f C is %.1f F",userTemperature, convertedTemperature );
		}else {
			convertedTemperature = (userTemperature - 32) / 1.8;
			System.out.printf("%.1f F is %.1f C",userTemperature, convertedTemperature );
		}
	}
}
