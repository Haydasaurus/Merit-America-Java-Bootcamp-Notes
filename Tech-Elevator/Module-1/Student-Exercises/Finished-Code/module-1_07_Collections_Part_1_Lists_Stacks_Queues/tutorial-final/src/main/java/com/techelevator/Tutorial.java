package com.techelevator;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Tutorial {
	
    public static void main(String[] args) {

        // Step One: Declare a List
        List<String> nameList = new ArrayList<String>();


        // Step Two: Add values to a List
        nameList.add("Ada");
        nameList.add("Grace");
        nameList.add("Margaret");
        nameList.add("Adele");


        // Step Three: Looping through a List in a for loop
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println("The name at index " + i + " is " + nameList.get(i));
        }


        // Step Four: Remove an item
        nameList.remove("Ada");  // or nameList.remove(0);


        // Step Five: Looping through List in a for-each loop
        for (String name : nameList) {
            System.out.println("Name: " + name);
        }
    }

}
