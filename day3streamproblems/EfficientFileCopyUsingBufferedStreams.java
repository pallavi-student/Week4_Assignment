package com.week4.day3streamproblems;

import java.io.*;

public class EfficientFileCopyUsingBufferedStreams {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/com/week4/day_3/Source.txt";
        String destBuffered = "src/main/java/com/week4/day_3/destination.txt";
        String destUnbuffered = "src/main/java/com/week4/day_3/destination2.txt";

        // Copy using Buffered Streams
        long bufferedTime = copyWithBufferedStreams(sourceFile, destBuffered);
        System.out.println("Buffered Stream Time: " + bufferedTime + " ns");

        // Copy using Unbuffered Streams
        long unbufferedTime = copyWithUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Unbuffered Stream Time: " + unbufferedTime + " ns");
    }

    private static long copyWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}