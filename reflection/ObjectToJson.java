package com.week4.day6.reflection;
import java.lang.reflect.Field;
    class User {
        private String username = "JohnDoe";
        private int age = 30;
    }

    public class ObjectToJson {
        public static String toJson(Object obj) {
            StringBuilder json = new StringBuilder("{");
            try {
                Class<?> clazz = obj.getClass();
                Field[] fields = clazz.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    json.append("\"").append(fields[i].getName()).append("\": \"").append(fields[i].get(obj)).append("\"");
                    if (i < fields.length - 1) json.append(", ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json.append("}").toString();
        }

        public static void main(String[] args) {
            User user = new User();
            System.out.println(toJson(user));
        }
    }


