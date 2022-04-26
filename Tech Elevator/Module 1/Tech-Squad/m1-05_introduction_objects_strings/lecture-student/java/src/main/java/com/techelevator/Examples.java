package com.techelevator;

public class Examples {

    public static void main(String[] args) {

        String myName = "joe";
        int lengthOfTheString = myName.length();
        System.out.println(lengthOfTheString);

        //Substring
        String fullName = "Java Jones";
        String firstName = fullName.substring(0, 4); // <- Will equal "Java"
        String lastName = fullName.substring(5); // <- Will equal "Jones"

        System.out.println(firstName);
        System.out.println(lastName);

        //Contains
        boolean hasJavaInIt = fullName.contains("Java"); // Will equal true
        System.out.println("hasJavaInIt: " + hasJavaInIt);

        //Starting and ending
        boolean startsWithJava = fullName.startsWith("Java"); // Will equal true
        System.out.println("startsWithJava: " + startsWithJava);

        //Index of
        //             0123456789
        String name = "Java Jones";
        int firstJFound = name.indexOf("J"); // Will return 0
        System.out.println("firstJFound: " + firstJFound);

        int firstLetterOfJones = name.indexOf("Jones"); // Will return 5
        System.out.println("firstLetterOfJones: " + firstLetterOfJones);

        int firstSmithFound = name.indexOf("Smith"); // Will return -1
        System.out.println("firstSmithFound: " + firstSmithFound);

        //Replace
        String nameWithReplacements = name.replace("Java", "Justin");
        System.out.println("nameWithReplacements: " + nameWithReplacements);
        // nameWithReplacements will equal "Justin Jones"
        // name will still equal "Java Jones"

        //Comparing two strings
        name = "Joe";
        String otherName = "joe";
        boolean exactlyTheSame = name.equals(otherName); // Will be false
        System.out.println("exactlyTheSame: " + exactlyTheSame);

        boolean closeToTheSame = name.equalsIgnoreCase(otherName); // Will be true
        System.out.println("closeToTheSame: " + closeToTheSame);

        //Splitting and joining strings
        String fullString = "Joe;Mark;Josh;Craig";
        String[] separateNames = fullString.split(";");
        // separateNames will contain ["Joe", "Mark", "Josh", "Craig"]
        String togetherNames = String.join(",", separateNames);
        // togetherNames will equal "Joe,Mark,Josh,Craig"
        System.out.println("togetherNames: " + togetherNames);


        //Converting to lower and upper case
        name = "jOe";
        String lowered = name.toLowerCase(); // Will be "joe"
        System.out.println("lowered: " + lowered);

        String uppered = name.toUpperCase(); // Will be "JOE"
        System.out.println("uppered: " + uppered);

    }
}
