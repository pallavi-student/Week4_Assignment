package com.week4.day5.regex;
import java.util.regex.*;
import java.util.Scanner;
public class ExtractEmail {


    public class EmailExtractor {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text: ");
            String text = scanner.nextLine();
            String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(text);
            System.out.println("Extracted email addresses:");
            while (matcher.find()) {
                System.out.println(matcher.group());}
        }
    }

}
