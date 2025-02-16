package com.week4.day5.regex;
import java.util.Scanner;
public class ValidateHexColor {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // user input
            System.out.print("Enter a hex color code: ");
            String hexColor = scanner.nextLine();

            // pattern Starts with #,and six hex characters
            if (hexColor.matches("#[0-9A-Fa-f]{6}")) {
                System.out.println("Valid hex color.");
            } else {
                System.out.println("Invalid hex color. Format '#RRGGBB'.");
            }
        }
    }


