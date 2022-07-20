package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        FindAndReplace app = new FindAndReplace();
        Scanner myScanner = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = myScanner.nextLine();
        System.out.println("What is the replacement word?");
        String replaceWord = myScanner.nextLine();
        System.out.println("What is the source file?");
        String sourceFileName = myScanner.nextLine();
        System.out.println("What is the destination file?");
        String destinationFileName = myScanner.nextLine();

        try {
            app.fileReadAndReplace(searchWord,replaceWord,sourceFileName,destinationFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileReadAndReplace(String searchWord, String replaceWord, String sourceFileName, String destinationFileName) throws IOException {
        File file = new File(sourceFileName);
        Scanner sourceFile = new Scanner(file);
        List<String> fileList = new ArrayList<>();
        while(sourceFile.hasNextLine()) {
            String lineOfText = sourceFile.nextLine();
            if(lineOfText.contains(searchWord)) {
                String newLine = lineOfText.replaceAll(searchWord, replaceWord);
                fileList.add(newLine + "\r\n");
            } else {
                fileList.add(lineOfText + "\r\n");
            }
        }
        String destination = String.join("",fileList);

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(destinationFileName, false)))) {
            out.println(destination);
        }
    }

}