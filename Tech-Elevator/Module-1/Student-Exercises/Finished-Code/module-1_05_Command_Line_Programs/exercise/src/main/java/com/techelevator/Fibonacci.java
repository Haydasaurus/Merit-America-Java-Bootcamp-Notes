package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		int fibonacciNumber, firstNumber = 0, secondNumber = 1;
		Scanner fibNum = new Scanner(System.in);
		System.out.println("Please enter the Fibonacci Number: ");
		fibonacciNumber = fibNum.nextInt();

		while (firstNumber <= fibonacciNumber) {
			if (firstNumber * 1.5 > fibonacciNumber) {
				System.out.print(firstNumber+" ");
			} else if (firstNumber <= fibonacciNumber) {
				System.out.print(firstNumber+", ");
			}
			int sumOfBoth = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = sumOfBoth;

		}
	}
}
