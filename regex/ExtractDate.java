package com.week4.day5.regex;
import java.util.regex.*;
import java.util.Scanner;
public class ExtractDate {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter dd/mm/yyyy ");
            String text = scanner.nextLine();
            String datePattern = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})\\b";
            Pattern pattern = Pattern.compile(datePattern);
            Matcher matcher = pattern.matcher(text);
            System.out.println("dates:");
            while (matcher.find()) {
                System.out.print(matcher.group() + ", ");
            }
        }
    }


