package com.week4.day3streamproblems;

import java.io.*;
import java.nio.file.*;

public class LargeFilesWordDetector {
    //Define the file path
    private static final String FILE_PATH = "src/main/java/com/week4/day3streamproblems/Sample2.txt";
    private static final long FILE_SIZE_MB = 500; // Target file size in MB

    // Create the Large File 500MB
    public static void createLargeFile() {
        File file = new File(FILE_PATH);

        // Ensure the parent directory exists
        file.getParentFile().mkdirs();

        String sampleText = "This is me this side." +
                "\nWhat are you doing.\nError Something goes on\n";
        long fileSize = 0;

        System.out.println("⏳ Creating a large file...");

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            while (fileSize < FILE_SIZE_MB * 1024 * 1024) {
                writer.write(sampleText);
                fileSize += sampleText.getBytes().length;
            }
            System.out.println(" Large file created  " + FILE_PATH + " (Size: " + FILE_SIZE_MB + "MB+)");
        } catch (IOException e) {
            System.err.println(" Error creating large: " + e.getMessage());
        }
    }


    public static void readLargeFile() {
        System.out.println("Reading file and filtering 'error' lines...\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createLargeFile();
        readLargeFile();
    }
}
