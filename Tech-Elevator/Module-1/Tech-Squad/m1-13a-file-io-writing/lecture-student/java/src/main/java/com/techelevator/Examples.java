package com.techelevator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Examples {

    public static void main(String[] args) {

        //Create a file on your computer of RTN numbers, one per line. File must exist.

        Scanner userInput = new Scanner(System.in); //get file path from user (e.g. C:\Temp\RTNfile.txt)
        System.out.print("Please enter path to input file >>> ");
        String path = userInput.nextLine();

        //opening file in a try-with-resources block

        try (PrintWriter dataOutput = new PrintWriter(path)) {
            //RTN numbers
            //https://www.usbank.com/bank-accounts/checking-accounts/checking-customer-resources/aba-routing-number.html
            dataOutput.println("122105155");  //RTN for Arizona
            dataOutput.println("082000549");  //RTN for Arkansas
            dataOutput.println("121122676");  //RTN for California - Northern
            //write more if you want
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot open the file for writing.");
            System.exit(1); // Ends the program
        }

        //now open same file for appending

        try (PrintWriter dataOutputAppending = new PrintWriter(
            new FileOutputStream(path, true))) {
            dataOutputAppending.println("122235821");  //RTN for California - Southern
            dataOutputAppending.println("071904779");  //RTN for Illinois - Northern
            dataOutputAppending.println("021906779"); // wrong RTN number
            //write more :)
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot open the file for writing.");
        }

    }

}
