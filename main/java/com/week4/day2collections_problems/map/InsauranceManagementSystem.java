package com.week4.day2collections_problems.map;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.lang.System.out;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

class PolicyManagementSystem<T extends Policy> {
    private Map<String, T> policyHashMap = new HashMap<>();
    private Map<String, T> policyLinkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, T> policyTreeMap = new TreeMap<>();

    // Add policy to all maps
    public void addPolicy(T policy) {
        policyHashMap.put(policy.getPolicyNumber(), policy);
        policyLinkedHashMap.put(policy.getPolicyNumber(), policy);
        policyTreeMap.put(policy.getExpiryDate(), policy);
    }

    // Retrieve policy by policy number
    public T getPolicyByNumber(String policyNumber) {
        return policyHashMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<T> getExpiringPolicies() {
        List<T> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Map.Entry<LocalDate, T> entry : policyTreeMap.entrySet()) {
            long daysLeft = ChronoUnit.DAYS.between(today, entry.getKey());
            if (daysLeft >= 0 && daysLeft <= 30) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<T> getPoliciesByHolder(String holderName) {
        List<T> policies = new ArrayList<>();
        for (T policy : policyHashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, T>> iterator = policyTreeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, T> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                policyHashMap.remove(entry.getValue().getPolicyNumber());
                policyLinkedHashMap.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            }
        }
    }

    // Display all policies
    public void displayPolicies() {
        out.println("All Policies:");
        for (T policy : policyLinkedHashMap.values()) {
            out.println(policy);
        }
    }
}

public class InsauranceManagementSystem {
    public static void main(String[] args) {
        PolicyManagementSystem<Policy> system = new PolicyManagementSystem<>();

        // Sample policies
        Policy p1 = new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 500.0);
        Policy p2 = new Policy("P1002", "Bob", LocalDate.now().plusDays(35), "Auto", 700.0);
        Policy p3 = new Policy("P1003", "Alice", LocalDate.now().minusDays(5), "Home", 1000.0);
        Policy p4 = new Policy("P1004", "Charlie", LocalDate.now().plusDays(25), "Health", 600.0);

        // Adding policies
        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);
        system.addPolicy(p4);

        // Display all policies
        system.displayPolicies();

        // Retrieve a specific policy
        out.println("\nRetrieve Policy P1002: " + system.getPolicyByNumber("P1002"));

        // List expiring policies
        out.println("\nExpiring Policies (Next 30 days): " + system.getExpiringPolicies());

        // List policies by policyholder
       out.println("\nPolicies for Alice: " + system.getPoliciesByHolder("Alice"));

        // Remove expired policies
        system.removeExpiredPolicies();
        out.println("\nAfter Removing Expired Policies:");
        system.displayPolicies();
    }
}
