package com.week4.day5.regex;
import java.util.regex.*;
import java.util.Scanner;
public class ExtractURL {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            //user input
            System.out.print("Enter text containing URLs: ");
            String text = scanner.nextLine();

            //regex pattern
            String urlPattern = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}\\S*\\b";

            // Create a pattern and matcher
            Pattern pattern = Pattern.compile(urlPattern);
            Matcher matcher = pattern.matcher(text);
            System.out.println("Extracted URLs:");
            while (matcher.find()) {
                System.out.print(matcher.group() + ", ");
            }


        }
    }


