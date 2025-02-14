package com.week4.day4exceptionhandeling;

import java.util.Scanner;
import java.util.InputMismatchException;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        performDivision(sc);
        sc.close(); // Close scanner after use
    }

    public static void performDivision(Scanner scanner) {
        try {
            // Ask user for input
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Perform division
            int result = divide(numerator, denominator);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values.");
        }
    }

    public static int divide(int numerator, int denominator) {
        return numerator / denominator; // May throw ArithmeticException
    }
}

