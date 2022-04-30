package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindAndReplaceTest {

    private String replacementStr;
    private File srcFile;
    private File destFile;
    private String srcContent;

    @Before
    public void setUp() throws Exception {
        replacementStr = "🥓";

        // get text from source file
        srcFile = new File("src/test/resources/bacon.txt");
        /*
         * Normalize source content to the runtime line separator. Found the source
         * file, bacon.txt, was saved in Git repo with LF separators, but when
         * run on a Windows machine, the destination file, bacon-emoji.txt, contained
         * CRLFs. The test assert on the src and dest contents fails because the line
         * separators differ.
         * Breaking the src file into individual line and adding the line separator
         * of the OS the tests are being run on normalizes the src contents.
         * The reverse situation of the source file having CRLF while running on macOS
         * with line separators of LF has also been tested.
         */
        srcContent = "";
        List<String> lines = Files.readAllLines(srcFile.toPath());
        for (String line: lines) {
            srcContent += line + System.lineSeparator();
        }

        // destination file
        destFile = new File("src/test/resources/bacon-emoji.txt");
    }

    /*
     * The word spinach will not be found in the source file so no replacements should be made in the destination file.
     */
    @Test
    public void shouldReplaceNoWords() throws IOException {
        String searchStr = "spinach";

        // replace all occurrences of search word with replacement
        String expected = srcContent.replaceAll(searchStr, replacementStr);

        // call main()
        invoke(searchStr);

        // read destination file
        String destContent = Files.readString(destFile.toPath());

        // does the expected content of the destination file meet the expected.
        assertEquals(expected.trim(),destContent.trim());
    }

    /*
     * FindAndReplace is case sensitive so this should only replace a single word and not all lower case instances
     */
    @Test
    public void shouldReplaceSingleWord() throws IOException {
        String searchStr = "Bacon";

        // replace all occurrences of search word with replacement
        String expected = srcContent.replaceAll(searchStr, replacementStr);

        // call main()
        invoke(searchStr);

        // read destination file
        String destContent = Files.readString(destFile.toPath());

        // does the expected content of the destination file meet the expected.
        assertEquals(expected.trim(),destContent.trim());
    }

    @Test
    public void shouldReplaceMultipleOccurrences() throws IOException {
        String searchStr = "bacon";

        // replace all occurrences of search word with replacement; this is a
        String expected = srcContent.replaceAll(searchStr, replacementStr);

        // call main()
        invoke(searchStr);

        // read destination file
        String destContent = Files.readString(destFile.toPath());

        // does the expected content of the destination file meet the expected.
        assertEquals(expected.trim(),destContent.trim());
    }

    /**
     * Constructs the user input string, reassigns standard in and invokes the main method.
     *
     * @param searchStr
     */
    private void invoke(String searchStr) {
        String userInput = concatWithNewLineFeed(searchStr,replacementStr,srcFile.getAbsolutePath(),destFile.getAbsolutePath());
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        FindAndReplace.main(null);
    }

    /**
     * Adds a new line separator after each of the inputs passed in
     *
     * @param inputs
     * @return the original string with line separators after each input
     */
    private String concatWithNewLineFeed(String ...inputs) {
        String userInput = "";
        for(String s : inputs) {
            userInput += s + System.lineSeparator();
        }
        return userInput;
    }

}
