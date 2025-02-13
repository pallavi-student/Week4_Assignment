package com.week4.day3streamproblems;
import java.io.*;
import java.io.*;

public class ConvertUppercaseToLowercase{
    public static void main(String[] args) {
        String inputFile = "src/main/java/com/week4/day_3/Source.txt";
        String outputFile = "src/main/java/com/week4/day_3/destination.txt";
        convertFileToLowercase(inputFile, outputFile);
    }

    public static void convertFileToLowercase(String inputFile, String outputFile) {
        try (
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(outputFile);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert the line to lowercase and write to the output file
                bw.write(line.toLowerCase());
                bw.newLine(); // Ensure proper line breaks
            }
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }}}