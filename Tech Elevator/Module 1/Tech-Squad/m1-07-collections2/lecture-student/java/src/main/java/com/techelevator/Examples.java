package com.techelevator;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Examples {

    public static void main(String[] args) {

        //create a Map of String names and Boolean Jedi status
        Map<String, Boolean> people = new HashMap<String, Boolean>();

        //To add an item to a Map, you call the put() method
        people.put("Luke", true);
        people.put("Han", false);
        people.put("Chewbacca", false);
        people.put("Yoda", true);
        people.put("Leia", true);

        //The remove() method removes a key-value pair from a Map
        people.remove("Chewbacca"); // Luke, Han, Yoda, and Leia remain

        //If you want to know if the key-value pair was removed,
        //the remove() method returns the value that was associated with the key, and null if the key wasn't found
        Boolean lukeValue = people.remove("Luke");
        Boolean landoValue = people.remove("Lando"); //Lando doesn't exist in map

        System.out.println("The value for Luke was: " + lukeValue); //outputs "The value for Luke was: true"
        System.out.println("The value for Lando was: " + landoValue); //outputs "The value for Lando was: null"
        System.out.println();

        //To access a value from a Map, you use the get() method
        //This code retrieves a value from the Map using a given key. If you provide a key that doesn't exist, null is returned
        Boolean isYodaJedi = people.get("Yoda");
        Boolean isHanJedi = people.get("Han");

        System.out.println("Is Yoda Jedi: " + isYodaJedi); //outputs "Is Yoda Jedi: true"
        System.out.println("Is Han Jedi: " + isHanJedi); //outputs "Is Han Jedi: false"
        System.out.println();

        //You can use the containsKey() method to determine whether the Map contains the specified key
        if (!people.containsKey("Luke")) { // Luke doesn't exist in map
            people.put("Luke", true);      // add Luke to map
        }

        //Iterating through the collection
        //To display the names and Jedi status, you iterate over people.entrySet() in a foreach loop.
        //After each iteration, the loop assigns the latest entry set retrieved
        //from the collection into the Map.Entry<String, Boolean> person variable
        for (Map.Entry<String, Boolean> person : people.entrySet()) {
            // person.getValue() will return a boolean
            if (person.getValue()) {
                System.out.println(person.getKey() + " is a Jedi.");
            } else {
                System.out.println(person.getKey() + " is not a Jedi.");
            }
        }
        System.out.println();

        //create a Set that holds Strings
        Set<String> characters = new HashSet<String>();

        //The add() method adds an element to the Set
        characters.add("Luke");    // contains Luke
        characters.add("Rey");     // contains Luke, Rey
        characters.add("Ben");     // contains Luke, Rey, Ben
        characters.add("Luke");    // contains Luke, Rey, Ben

        //The remove() method removes an element from a Set.
        //The method returns a boolean indicating if the element was removed
        characters.remove("Ben");   // set now contains Luke and Rey

        //Iterating through a set
        //Sets don't have indexes to access each item.
        //To see each of the elements in a Set, you'll need to use the foreach loop
        for (String character : characters) {
            System.out.println("My name is: " + character);
        }

    }

}

