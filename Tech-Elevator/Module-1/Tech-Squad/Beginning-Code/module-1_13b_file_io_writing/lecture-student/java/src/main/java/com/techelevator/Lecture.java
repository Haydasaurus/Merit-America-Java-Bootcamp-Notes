package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.print("Enter the path of a file or directory >>> ");
		String path = userInput.nextLine();
		File f = new File(path);

		/*
		 * The File class allows us to inspect various attributes of a file system object
		 */

		/* ***************************
		 * INSPECTING THE FILESYSTEM
		 * ***************************/

		//check if file exist - using f.exists
		//if exists, check it is a file or directory (f.isDirectory, f.isFile)
		//print name and path (f.getName, f.getAbsolutePath)


		/*
		 * The File class also allows us to manipulate file system objects
		 * */

		/* ************************
		 * CREATING A DIRECTORY
		 * ************************/

		System.out.println();
		System.out.println("Let's create a new directory.");
		System.out.print("Enter the path of the new directory >>> ");
		path = userInput.nextLine();
		File newDirectory = new File(path);

		//check if newDirectory exists
		//if not, create new (newDirectory.mkdir)



		/* ************************
		 * CREATING A FILE
		 * ************************/

		System.out.println();
		System.out.println("Now let's put a file in the directory.");
		System.out.print("Enter a name for the new file >>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName);

		//create new file (newFile.createNewFile)
		//print file name, absolute path and size (newFile.length)



		/* ************************
		 * WRITING TO A FILE
		 * ************************/

		System.out.println();
		System.out.println("Now let's write something in the new file.");
		System.out.print("Enter a message to be stored in the new file >>> ");
		String message = userInput.nextLine();

		//write message to file
		//print file name, absolute path and size

	}

}
