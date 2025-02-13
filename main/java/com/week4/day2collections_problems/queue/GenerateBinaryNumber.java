package com.week4.day2collections_problems.queue;
import java.util.LinkedList;
import java.util.Queue;
public class GenerateBinaryNumber {
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1"); // Start with "1"

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            System.out.print(current + " "); // Print current binary number

            queue.add(current + "0"); // Append "0" to generate next binary
            queue.add(current + "1"); // Append "1" to generate next binary
        }
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First " + N + " Binary Numbers:");
        generateBinaryNumbers(N);
    }
}


