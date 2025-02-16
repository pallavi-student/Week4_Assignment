package com.week4.day6.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
    @Retention(RetentionPolicy.RUNTIME)
    @interface MaxLength {
        int value();
    }

    // User Class with @MaxLength Annotation
    class User {
        @MaxLength(10)
        private String username;

        public User(String username) {
            validateMaxLength(this, username);
            this.username = username;
        }

        private void validateMaxLength(Object obj, String fieldValue) {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MaxLength.class)) {
                    int maxLength = field.getAnnotation(MaxLength.class).value();
                    if (fieldValue.length() > maxLength) {
                        throw new IllegalArgumentException(field.getName() + " exceeds max length of " + maxLength);
                    }
                }
            }
        }
        public String getUsername() {
            return username;
        }
    }
    public class MaxLengthValidate {
        public static void main(String[] args) {
            try {
                User validUser = new User("JohnDoe"); // Valid (<= 10 chars)
                System.out.println("User Created: " + validUser.getUsername());

                User invalidUser = new User("LongUsername123"); // Exceeds 10 chars -> Exception
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }


