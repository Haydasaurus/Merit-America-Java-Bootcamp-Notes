package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args)  {

		WordSearch app = new WordSearch();

		Scanner myScanner = new Scanner(System.in);
		System.out.println("What is the fully qualified name of the file that should be searched?");
		String nameOfFile = myScanner.nextLine();
		System.out.println("What is the search word you are looking for?");
		String nameOfWord = myScanner.nextLine();
		System.out.println("Should the search be case sensitive> (Y/N)");
		String answerOfCaseSensitive = myScanner.nextLine();

		try {
			app.fileReading(nameOfFile, nameOfWord,answerOfCaseSensitive);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void fileReading(String nameOfFile, String nameOfWord, String answerOfCaseSensitive) throws FileNotFoundException {
		File file = new File(nameOfFile);
		Scanner myFile = new Scanner(file);
		int numOfLine = 0;
		while (myFile.hasNextLine()) {
			String lineOfText = myFile.nextLine();
			numOfLine += 1;

			String upperCase = answerOfCaseSensitive.toUpperCase();
			if(upperCase.equals("Y")) {
				if(lineOfText.contains(nameOfWord)) {
					System.out.println(numOfLine + ") " + lineOfText);
				}
			} else {
				if(lineOfText.toUpperCase().contains(nameOfWord.toUpperCase())) {
					System.out.println(numOfLine + ") " + lineOfText);
				}
			}
		}
	}

}