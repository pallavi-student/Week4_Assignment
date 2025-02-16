package com.week4.day6.reflection;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OriginalAPIKey";
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Configuration.class;
            Field apiKeyField = clazz.getDeclaredField("API_KEY");

            apiKeyField.setAccessible(true); // Make private field accessible

            System.out.println("Original API_KEY: " + apiKeyField.get(null));

            apiKeyField.set(null, "NewSecureAPIKey"); // Modify static field

            System.out.println("Modified API_KEY: " + apiKeyField.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

