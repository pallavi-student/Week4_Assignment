package com.week4.day2collections_problems.map;

import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

class GroupedEmployee {
    public static <T extends Employee> Map<String, List<T>> groupByDepartment(List<T> employees) {
        Map<String, List<T>> grouped = new HashMap<>();

        for (T emp : employees) {
            grouped.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        System.out.println("Grouped Employees: " + groupByDepartment(employees));
    }
}
