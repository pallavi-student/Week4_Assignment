package com.week4.day2collections_problems.set;

import java.util.*;

public class SetToSortedList {
    public static <T extends Comparable<T>> void convertAndSortSet(List<T> list) {
        // Implementing an in-place bubble sort
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
    public static <T extends Comparable<T>>void sortedSet(Set<T>s){
        ArrayList<T>a=new ArrayList<>(s);
        Collections.sort(a);

    }


    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(9);
        hashSet.add(1);

        List<Integer> list = new ArrayList<>(hashSet);
//        convertAndSortSet(list);
        sortedSet(hashSet);
        System.out.println(list); // Output: [1, 3, 5, 9]
    }
}
