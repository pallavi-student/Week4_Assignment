package com.week4.day4exceptionhandeling;

import java.io.*;

public class TryWithResourceProblem {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/week4/day4/src.txt"; // File name

        try {
            String firstLine = readFirstLine(filePath);
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public static String readFirstLine(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine(); // Reads the first line of the file
        }
    }
}

