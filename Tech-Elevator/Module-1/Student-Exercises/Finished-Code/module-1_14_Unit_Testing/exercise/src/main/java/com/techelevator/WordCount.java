package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for
	 * each different string, with the value the number of times that string appears
	 * in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	 * getCount([]) → {}
	 * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> getCount(String[] words) {
		Map<String, Integer> output = new HashMap<>();

		if (words != null) {
			for (String word : words) {
				if (!output.containsKey(word)) {
					output.put(word, 1);
				} else {
					output.put(word, output.get(word) + 1);
				}
			}
		}

		return output;
	}
}