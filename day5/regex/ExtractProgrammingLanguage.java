package com.week4.day5.regex;
import java.util.regex.*;
import java.util.Scanner;

public class ExtractProgrammingLanguage {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a sentence: ");
            String text = scanner.nextLine();
            String[] languages = {"Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby"};
            String patternString = "\\b(" + String.join("|", languages) + ")\\b";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(text);
            System.out.println("Extracted programming languages:");
            while (matcher.find()) {
                System.out.print(matcher.group() + ", ");
            }
        }
    }


