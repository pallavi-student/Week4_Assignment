package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

    @Retention(RetentionPolicy.RUNTIME)
    @interface JsonField {
        String name();
    }
    class Used {
        @JsonField(name = "user_name")
        private String username;

        @JsonField(name = "user_age")
        private int age;

        public Used(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    // Serialization Utility
    class JsonSerializer {
        public static String toJson(Object obj) throws IllegalAccessException {
            StringBuilder json = new StringBuilder("{");
            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    String jsonKey = field.getAnnotation(JsonField.class).name();
                    Object value = field.get(obj);
                    json.append("\"").append(jsonKey).append("\": \"").append(value).append("\", ");
                }}
            if (json.length() > 1) json.setLength(json.length() - 2);
            json.append("}");
            return json.toString();
        }
    }
    public class CustomJson {
        public static void main(String[] args) throws IllegalAccessException {
            Used user = new Used("JohnDoe", 30);
            System.out.println("JSON Output: " + JsonSerializer.toJson(user));
        }
    }


