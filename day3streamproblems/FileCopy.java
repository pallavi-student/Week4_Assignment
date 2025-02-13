package com.week4.day3streamproblems;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/com/week4/day3streamproblems/Sample.txt";
        String destinationFile = "src/main/java/com/week4/day3streamproblems/destination.txt";

        // Create and write sample data to source file
        createSampleFile(sourceFile);

        copyFile(sourceFile, destinationFile);
    }

    private static void createSampleFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            String content = "This is a sample text file.\nIt contains multiple lines of text.";
            fos.write(content.getBytes());
            System.out.println("Sample file created");
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }

    private static void copyFile(String sourceFile, String destinationFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
            System.out.println("File copied successfully from sourceFile  to  destinationFile");
        } catch (FileNotFoundException e) {
            System.err.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
