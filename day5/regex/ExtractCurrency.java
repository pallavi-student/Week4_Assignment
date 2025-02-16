package com.week4.day5.regex;
import java.util.regex.*;
import java.util.Scanner;

public class ExtractCurrency {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a sentence with currency values ");
            String text = scanner.nextLine();
            String currencyPattern = "\\$?\\d+\\.\\d{2}";
            Pattern pattern = Pattern.compile(currencyPattern);
            Matcher matcher = pattern.matcher(text);

            // Find and print all currency values
            System.out.println("Extracted currency values:");
            while (matcher.find()) {
                System.out.print(matcher.group() + ", ");
            }
        }
    }


