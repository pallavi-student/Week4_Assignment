package com.week4.day4exceptionhandeling;

import java.util.Scanner;

public class MultipleCatchBlockProblem  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Accept array size from user
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();

            // Accept array elements
            Integer[] numbers = new Integer[size];
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                numbers[i] = sc.nextInt();
            }
            // Accept index from user
            System.out.print("Enter index to retrieve value: ");
            int index = sc.nextInt();
            int value = getValueAtIndex(numbers, index);
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close(); // Close scanner
        }
    }

    public static int getValueAtIndex(Integer[] array, int index) {
        return array[index];
    }
}

