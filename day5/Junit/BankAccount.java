package com.week4.day5.Junit;

public class BankAccount {

        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive");
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }

        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000.0); // Initial balance: 1000

            System.out.println("Initial Balance: " + account.getBalance());

            // Deposit
            account.deposit(500);
            System.out.println("After Deposit: " + account.getBalance());

            // Withdraw
            try {
                account.withdraw(300);
                System.out.println("After Withdrawal: " + account.getBalance());
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }

            // Attempting Insufficient Withdrawal
            try {
                account.withdraw(1500);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

