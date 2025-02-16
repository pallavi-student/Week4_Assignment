package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
    @Retention(RetentionPolicy.RUNTIME)
    @interface LogExecutionTime {}

    // Class with Methods Using @LogExecutionTime
    class TaskProcessor {

        @LogExecutionTime
        public void fastTask() {
            System.out.println("Executing fast task...");
        }

        @LogExecutionTime
        public void slowTask() {
            System.out.println("Executing slow task...");
            try {
                Thread.sleep(2000); // Simulate slow execution
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public class ExecutionTimeLogger {
        public static void main(String[] args) throws Exception {
            TaskProcessor processor = new TaskProcessor();
            Method[] methods = TaskProcessor.class.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    long startTime = System.nanoTime();
                    method.invoke(processor);
                    long endTime = System.nanoTime();
                    System.out.println("Execution Time of " + method.getName() + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
                }
            }
        }
    }


