package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Declaring and initializing a Map
		// For example, to hold person name and zip - David, 44120
		/*
		Map<String, String> nameToZip = new ________;
		*/

		// Adding an item to a Map
		/*
		nameToZip.___("David", "44120");
		nameToZip.___("Dan", "44124");
		nameToZip.___("Elizabeth", "44012");
		*/

		// Retrieving an item from a Map
		/*
		System.out.println("David lives in " + nameToZip.___("David"));
		System.out.println("Dan lives in " + nameToZip.___("Dan"));
		System.out.println("Elizabeth lives in " + nameToZip.___("Elizabeth"));
		System.out.println();
		*/

		// Retrieving just the keys from a Map
		System.out.println("We can also retrieve a list of keys and iterate over them using a for loop:");

		// The return type of `Map<String, String>.keySet()` is a `Set<String>`. Keys are required to be unique
		// and sets guarantee uniqueness.
		/*
		Set<String> keys = nameToZip.___(); // returns a Collection of all of the keys in the Map
		for (String ___ : ___) {
			System.out.println(___ + " lives in " + nameToZip.___(___));
		}
		System.out.println();
		*/

		// Check to see if a key already exists
		/*
		if (nameToZip.___("David")) {
			System.out.println("David exists");
		}
		System.out.println();

		System.out.println("set 12345 for key David");
		nameToZip.___("David", "12345"); // If key already exists, value is updated, otherwise key-value added
		*/

		// Iterate through the key-value pairs in the Map
		/*
		for (Map.Entry<String, String> nameZip : nameToZip.___()) {
			System.out.println(nameZip.___() + " lives in " + nameZip.___());
		}
		System.out.println();
		*/

		// Remove an element from the Map
		/*
		nameToZip.___("David");
		System.out.println("removed David");
		System.out.println();
		*/

		// loop through again to show David was removed
		/*
		for (Map.Entry<String, String> nameZip : nameToZip.entrySet()) {
			System.out.println(nameZip.getKey() + " lives in " + nameZip.getValue());
		}
		System.out.println();
		*/

		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		// Declaring and initializing a Set
		// For example, to hold person name - David
		/*
		Set<String> names = new ___<String>();
		*/

		// Adding an item to a Set
		/*
		names.___("David");
		names.___("Luke");
		names.___("Rey");
		names.___("Ben");
		*/

		// Remove an element from the Set
		/*
		names.___("Ben") ;
		System.out.println("removed Ben");
		System.out.println();
		*/

		// Iterate through the Set
		/*
		for (String ___ : ___) {
			System.out.println("My name is " + ___);
		}
		System.out.println();
		*/
	}

}
