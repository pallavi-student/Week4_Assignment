package com.week4.day4exceptionhandeling;

import java.io.*;

public class CheckedException {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/week4/day4exception/src.txt";
        readFile(fileName);
    }

    public static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print file content
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found"); // Handle missing file
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage()); // Handle IO errors
        }
    }
}

