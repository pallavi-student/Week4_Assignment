package com.week4.day5.Junit;

public class PerformanceTest {

        public static String longRunningTask() {
            try {
                Thread.sleep(3000); // Simulates a long task (3 seconds)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Task Completed";
        }

        public static void main(String[] args) {
            System.out.println("Starting long-running task...");
            String result = longRunningTask();
            System.out.println("Result: " + result);
        }
    }



