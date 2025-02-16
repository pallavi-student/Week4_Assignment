package com.week4.day6.reflection;

    import java.lang.reflect.Method;

    // Class with Methods to Measure
    class Task {
        public void fastMethod() {
            System.out.println("Fast Method Executed");
        }

        public void slowMethod() {
            try {
                Thread.sleep(2000);
                System.out.println("Slow Method Executed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public class MethodTimer {
        public static void measureExecutionTime(Object obj, String methodName) {
            try {
                Method method = obj.getClass().getMethod(methodName);
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();
                System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            Task task = new Task();
            measureExecutionTime(task, "fastMethod");
            measureExecutionTime(task, "slowMethod");
        }
    }


