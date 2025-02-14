package com.week4.day4exceptionhandeling;

class InterestCalculator {


    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 5, 2);
            System.out.println("Calculated Interest: " + interest);

            // This will cause an exception
            double invalidInterest = calculateInterest(-500, 5, 2);
            System.out.println("Invalid Interest: " + invalidInterest);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
