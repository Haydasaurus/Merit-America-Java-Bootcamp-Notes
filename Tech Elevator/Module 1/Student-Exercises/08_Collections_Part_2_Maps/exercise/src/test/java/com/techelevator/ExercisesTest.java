package com.techelevator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

	final double DOUBLE_FUDGE_FACTOR = 0.001d;

	Exercises exercises = new Exercises();

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 *
	 */
	@Test
	public void exercise01_animalGroupName() {
		assertEquals("Input: animalGroupName(\"giraffe\")", "Tower", exercises.animalGroupName("giraffe"));
		assertEquals("Input: animalGroupName(\"GiRaFfE\")", "Tower", exercises.animalGroupName("GiRaFfE"));
		assertEquals("Input: animalGroupName(\"\")", "unknown", exercises.animalGroupName(""));
		assertEquals("Input: animalGroupName(\"Crow\")", "Murder", exercises.animalGroupName("Crow"));
		assertEquals("Input: animalGroupName(\"walrus\")", "unknown", exercises.animalGroupName("walrus"));
		assertEquals("Input: animalGroupName(null)", "unknown", exercises.animalGroupName(null));
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	@Test
	public void exercise02_isItOnSale() {
		assertEquals("Input: isItOnSale({\"kitchen4001\")", 0.20, exercises.isItOnSale("kitchen4001"),
				DOUBLE_FUDGE_FACTOR);
		assertEquals("Input: isItOnSale({\"\")", 0.00, exercises.isItOnSale(""), DOUBLE_FUDGE_FACTOR);
		assertEquals("Input: isItOnSale({\"BEDROOM3434\")", 0.60, exercises.isItOnSale("BEDROOM3434"),
				DOUBLE_FUDGE_FACTOR);
		assertEquals("Input: isItOnSale({\"dungeon9999\")", 0.00, exercises.isItOnSale("dungeon9999"),
				DOUBLE_FUDGE_FACTOR);
		assertEquals("Input: isItOnSale(null)", 0.00, exercises.isItOnSale(null), DOUBLE_FUDGE_FACTOR);
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	@Test
	public void exercise03_robPeterToPayPaul() {
		Map<String, Integer> output = exercises.robPeterToPayPaul(peterPaulInput(2000, 99));
		assertThat("robPeterToPayPaul({\"Peter\": 2000, \"Paul\": 99})", output, hasEntry("Peter", 1000));
		assertThat("robPeterToPayPaul({\"Peter\": 2000, \"Paul\": 99})", output, hasEntry("Paul", 1099));

		output = exercises.robPeterToPayPaul(peterPaulInput(2000, 30000));
		assertThat("robPeterToPayPaul({\"Peter\": 2000, \"Paul\": 30000})", output, hasEntry("Peter", 2000));
		assertThat("robPeterToPayPaul({\"Peter\": 2000, \"Paul\": 30000})", output, hasEntry("Paul", 30000));

		output = exercises.robPeterToPayPaul(peterPaulInput(0, 5000));
		assertThat("robPeterToPayPaul({\"Peter\": 0, \"Paul\": 5000})", output, hasEntry("Peter", 0));
		assertThat("robPeterToPayPaul({\"Peter\": 0, \"Paul\": 5000})", output, hasEntry("Paul", 5000));

		output = exercises.robPeterToPayPaul(peterPaulInput(1, 5000));
		assertThat("robPeterToPayPaul({\"Peter\": 1, \"Paul\": 5000})", output, hasEntry("Peter", 1));
		assertThat("robPeterToPayPaul({\"Peter\": 1, \"Paul\": 5000})", output, hasEntry("Paul", 5000));

		output = exercises.robPeterToPayPaul(peterPaulInput(2345, 500));
		assertThat("robPeterToPayPaul({\"Peter\": 2345, \"Paul\": 500})", output, hasEntry("Peter", 1173));
		assertThat("robPeterToPayPaul({\"Peter\": 2345, \"Paul\": 500})", output, hasEntry("Paul", 1672));

		output = exercises.robPeterToPayPaul(peterPaulInput(5000, 1000));
		assertThat("robPeterToPayPaul({\"Peter\": 5000, \"Paul\": 1000})", output, hasEntry("Peter", 5000));
		assertThat("robPeterToPayPaul({\"Peter\": 5000, \"Paul\": 1000})", output, hasEntry("Paul", 1000));

		output = exercises.robPeterToPayPaul(peterPaulInput(5000, 999));
		assertThat("robPeterToPayPaul({\"Peter\": 5000, \"Paul\": 999})", output, hasEntry("Peter", 2500));
		assertThat("robPeterToPayPaul({\"Peter\": 5000, \"Paul\": 999})", output, hasEntry("Paul", 3499));
	}

	private Map<String, Integer> peterPaulInput(int peterMoney, int paulMoney) {
		HashMap<String, Integer> input = new HashMap<>();
		input.put("Peter", peterMoney);
		input.put("Paul", paulMoney);
		return input;
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 750000, "PeterPaulPartnership": 63500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	@Test
	public void exercise04_peterPaulPartnership() {
		Map<String, Integer> output = exercises.peterPaulPartnership(peterPaulInput(5000, 10000));
		assertThat("peterPaulPartnership({\"Peter\": 5000, \"Paul\": 10000})", output, hasEntry("Peter", 3750));
		assertThat("peterPaulPartnership({\"Peter\": 5000, \"Paul\": 10000})", output, hasEntry("Paul", 7500));
		assertThat("peterPaulPartnership({\"Peter\": 5000, \"Paul\": 10000})", output,
				hasEntry("PeterPaulPartnership", 3750));

		output = exercises.peterPaulPartnership(peterPaulInput(3333, 1234567890));
		assertThat("peterPaulPartnership({\"Peter\": 3333, \"Paul\": 1234567890})", output, hasEntry("Peter", 3333));
		assertThat("peterPaulPartnership({\"Peter\": 3333, \"Paul\": 1234567890})", output,
				hasEntry("Paul", 1234567890));

		output = exercises.peterPaulPartnership(peterPaulInput(4999, 1234567890));
		assertThat("peterPaulPartnership({\"Peter\": 4999, \"Paul\": 1234567890})", output, hasEntry("Peter", 4999));
		assertThat("peterPaulPartnership({\"Peter\": 4999, \"Paul\": 1234567890})", output,
				hasEntry("Paul", 1234567890));

		output = exercises.peterPaulPartnership(peterPaulInput(5000, 9999));
		assertThat("peterPaulPartnership({\"Peter\": 5000, \"Paul\": 9999})", output, hasEntry("Peter", 5000));
		assertThat("peterPaulPartnership({\"Peter\": 5000, \"Paul\": 9999})", output, hasEntry("Paul", 9999));

	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where for every different string in the array,
	 * there is a key of its first character with the value of its last character. In cases where two or more words have the same
	 * first letter but different last letters, words torwards the end of the array take precedence.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	@Test
	public void exercise05_beginningAndEnding() {
		Map<String, String> output = exercises.beginningAndEnding(new String[] { "code", "bug" });
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output.size(), equalTo(2));
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output, hasEntry("b", "g"));
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output, hasEntry("c", "e"));

		output = exercises.beginningAndEnding(new String[] { "man", "moon", "main" });
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output.size(), equalTo(1));
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output, hasEntry("m", "n"));

		output = exercises.beginningAndEnding(new String[] { "muddy", "good", "moat", "good", "night" });
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output.size(), equalTo(3));
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output, hasEntry("m", "t"));
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output, hasEntry("g", "d"));
		assertThat("beginningAndEnding([\"code\", \"bug\"])", output, hasEntry("n", "t"));

	}

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the
	 * number of times that string appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	@Test
	public void exercise06_wordCount() {
		Map<String, Integer> output = exercises.wordCount(new String[] { "a", "b", "a", "c", "b" });
		assertThat("wordCount([\"a\", \"b\", \"a\", \"c\", \"b\"])", output.size(), equalTo(3));
		assertThat("wordCount([\"a\", \"b\", \"a\", \"c\", \"b\"])", output, hasEntry("a", 2));
		assertThat("wordCount([\"a\", \"b\", \"a\", \"c\", \"b\"])", output, hasEntry("b", 2));
		assertThat("wordCount([\"a\", \"b\", \"a\", \"c\", \"b\"])", output, hasEntry("c", 1));

		output = exercises.wordCount(new String[] { "c", "b", "a" });
		assertThat("wordCount([\"c\", \"b\", \"a\"])", output.size(), equalTo(3));
		assertThat("wordCount([\"c\", \"b\", \"a\"])", output, hasEntry("a", 1));
		assertThat("wordCount([\"c\", \"b\", \"a\"])", output, hasEntry("b", 1));
		assertThat("wordCount([\"c\", \"b\", \"a\"])", output, hasEntry("c", 1));

		output = exercises.wordCount(new String[] { });
		assertThat("wordCount([])", output.size(), equalTo(0));
		
		output = exercises.wordCount(new String[] { "ba", "ba", "black", "sheep" });
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\"])", output.size(), equalTo(3));
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\"])", output, hasEntry("ba", 2));
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\"])", output, hasEntry("black", 1));
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\"])", output, hasEntry("sheep", 1));

		output = exercises.wordCount(new String[] { "ba", "ba", "black", "sheep", "ba", "ba", "black", "sheep" });
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\", \"ba\", \"ba\", \"black\", \"sheep\"])", output.size(), equalTo(3));
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\", \"ba\", \"ba\", \"black\", \"sheep\"])", output, hasEntry("ba", 4));
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\", \"ba\", \"ba\", \"black\", \"sheep\"])", output, hasEntry("black", 2));
		assertThat("wordCount([\"ba\", \"ba\", \"black\", \"sheep\", \"ba\", \"ba\", \"black\", \"sheep\"])", output, hasEntry("sheep", 2));
		
		output = exercises.wordCount(new String[] { "apple", "apple", "banana", "apple", "carrot", "banana", "dill", "dill", "banana", "apple" });
		assertThat("wordCount([\"apple\", \"apple\", \"banana\", \"apple\", \"carrot\", \"banana\", \"dill\", \"dill\", \"banana\", \"apple\"])", output.size(), equalTo(4));
		assertThat("wordCount([\"apple\", \"apple\", \"banana\", \"apple\", \"carrot\", \"banana\", \"dill\", \"dill\", \"banana\", \"apple\"])", output, hasEntry("apple", 4));
		assertThat("wordCount([\"apple\", \"apple\", \"banana\", \"apple\", \"carrot\", \"banana\", \"dill\", \"dill\", \"banana\", \"apple\"])", output, hasEntry("banana", 3));
		assertThat("wordCount([\"apple\", \"apple\", \"banana\", \"apple\", \"carrot\", \"banana\", \"dill\", \"dill\", \"banana\", \"apple\"])", output, hasEntry("carrot", 1));
		assertThat("wordCount([\"apple\", \"apple\", \"banana\", \"apple\", \"carrot\", \"banana\", \"dill\", \"dill\", \"banana\", \"apple\"])", output, hasEntry("dill", 2));

		output = exercises.wordCount(new String[] { "apple", "apple", "apple", "apple", "apple", "apple" });
		assertThat("wordCount([\"apple\", \"apple\", \"apple\", \"apple\", \"apple\", \"apple\"])", output.size(), equalTo(1));
		assertThat("wordCount([\"apple\", \"apple\", \"apple\", \"apple\", \"apple\", \"apple\"])", output, hasEntry("apple", 6));

	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * integerCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * integerCount([]) → {}
	 *
	 */
	@Test
	public void exercise07_integerCount() {
		Map<Integer, Integer> output = exercises.integerCount(new int[] { 1, 99, 63, 1, 55, 77, 63, 99, 63, 44 });
		assertThat("integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44])", output.size(), equalTo(6));
		assertThat("integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44])", output, hasEntry(1, 2));
		assertThat("integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44])", output, hasEntry(44, 1));
		assertThat("integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44])", output, hasEntry(55, 1));
		assertThat("integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44])", output, hasEntry(63, 3));
		assertThat("integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44])", output, hasEntry(77, 1));
		assertThat("integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44])", output, hasEntry(99, 2));

		output = exercises.integerCount(new int[] { 107, 33, 107, 33, 33, 33, 106, 107 });
		assertThat("integerCount([107, 33, 107, 33, 33, 33, 106, 107])", output.size(), equalTo(3));
		assertThat("integerCount([107, 33, 107, 33, 33, 33, 106, 107])", output, hasEntry(33, 4));
		assertThat("integerCount([107, 33, 107, 33, 33, 33, 106, 107])", output, hasEntry(106, 1));
		assertThat("integerCount([107, 33, 107, 33, 33, 33, 106, 107])", output, hasEntry(107, 3));

		output = exercises.integerCount(new int[0]);
		assertThat("integerCount([])", output.size(), equalTo(0));
	}

	/*
	 * Given an array of strings, return a Map<String, Boolean> where each different string is a key and value
	 * is true only if that string appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	@Test
	public void exercise08_wordMultiple() {
		Map<String, Boolean> output = exercises.wordMultiple(new String[] { "a", "b", "a", "c", "b" });
		assertThat("wordMultiple([\"a\", \"b\", \"a\", \"c\", \"b\"])", output, hasEntry("b", true));
		assertThat("wordMultiple([\"a\", \"b\", \"a\", \"c\", \"b\"])", output, hasEntry("c", false));
		assertThat("wordMultiple([\"a\", \"b\", \"a\", \"c\", \"b\"])", output, hasEntry("a", true));

		exercises.wordMultiple(new String[] { "c", "b", "a" });
		assertThat("wordMultiple([\"c\", \"b\", \"a\"])", output, hasEntry("b", true));
		assertThat("wordMultiple([\"c\", \"b\", \"a\"])", output, hasEntry("c", false));
		assertThat("wordMultiple([\"c\", \"b\", \"a\"])", output, hasEntry("a", true));
	}

	/*
	 * Given two maps, Map<String, Integer>, merge the two into a new map, Map<String, Integer> where keys in Map2,
	 * and their Integer values, are added to the Integer values of matching keys in Map1. Return the new map.
	 *
	 * Unmatched keys and their Integer values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	@Test
	public void exercise09_consolidateInventory() {
		Map<String, Integer> inventory1 = new HashMap<>();
		inventory1.put("SKU1", 100);
		inventory1.put("SKU2", 53);
		inventory1.put("SKU3", 44);

		Map<String, Integer> inventory2 = new HashMap<>();
		inventory2.put("SKU2", 11);
		inventory2.put("SKU4", 5);

		Map<String, Integer> output = exercises.consolidateInventory(inventory1, inventory2);
		assertThat("consolidateInventory({\"SKU1\": 100, \"SKU2\": 53, \"SKU3\": 44} {\"SKU2\":11, \"SKU4\": 5})",
				output.size(), equalTo(4));
		assertThat("consolidateInventory({\"SKU1\": 100, \"SKU2\": 53, \"SKU3\": 44} {\"SKU2\":11, \"SKU4\": 5})",
				output, hasEntry("SKU1", 100));
		assertThat("consolidateInventory({\"SKU1\": 100, \"SKU2\": 53, \"SKU3\": 44} {\"SKU2\":11, \"SKU4\": 5})",
				output, hasEntry("SKU2", 64));
		assertThat("consolidateInventory({\"SKU1\": 100, \"SKU2\": 53, \"SKU3\": 44} {\"SKU2\":11, \"SKU4\": 5})",
				output, hasEntry("SKU3", 44));
		assertThat("consolidateInventory({\"SKU1\": 100, \"SKU2\": 53, \"SKU3\": 44} {\"SKU2\":11, \"SKU4\": 5})",
				output, hasEntry("SKU4", 5));

		
		inventory1 = new HashMap<>();
		inventory1.put("SKU_4", 0);
		inventory1.put("SKU_23", 53);
		inventory1.put("SKU_39", 66);
		inventory1.put("SKU_X", 8);

		inventory2 = new HashMap<>();
		inventory2.put("SKU_4", 68);
		inventory2.put("SKU_23", 33);
		inventory2.put("SKU_50", 444);
		inventory2.put("SKU_X", 1);

		output = exercises.consolidateInventory(inventory1, inventory2);
		assertThat("consolidateInventory({\"SKU_4\": 0, \"SKU_23\": 53, \"SKU_39\": 66, \"SKU_X\": 8} {\"SKU_4\":68, \"SKU_23\": 33, \"SKU_50\": 444, \"SKU_X\": 1})",
				output.size(), equalTo(5));
		assertThat("consolidateInventory({\"SKU_4\": 0, \"SKU_23\": 53, \"SKU_39\": 66, \"SKU_X\": 8} {\"SKU_4\":68, \"SKU_23\": 33, \"SKU_50\": 444, \"SKU_X\": 1})",
				output, hasEntry("SKU_4", 68));
		assertThat("consolidateInventory({\"SKU_4\": 0, \"SKU_23\": 53, \"SKU_39\": 66, \"SKU_X\": 8} {\"SKU_4\":68, \"SKU_23\": 33, \"SKU_50\": 444, \"SKU_X\": 1})",
				output, hasEntry("SKU_23", 86));
		assertThat("consolidateInventory({\"SKU_4\": 0, \"SKU_23\": 53, \"SKU_39\": 66, \"SKU_X\": 8} {\"SKU_4\":68, \"SKU_23\": 33, \"SKU_50\": 444, \"SKU_X\": 1})",
				output, hasEntry("SKU_39", 66));
		assertThat("consolidateInventory({\"SKU_4\": 0, \"SKU_23\": 53, \"SKU_39\": 66, \"SKU_X\": 8} {\"SKU_4\":68, \"SKU_23\": 33, \"SKU_50\": 444, \"SKU_X\": 1})",
				output, hasEntry("SKU_50", 444));
		assertThat("consolidateInventory({\"SKU_4\": 0, \"SKU_23\": 53, \"SKU_39\": 66, \"SKU_X\": 8} {\"SKU_4\":68, \"SKU_23\": 33, \"SKU_50\": 444, \"SKU_X\": 1})",
				output, hasEntry("SKU_X", 9));

		
		inventory1 = new HashMap<>();
		inventory1.put("Lorem", 11);
		inventory1.put("Ipsum", 22);
		inventory1.put("Dolor", 33);
		inventory1.put("Sit", 44);
		inventory1.put("Amet", 55);

		inventory2 = new HashMap<>();
		//nothing

		output = exercises.consolidateInventory(inventory1, inventory2);
		assertThat("consolidateInventory({\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55} { })",
				output.size(), equalTo(5));
		assertThat("consolidateInventory({\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55} { })",
				output, hasEntry("Lorem", 11));
		assertThat("consolidateInventory({\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55} { })",
				output, hasEntry("Ipsum", 22));
		assertThat("consolidateInventory({\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55} { })",
				output, hasEntry("Dolor", 33));
		assertThat("consolidateInventory({\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55} { })",
				output, hasEntry("Sit", 44));
		assertThat("consolidateInventory({\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55} { })",
				output, hasEntry("Amet", 55));
		
		
		inventory1 = new HashMap<>();
		//nothing

		inventory2 = new HashMap<>();
		inventory2.put("Lorem", 11);
		inventory2.put("Ipsum", 22);
		inventory2.put("Dolor", 33);
		inventory2.put("Sit", 44);
		inventory2.put("Amet", 55);

		output = exercises.consolidateInventory(inventory1, inventory2);
		assertThat("consolidateInventory({ } {\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55})",
				output.size(), equalTo(5));
		assertThat("consolidateInventory({ } {\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55})",
				output, hasEntry("Lorem", 11));
		assertThat("consolidateInventory({ } {\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55})",
				output, hasEntry("Ipsum", 22));
		assertThat("consolidateInventory({ } {\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55})",
				output, hasEntry("Dolor", 33));
		assertThat("consolidateInventory({ } {\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55})",
				output, hasEntry("Sit", 44));
		assertThat("consolidateInventory({ } {\"Lorem\": 11, \"Ipsum\": 22, \"Dolor\": 33, \"Sit\": 44, \"Amet\": 55})",
				output, hasEntry("Amet", 55));
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of strings, for each string, the count of the number of times that a substring length 2 appears
	 * in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1.
	 *
	 * We don't count the end substring, but the substring may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end substring, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is string from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	@Test
	public void exercise10_last2Revisited() {
		Map<String, Integer> output = exercises.last2Revisited(new String[] { "hixxhi", "xaxxaxaxx", "axxxaaxx" });
		assertThat("last2Revisited([\"hixxhi\", \"xaxxaxaxx\", \"axxxaaxx\"])", output.size(), equalTo(3));
		assertThat("last2Revisited([\"hixxhi\", \"xaxxaxaxx\", \"axxxaaxx\"])", output, hasEntry("hixxhi", 1));
		assertThat("last2Revisited([\"hixxhi\", \"xaxxaxaxx\", \"axxxaaxx\"])", output, hasEntry("xaxxaxaxx", 1));
		assertThat("last2Revisited([\"hixxhi\", \"xaxxaxaxx\", \"axxxaaxx\"])", output, hasEntry("axxxaaxx", 2));

		output = exercises.last2Revisited(new String[] { "banana", "kiwi", "Hahahahaha" });
		assertThat("last2Revisited([\"hixxhi\", \"xaxxaxaxx\", \"axxxaaxx\"])", output.size(), equalTo(3));
		assertThat("last2Revisited([\"banana\", \"kiwi\", \"Hahahahaha\"])", output, hasEntry("banana", 1));
		assertThat("last2Revisited([\"banana\", \"kiwi\", \"Hahahahaha\"])", output, hasEntry("kiwi", 0));
		assertThat("last2Revisited([\"banana\", \"kiwi\", \"Hahahahaha\"])", output, hasEntry("Hahahahaha", 3));

		output = exercises.last2Revisited(new String[] {});
		assertThat("last2Revisited([ ])", output.size(), equalTo(0));

	}

}
