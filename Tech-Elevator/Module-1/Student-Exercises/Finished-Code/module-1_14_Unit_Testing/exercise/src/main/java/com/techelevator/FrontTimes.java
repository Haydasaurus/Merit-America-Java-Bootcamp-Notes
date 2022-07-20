package com.techelevator;

public class FrontTimes {

	/*
	 * Given a string and a non-negative int n, we'll say that the front of the
	 * string is the first 3 chars, or whatever is there if the string is less than
	 * length 3. Return n copies of the front; frontTimes("Chocolate", 2) →
	 * "ChoCho" frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) →
	 * "AbcAbcAbc"
	 */
	public String generateString(String str, int n) {
		String result = "";
		if (str != null) {
			if (str.length() <= 3) {
				for (int i = 0; i < n; i++) {
					result += str;
				}
			} else {
				for (int i = 0; i < n; i++) {
					result += str.substring(0, 3);
				}
			}
		}
		return result;
	}

}
