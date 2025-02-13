package com.week4.day3streamproblems;

import java.io.*;

public class ReadUserInputfromConsole {
    public static void main(String[] args) {
        saveUserInputToFile("src/main/java/com/week4/day_3/Source.txt");
    }

    private static void saveUserInputToFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName)) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your college name: ");
            String age = reader.readLine();

            System.out.print("Enter your branch: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}