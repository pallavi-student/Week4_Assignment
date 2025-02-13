package com.week4.day2collections_problems.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class WordCounter {
    public static <T extends String> Map<T, Integer> countWords(String filePath) {
        Map<T, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        T key = (T) word;
                        wordCount.put(key, wordCount.getOrDefault(key, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String filePath = "sample.txt"; // Provide text file path
        out.println("Word Frequency: " + countWords(filePath));
    }
}
