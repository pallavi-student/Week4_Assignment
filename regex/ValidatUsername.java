package com.week4.day5.regex;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class ValidatUsername {
    public static boolean isValidUsername(String username) {
        // Check length
        if (username.length() < 5 || username.length() > 15) {
            return false;
        }
        // Check if it starts with a letter
        if (!Character.isLetter(username.charAt(0))) {
            return false;
        }
        // Check allowed characters Letters, numbers, underscore
        for (char ch : username.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            out.println("Valid Username");
        } else {
            out.println("Invalid Username");
        }

        scanner.close();
    }
}
