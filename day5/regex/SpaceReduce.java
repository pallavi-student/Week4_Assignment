package com.week4.day5.regex;
import java.util.Scanner;
public class SpaceReduce {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            //user input
            System.out.print("Enter a sentence with multiple spaces: ");
            String text = scanner.nextLine();

            // Replacing multiple spaces with a single space
            String modifiedText = text.replaceAll("\\s+", " ");
            System.out.println("Modified text: " + modifiedText);
        }
    }


