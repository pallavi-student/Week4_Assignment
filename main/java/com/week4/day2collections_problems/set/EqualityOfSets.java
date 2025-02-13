package com.week4.day2collections_problems.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EqualityOfSets {
    public static <T> boolean checkEquality(Set<T> s1, Set<T> s2) {
        HashSet<T> temp = new HashSet<>(s1);
        if(s1.size()!=s2.size())
            return false;
        for (T element : s1) {
            if (!s2.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Check equality of " + set1 + "\n" + set2 + "\n" + checkEquality(set1, set2));

        Set<String> set3 = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        Set<String> set4 = new HashSet<>(Arrays.asList("banana", "cherry", "apple"));
        System.out.println("Check equality of " + set3 + "\n" + set4 + "\n" + checkEquality(set3, set4));

    }
}




