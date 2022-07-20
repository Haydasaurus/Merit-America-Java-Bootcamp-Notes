package com.techelevator;

import java.util.HashMap;

public class WordCounter {

    public static void main(String[] args) {

        String text = "This is a really long text, I can copy it from the internet";

        // erase all the commas and dots from text, by calling methods
        text = text.replace(",", "").replace(".", "");

        // split the text into individual words (so you can loop through them)
        String[] seperatedWords = text.split(" ");

        map<String, Integer> wordCounts = new HashMap<>();

        // use a Map to keep track of the word count
        for (String word.seperatedWords){
            if (!wordCounts.containsKey (word)) {
                wordCounts.put(word, 1);
            }
            else {
                int count = wordCounts.get(word);
                wordCounts.put(word, count + 1);
            }
        }

//            ------------------OR------------------

//            Integer count = wordCounts.get(word);
//            if (count == null) {
//                wordCounts.put(word, 1);
//            }
//            else {
//                wordCounts.put(word, count + 1);
//            }
//        }

//            ------------------OR------------------

//            wordCounts.put(word, count == null ? 1 : count + 1);
//        }

//            ------------------OR-------------------

//            wordCounts.compute(word, (String key, Integer count) -> count == null ? 1 : count + 1);
//        }

        // print the result in this format "word " + word + "shows up " + count + " times"

//        for (Map.Entry<String, Integer> wordCount : wordCounts.entrySet());

//        ------------------OR-------------------

        for (var wordCount : wordCounts.entrySet()) {}
            System.out.println("Word" + wordCount.getKey() + " shows up " + wordCount.getValue());
    }
}