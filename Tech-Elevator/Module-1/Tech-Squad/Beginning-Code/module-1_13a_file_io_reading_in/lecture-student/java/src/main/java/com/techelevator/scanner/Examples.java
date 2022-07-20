package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Examples {

    public static void main(String[] args) throws FileNotFoundException {

        //read previously created RTN file from '13_FileIO_Writing_out'

        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter path to input file >>> ");   //e.g.   C:\Temp\RTNfile.txt
        String path = userInput.nextLine();

        File inputFile = new File(path);
        if(inputFile.exists() == false) { // checks for the existence of a file
            System.out.println(path + " does not exist");
            System.exit(1); // Ends the program
        } else if(inputFile.isFile() == false) {
            System.out.println(path + " is not a file");
            System.exit(1); // Ends the program
        }

        try (Scanner fileScanner = new Scanner(inputFile)) {

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

        }

    }

}
