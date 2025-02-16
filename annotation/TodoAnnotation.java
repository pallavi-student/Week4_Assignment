package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

    @Retention(RetentionPolicy.RUNTIME)
    @interface Todo {
        String task();
        String assignedTo();
        String priority() default "MEDIUM";
    }
    class Project {

        @Todo(task = "Implement login functionality", assignedTo = "Alice", priority = "HIGH")
        public void login() {
            System.out.println("Login feature (Pending)");
        }

        @Todo(task = "Optimize database queries", assignedTo = "Bob")
        public void optimizeDB() {
            System.out.println("Database optimization (Pending)");
        }

        public void completedFeature() {
            System.out.println("This feature is completed.");
        }
    }
public class TodoAnnotation {
        public static void main(String[] args) {
            Method[] methods = Project.class.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo annotation = method.getAnnotation(Todo.class);
                    System.out.println("Pending Task: " + annotation.task());
                    System.out.println("Assigned To: " + annotation.assignedTo());
                    System.out.println("Priority: " + annotation.priority());
                }
            }
        }
    }


