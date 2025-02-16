package com.week4.day5.regex;
import java.util.Scanner;

public class BadWord {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();

            // List of bad words
            String[] badWords = {"damn", "stupid"};

            // Replace each bad word with ****
            for (String badWord : badWords) {
                sentence = sentence.replaceAll("(?i)\\b" +badWord+"\\b", "****");
            }

            System.out.println("Censored text " + sentence);

        }
    }


