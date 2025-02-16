package com.week4.day5.Junit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class DateFormatter {

        public static String formatDate(String inputDate) {
            try {
                LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                return "Invalid date format";
            }
        }

        public static void main(String[] args) {
            String[] testDates = {"2025-02-16", "2000-01-01", "invalid-date"};

            for (String date : testDates) {
                System.out.println("Input: " + date + " -> Output: " + formatDate(date));
            }
        }
    }


