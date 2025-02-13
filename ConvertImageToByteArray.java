package com.week4.day3streamproblems;

import java.io.*;
import java.nio.file.Files;

public class ConvertImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "src/main/java/com/week4/day_3streamproblems/penguine.png";
        String outputImagePath = "src/main/java/com/week4/day_3streamproblems/pickachu.png";

        try {
            byte[] imageData = convertImageToByteArray(inputImagePath);
            writeByteArrayToImage(imageData, outputImagePath);
            System.out.println("Image converted to byte array and written back to file.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    //Method to convert image to byte array
    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }
    //method to write byte array to image
    private static void writeByteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}