package com.week4.day6.reflection;


    import java.lang.reflect.Constructor;
    import java.lang.reflect.Method;

class Student {
        private String name;

        public Student() {
            this.name = "Default Student";
        }

        public void showInfo() {
            System.out.println("Student Name: " + name);
        }
    }

    public class DynamicObjectCreation {
        public static void main(String[] args) {
            try {
                Class<?> clazz = Class.forName("Student");

                Constructor<?> constructor = clazz.getDeclaredConstructor();
                Object studentInstance = constructor.newInstance(); // Creating object without "new"

                Method showMethod = clazz.getMethod("showInfo");
                showMethod.invoke(studentInstance);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


