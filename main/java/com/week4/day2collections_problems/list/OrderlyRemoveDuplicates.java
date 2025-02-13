package com.week4.day2collections_problems.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderlyRemoveDuplicates {
    public static <T> void removeDuplicates(List<T> list) {
        List<T> temp = new ArrayList<>();
        for (T element : list) {
            if (!temp.contains(element)) {
                temp.add(element);
            }

        }
        list.clear();
        list.addAll(temp);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(3, 1, 2, 2, 3, 4));
        System.out.println("Original list " + list);
        removeDuplicates(list);
        System.out.println("After duplicates removal" + list);

    }
}

