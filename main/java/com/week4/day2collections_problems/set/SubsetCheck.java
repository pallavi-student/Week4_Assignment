package com.week4.day2collections_problems.set;
import java.util.*;

import static java.lang.System.out;

public class SubsetCheck {
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        for (T element : set1) {
            if (!set2.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean result = isSubset(set1, set2);
        out.println(result); // Output: true
    }
}


