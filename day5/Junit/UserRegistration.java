package com.week4.day5.Junit;
import java.util.regex.Pattern;
    public class UserRegistration {

        // Email validation regex
        private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        // Password must be at least 8 characters, contain one uppercase letter, and one digit
        private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

        public static String registerUser(String username, String email, String password) {
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username cannot be empty.");
            }
            if (!EMAIL_PATTERN.matcher(email).matches()) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            if (!PASSWORD_PATTERN.matcher(password).matches()) {
                throw new IllegalArgumentException("Password must be at least 8 characters, contain one uppercase letter, and one digit.");
            }
            return "User registered successfully: " + username;
        }

        public static void main(String[] args) {
            try {
                System.out.println(registerUser("JohnDoe", "john.doe@example.com", "Password1")); // ✅ Valid
                System.out.println(registerUser("", "invalid.email", "weakpass")); // ❌ Invalid
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


