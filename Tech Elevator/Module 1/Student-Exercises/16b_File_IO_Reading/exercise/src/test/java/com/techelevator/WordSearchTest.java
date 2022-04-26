package com.techelevator;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class WordSearchTest {

    private static final String TEST_TEXT_FILE = "src/test/resources/dr_jekyll_mr_hyde.txt";

    private static final String OUT_FILE_PATH = "src/test/resources/out.txt";

    @AfterClass
    public static void afterClass() throws Exception {
        File outFile = new File(OUT_FILE_PATH);
        if(outFile.exists()) {
            outFile.delete();
        }
    }

    @Test
    public void caseInsensitiveSearch_LineNumbers() throws IOException {
        String searchTerm = "nearly";
        // we don't ask for this in the first part of this exercise but we still need to capture this
        String caseSensitive = "N";
        String userInput = concatWithNewLineFeed(TEST_TEXT_FILE,searchTerm,caseSensitive);
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // set out to a txt file so we can write the results of the application
        File outFile = new File(OUT_FILE_PATH);
        PrintStream printStream = new PrintStream(outFile);
        System.setOut(printStream);
        WordSearch.main(null);

        List<String> lines = Files.readAllLines(outFile.toPath());
        List<Integer> actual = new ArrayList<>();
        // we know that we can at least skip the first 2 lines
        for(int i = 2; i < lines.size(); ++i) {
            String line = lines.get(i);
            Pattern p = Pattern.compile("\\d+"); // look for a number in the line of text
            Matcher m = p.matcher(line);
            while(m.find()) {
                String lineNumber = m.group();
                if(line.startsWith(lineNumber)) {
                    actual.add(Integer.parseInt(lineNumber));
                }
            }
        }

        printStream.close();

        List<Integer> expected = List.of(683, 794, 1337, 1826, 2107, 2611, 2659);

        assertArrayEquals(expected.toArray(),actual.toArray());
    }


    @Test
    public void caseInsensitiveSearch_LineText() throws IOException {
        String searchTerm = "nearly";
        String caseSensitive = "N";
        String userInput = concatWithNewLineFeed(TEST_TEXT_FILE,searchTerm,caseSensitive);
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // set out to a txt file so we can write the results of the application
        File outFile = new File(OUT_FILE_PATH);
        PrintStream printStream = new PrintStream(outFile);
        System.setOut(printStream);
        WordSearch.main(null);

        List<String> lines = Files.readAllLines(outFile.toPath());
        String actual = "";
        for(int i = 2; i < lines.size(); ++i) {
            String line = lines.get(i);
            // if the line contains something
            if (!line.isEmpty()) {
                // the student could choose to represent the line number with a special character
                // and either a space or no space. This will strip that off the start of the line for an equal comparison
                if (lineStartsWithNumbers(line)) { // if line starts with a number add it to the actual
                    String[] parts = line.split("^\\d+[).:]?\\s*");
                    actual += parts[1];
                    if( i != lines.size() - 1) {
                        actual += "\n";
                    }
                }
                else {
                    if (i != lines.size() - 1) {
                        actual += line + "\n";
                    }
                    else {
                        actual += line;
                    }
                }
            }
        }

        printStream.close();

        String expected = "Nearly a year later, in the month of October, 18—, London was startled\n" +
                "he was often absent; for instance, it was nearly two months since she\n" +
                "that nearly threw him from his balance; but he recollected his courage\n" +
                "years, but I observed that the entries ceased nearly a year ago and\n" +
                "morning—the morning, black as it was, was nearly ripe for the\n" +
                "rules is very easy.  You may use this eBook for nearly any purpose\n" +
                "Gutenberg-tm electronic works.  Nearly all the individual works in the";

        //trim console output if line sensitive prompt has been added
        if (actual.substring(actual.indexOf("\n") + 1).equals(expected)) {
            actual = actual.substring(actual.indexOf("\n") + 1);
        }

        assertEquals(expected,actual);
    }

    @Test
    public void caseSensitiveSearch_LineNumbers() throws IOException {
        String searchTerm = "nearly";
        // we don't ask for this in the first part of this exercise but we still need to capture this
        String caseSensitive = "Y";
        String userInput = concatWithNewLineFeed(TEST_TEXT_FILE,searchTerm,caseSensitive);
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // set out to a txt file so we can write the results of the application
        File outFile = new File(OUT_FILE_PATH);
        PrintStream printStream = new PrintStream(outFile);
        System.setOut(printStream);
        WordSearch.main(null);

        List<String> lines = Files.readAllLines(outFile.toPath());
        List<Integer> actual = new ArrayList<>();
        for(int i = 3; i < lines.size(); ++i) {
            String line = lines.get(i);
            Pattern p = Pattern.compile("\\d+"); // look for a number in the line of text
            Matcher m = p.matcher(line);
            while(m.find()) {
                String lineNumber = m.group();
                if(line.startsWith(lineNumber)) {
                    actual.add(Integer.parseInt(lineNumber));
                }
            }
        }

        printStream.close();

        List<Integer> expected = List.of(794, 1337, 1826, 2107, 2611);

        assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void caseSensitiveSearch_LineText() throws IOException {
        String searchTerm = "nearly";
        String caseSensitive = "Y";
        String userInput = concatWithNewLineFeed(TEST_TEXT_FILE,searchTerm,caseSensitive);
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // set out to a txt file so we can write the results of the application
        File outFile = new File(OUT_FILE_PATH);
        PrintStream printStream = new PrintStream(outFile);
        System.setOut(printStream);
        WordSearch.main(null);

        List<String> lines = Files.readAllLines(outFile.toPath());
        String actual = "";
        for(int i = 3; i < lines.size(); ++i) {
            String line = lines.get(i);
            // if the line contains something
            if (!line.isEmpty()) {
                if (lineStartsWithNumbers(line)) { // and starts with a number add it to the actual
                    String[] parts = line.split("^\\d+[).:]?\\s*");
                    actual += parts[1];
                    if (i != lines.size() - 1) {
                        actual += "\n";
                    }
                }
                else {
                    if (i != lines.size() - 1) {
                        actual += line + "\n";
                    }
                    else {
                        actual += line;
                    }
                }
            }
        }

        printStream.close();

        String expected = "he was often absent; for instance, it was nearly two months since she\n" +
                "that nearly threw him from his balance; but he recollected his courage\n" +
                "years, but I observed that the entries ceased nearly a year ago and\n" +
                "morning—the morning, black as it was, was nearly ripe for the\n" +
                "rules is very easy.  You may use this eBook for nearly any purpose";

        assertEquals(expected,actual);
    }

    /*
     * Adds a new line feed after each input
     */
    private String concatWithNewLineFeed(String ...inputs) {
        String userInput = "";
        for(String s : inputs) {
            userInput += s + System.lineSeparator();
        }
        return userInput;
    }

    private boolean lineStartsWithNumbers(String line) {
        Pattern p = Pattern.compile("^\\d+");
        Matcher m = p.matcher(line);
        return m.find();
    }
}
