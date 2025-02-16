package com.week4.day5.regex;
import java.util.Scanner;
public class ValidateIPAddress {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            //user input
            System.out.print("Enter an IP address: ");
            String ip = scanner.nextLine();

            //pattern for a valid IPv4 address
            String ipPattern =
                    "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}" +
                            "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

            // Validate IP address
            if (ip.matches(ipPattern)) {
                System.out.println("Valid IPv4 address.");
            } else {
                System.out.println("Invalid IPv4 address.");
            }


        }
    }


