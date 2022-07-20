package com.techelevtor;

import java.util.Scanner;

public class Program {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        // Steps 7: Create MasterCard class and replace CreditCard instance
        // Steps 8: Create Visa class and replace CreditCard instance
        CreditCard cc = new CreditCard();

        // Credit card validation loop
        while (true) {
            // Prompt user for credit card information
            System.out.print("Last name: ");
            cc.setLastName(keyboard.nextLine());
            System.out.print("First name: ");
            cc.setFirstName(keyboard.nextLine());
            System.out.print("Number: ");
            cc.setNumber(keyboard.nextLine());
            System.out.print("Security code: ");
            cc.setSecurityCode(keyboard.nextLine());

            // Validate the credit card
            try {
                cc.validate();
                break; // No exception thrown, credit card is valid, break out of validation loop
            }
            catch (Exception ex) { // Step 3: Throw and catch CreditCardValidationException
                System.out.println("Card is invalid: " + ex.getMessage() + "\n");
            }
        }

        // Display valid CreditCard
        System.out.println("\nCard is valid - " + cc.toString());
    }
}
