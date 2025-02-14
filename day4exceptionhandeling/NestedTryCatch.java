package com.week4.day4exceptionhandeling;
import java.util.Scanner;
public class NestedTryCatch {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int[] arr = {10, 20, 30, 40}; // Sample array

            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();

            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            try {
                // Outer try block for array access
                int value = arr[index];

                try {
                    // Inner try block for division
                    int result = value / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            } finally {
                System.out.println("Operation completed.");
            }


        }
    }


