package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.util.Date;
import java.util.Scanner;

public class BookConverter {
    public static void main(String[] args) {
        /*
         * This book-converter program opens a file that was downloaded from https://www.gutenberg.org/,
         * and converts all its text to uppercase.
         *
         * The program also writes a history log of all the files that it has converted.
         */
        /*
        Prompt the user for a filename
         */
        // Create a scanner for user input
        Scanner userInput = new Scanner(System.in);
        // Prompt the user for a file path - path should look like "data/jekyll-and-hyde.txt"
        System.out.print("Enter path to the book file: ");
        String filePath = userInput.nextLine();

        // Create a File object using the path
        File bookFile = new File(filePath);

        /*
        Open the file and start a read loop
         */
        // Setup variables used in the loop
        // Count of lines between the start and end markers.
        int lineCount = 0;

        // Open the book file for reading
        /*
        Step 2: Open a file for writing, and write the converted text into it
         */
        // Create a File object for the output file
        File convertedFile = getConvertedFile(bookFile);
        // Open both the input and output files.
        try (Scanner fileInput = new Scanner(bookFile); PrintWriter writer = new PrintWriter(convertedFile)) {
            // Loop until the end of file is reached
            while (fileInput.hasNextLine()) {
                // Read the next line into 'lineOfText'
                String lineOfText = fileInput.nextLine();
                lineCount++;

                // Write the text in uppercase to the output file.
                writer.println(lineOfText.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            // Could not find the file at the specified path.
            System.out.println("The file was not found: " + bookFile.getAbsolutePath());
            return;
        }

        // Tell the user what happened.
        String message = "Converted " + lineCount +
                " lines of file " + bookFile.getName() +
                " to " + convertedFile.getName() +
                " on " + new Date();
        System.out.println(message);

        /*
        Step 3:
        Open a "log" file for append, to record all of the actions taken by this program
        throughout history. If the file doesn't exist it will be created. If it already exists, its
        contents will be preserved, and the lines written here will be appended to what was already there.
         */
        String auditPath = "BookConverter.log";
        File logFile = new File(auditPath);
        // Using a FileOutputStream with true passed into the constructor opens the file for append.
        try (PrintWriter log = new PrintWriter(new FileOutputStream(logFile, true))) {
            log.println(message);
        } catch (FileNotFoundException e) {
            System.out.println("*** Unable to open log file: " + logFile.getAbsolutePath());
        }
    }

    /**
     * This method gets the filename from the file sent in the argument, and creates another
     * file object based on that file's name, with ".screaming" inserted before the file extension.
     * So, an input file with name "myFile.txt" will return a file named "myFile.screaming.txt".
     * If the is no extension on the input file ("myFile"), then ".screaming" will just be appended ("myFile.screaming").
     * @param bookFile The input file on which to calculate a new filename.
     * @return A File object whose name includes ".screaming" before the extension.
     */
    static private File getConvertedFile(File bookFile) {
        // Get the name of the book file
        String bookPath = bookFile.getAbsolutePath();

        // Insert ".screaming" into the book file path to arrive at a name for the converted file.
        int dotIndex = bookPath.lastIndexOf('.');
        String convertedPath;
        if (dotIndex >= 0) {
            // found an extension, like .txt
            convertedPath = bookPath.substring(0, dotIndex) + ".screaming." + bookPath.substring(dotIndex + 1);
        } else {
            // There is no file extension
            convertedPath = bookPath + ".screaming";
        }
        return new File(convertedPath);
    }
}
