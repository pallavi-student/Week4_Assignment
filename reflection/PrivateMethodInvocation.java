package com.week4.day6.reflection;

    import java.lang.reflect.Method;

    class Calculator {
        private int multiply(int a, int b) {
            return a * b;
        }
    }

    public class PrivateMethodInvocation {
        public static void main(String[] args) {
            try {
                Calculator calculator = new Calculator();
                Class<?> clazz = calculator.getClass();

                Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
                multiplyMethod.setAccessible(true); // Allow access to private method

                int result = (int) multiplyMethod.invoke(calculator, 5, 10);
                System.out.println("Multiplication Result: " + result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


