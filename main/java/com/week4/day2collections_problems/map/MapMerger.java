package com.week4.day2collections_problems.map;

import java.util.*;

class MapMerger {
    public static <K> Map<K, Integer> mergeMaps(Map<K, Integer> map1, Map<K, Integer> map2) {
        Map<K, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<K, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        System.out.println("Merged Map: " + mergeMaps(map1, map2)); // Output: {A=1, B=5, C=4}
    }
}
