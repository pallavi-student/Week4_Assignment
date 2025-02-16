package com.week4.day5.Junit;
import java.util.regex.Pattern;
public class PasswordValidator {

        private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

        public static boolean isValidPassword(String password) {
            return password != null && pattern.matcher(password).matches();
        }

        public static void main(String[] args) {
            String[] testPasswords = {
                    "Password1","password", "PASSWORD", "Pass1", "StrongPass99"};
            for (String password : testPasswords) {
                System.out.println("Password: " + password + " -> " + (isValidPassword(password) ? "Valid" : "Invalid"));
            }
        }
    }


