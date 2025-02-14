package com.week4.day4exceptionhandeling;

import java.util.Scanner;

// Custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Take user input
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            // Validate age
            validateAge(age);

            // If age is valid
            System.out.println("Access granted!");

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage()); // Display custom exception message
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid age.");
        } finally {
            sc.close(); // Close scanner
        }
    }

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
}

