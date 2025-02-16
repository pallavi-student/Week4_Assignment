package com.week4.day6.reflection;
import java.lang.reflect.Method;
import java.util.Scanner;

    class MathOperations {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }
    }

    public class DynamicMethodInvocation {
        public static void main(String[] args) {
            try {
                Scanner scanner = new Scanner(System.in);
                MathOperations mathOperations = new MathOperations();
                Class<?> clazz = mathOperations.getClass();

                System.out.print("Enter method name (add, subtract, multiply): ");
                String methodName = scanner.nextLine();

                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();
                scanner.close();

                Method method = clazz.getMethod(methodName, int.class, int.class);
                int result = (int) method.invoke(mathOperations, num1, num2);

                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }



