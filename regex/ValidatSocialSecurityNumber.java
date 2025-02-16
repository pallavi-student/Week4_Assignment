package com.week4.day5.regex;
import java.util.Scanner;

public class ValidatSocialSecurityNumber {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Ask for user input
            System.out.print("Enter a SSN ");
            String ssn = scanner.nextLine();

            //regex pattern
            String ssnPattern = "^\\d{3}-\\d{2}-\\d{4}$";

            // Validate SSN
            if (ssn.matches(ssnPattern)) {
                System.out.println( ssn + " is valid.");
            } else {
                System.out.println( ssn + " is invalid.");
            }


        }
    }


