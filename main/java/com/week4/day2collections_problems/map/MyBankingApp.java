package com.week4.day2collections_problems.map;

import java.util.*;

class BankingSystem<T> {
    private Map<T, Double> accountMap = new HashMap<>();
    private TreeMap<T, Double> sortedAccounts = new TreeMap<>(Comparator.comparing(accountMap::get)); // Sorts accounts by balance
    private Queue<T> withdrawalQueue = new LinkedList<>();

    // Create a new account with an initial balance
    public void createAccount(T accountNumber, double initialBalance) {
        accountMap.put(accountNumber, initialBalance);
    }

    // Deposit money into an account
    public void deposit(T accountNumber, double amount) {
        accountMap.put(accountNumber, accountMap.getOrDefault(accountNumber, 0.0) + amount);
        System.out.println("Deposited $" + amount + " into account " + accountNumber);
    }

    // Request a withdrawal (adds account to queue)
    public void requestWithdrawal(T accountNumber) {
        if (accountMap.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for account " + accountNumber);
        } else {
            System.out.println("Account " + accountNumber + " does not exist.");
        }
    }

    // Process withdrawals from the queue
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            T accountNumber = withdrawalQueue.poll();
            double balance = accountMap.get(accountNumber);
            double withdrawalAmount = Math.min(balance, 50.0); // Withdraw up to $50
            accountMap.put(accountNumber, balance - withdrawalAmount);
            System.out.println("Withdrawn $" + withdrawalAmount + " from account " + accountNumber);
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        sortedAccounts.putAll(accountMap);
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<T, Double> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + " -> $" + entry.getValue());
        }
    }
}

public class MyBankingApp {
    public static void main(String[] args) {
        BankingSystem<String> bank = new BankingSystem<>();

        // Creating accounts
        bank.createAccount("A1001", 500.0);
        bank.createAccount("A1002", 1500.0);
        bank.createAccount("A1003", 800.0);

        // Depositing money
        bank.deposit("A1001", 200.0);
        bank.deposit("A1003", 100.0);

        // Requesting withdrawals
        bank.requestWithdrawal("A1001");
        bank.requestWithdrawal("A1002");

        // Processing withdrawals
        bank.processWithdrawals();

        // Display sorted accounts
        bank.displaySortedAccounts();
    }
}
