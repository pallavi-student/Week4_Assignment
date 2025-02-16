package com.week4.day5.regex;
import java.util.regex.*;
import java.util.Scanner;
public class ExtractCapitalizedWord {


    public class CapitalizedWordExtractor {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();
            String capitalizedPattern = "\\b[A-Z][a-z]*\\b";

            // Create a pattern and matcher
            Pattern pattern = Pattern.compile(capitalizedPattern);
            Matcher matcher = pattern.matcher(sentence);
            System.out.println("Capitalized words ");
            while (matcher.find()) {
                System.out.print(matcher.group() + ", ");
            }


        }
    }

}
