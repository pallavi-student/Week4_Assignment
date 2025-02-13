package com.week4.day2collections_problems.map;

import java.util.*;

class MaxKeyFinder {
    public static <K, V extends Comparable<V>> K getMaxKey(Map<K, V> map) {
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Get max value
                .map(Map.Entry::getKey) // Extract key
                .orElse(null);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println("Key with max value: " + getMaxKey(map)); // Output: B
    }
}
