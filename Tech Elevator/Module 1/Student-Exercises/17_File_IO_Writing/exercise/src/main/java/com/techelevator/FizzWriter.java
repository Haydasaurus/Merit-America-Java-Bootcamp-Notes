package com.techelevator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FizzWriter {

	public static void main(String[] args) {

		List<String> fizzBuzz = new ArrayList<>();
		for(int i = 1; i <= 300; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				fizzBuzz.add("FizzBuzz");
			} else if (i % 3 == 0) {
				fizzBuzz.add("Fizz");
			} else if (i % 5 == 0) {
				fizzBuzz.add("Buzz");
			} else {
				fizzBuzz.add(Integer.toString(i));
			}
		}
		String result = String.join("\n",fizzBuzz);
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/test/resources/fizzbuzz.txt", true)))) {
			out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}