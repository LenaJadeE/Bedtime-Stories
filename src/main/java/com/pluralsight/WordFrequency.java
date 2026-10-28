package com.pluralsight;

import java.util.*;

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

    private static void printTopWords(HashMap<String, Integer> counts) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());

        entries.sort(Comparator.comparingInt((Map.Entry<String, Integer> a) -> a.getValue()).thenComparing(Map.Entry::getKey));

        System.out.println();
        System.out.println("The " + TopCount + " most common words: ");
        for (int i = 0; i < Math.min(TopCount, entries.size()); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.printf("%d. %s (%d times)%n", i + 1, entry.getKey(), entry.getValue());
        }
    }
}
