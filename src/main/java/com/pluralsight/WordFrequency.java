package com.pluralsight;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WordFrequency {
    private static final int TopCount = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> story = BedtimeStories.promptForStory(scanner);
        HashMap<String, Integer> counts = countWords(story);

        printTopWords(counts);
    }

    private static HashMap<String, Integer> countWords(List<String> story) {
        HashMap<String, Integer> counts = new HashMap<>();

        for (String line : story) {
            String cleaned = line.toLowerCase()
                    .replace('’', '\'')
                    .replaceAll("[^a-z' ]", " ");

            for (String word : cleaned.split("\\s+")) {
                word = word.replaceAll("^'+|'+$", "");
                if (!word.isEmpty()) {
                    counts.merge(word, 1, Integer::sum);
                }
            }
        }
        return counts;
    }

    private  static void printTopWords(HashMap<String, Integer> counts) {

    }
}
