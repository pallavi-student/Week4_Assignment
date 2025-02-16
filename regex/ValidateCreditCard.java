package com.week4.day5.regex;
import java.util.Scanner;
public class ValidateCreditCard {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            //user input
            System.out.print("Enter a credit card number: ");
            String cardNumber = scanner.nextLine();

            //regex patterns
            String visaPattern = "^4\\d{15}$";  // Visa starts with 4 has 16 digits
            String masterCardPattern = "^5\\d{15}$";  // MasterCard starts with 5 has 16 digits
            if (cardNumber.matches(visaPattern)) {
                System.out.println("Valid Visa card.");
            } else if (cardNumber.matches(masterCardPattern)) {
                System.out.println("Valid MasterCard.");
            } else {
                System.out.println("Invalid credit card number.");
            }
        }
    }


