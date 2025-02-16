package com.week4.day5.regex;
import java.util.Scanner;
public class ValidateLicensePlate {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            //user input
            System.out.print("Enter a license plate number: ");
            String plate = scanner.nextLine();

            //two uppercase letters and four digits
            if (plate.matches("[A-Z]{2}\\d{4}")) {
                System.out.println("Valid license plate.");
            } else {
                System.out.println("Invalid license plate. Follow this Format 'AB1234'.");
            }

        }
    }


