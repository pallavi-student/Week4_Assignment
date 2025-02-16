package com.week4.day5.regex;
import java.util.*;
import java.util.regex.*;
public class FindRepeatingWords {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            //user input
            System.out.print("Enter a sentence ");
            String text = scanner.nextLine();

            //regex pattern
            String wordPattern = "\\b\\w+\\b";
            Pattern pattern = Pattern.compile(wordPattern);

            Matcher matcher = pattern.matcher(text);
            Set<String> seenWords = new HashSet<>();
            Set<String> repeatedWords = new LinkedHashSet<>();
            while (matcher.find()) {
                String word = matcher.group().toLowerCase();
                if (!seenWords.add(word)) {
                    repeatedWords.add(word);
                }
            }
            System.out.println("Repeated words: " + String.join(", ", repeatedWords));
        }
    }



