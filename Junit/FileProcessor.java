package com.week4.day5.Junit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

    public class FileProcessor {

        public static void writeToFile(String filename, String content) throws IOException {
            Files.writeString(Path.of(filename), content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }

        public static String readFromFile(String filename) throws IOException {
            return Files.readString(Path.of(filename));
        }

        public static void main(String[] args) {
            String filename = "sample.txt";
            String content = "Hello, this is a test file!";

            try {
                // Write content to file
                System.out.println("Writing to file...");
                writeToFile(filename, content);

                // Read content from file
                System.out.println("Reading from file...");
                String fileContent = readFromFile(filename);

                // Display the content
                System.out.println("File Content: " + fileContent);
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }


