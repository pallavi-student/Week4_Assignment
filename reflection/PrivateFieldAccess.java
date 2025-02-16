package com.week4.day6.reflection;
import java.lang.reflect.Field;



    class Person {
        private int age = 30; // Private field
    }

    public class PrivateFieldAccess {
        public static void main(String[] args) {
            try {
                Person person = new Person();
                Class<?> clazz = person.getClass();

                Field ageField = clazz.getDeclaredField("age");
                ageField.setAccessible(true); // Allow access to private field

                System.out.println("Original Age: " + ageField.get(person));

                ageField.set(person, 40); // Modify the private field
                System.out.println("Modified Age: " + ageField.get(person));

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


