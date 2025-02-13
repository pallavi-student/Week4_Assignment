package com.week4.day2collections_problems.list;
import java.util.*;

import static com.week4.day2collections_problems.list.ReverseArrayList_LinkedList.reverseList;

public class RotateListElement {


        // Find Frequency of Elements
        public static Map<String, Integer> findFrequency(List<String> list) {
            Map<String, Integer> frequencyMap = new HashMap<>();
            for (String s : list) {
                frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
            }
            return frequencyMap;
        }

        // Rotate Elements in a List
        public static <T> void rotateList(List<T> list, int positions) {
            int size = list.size();
            positions = positions % size;
            List<T> temp = new ArrayList<>(list.subList(0, positions));
            reverseList(list.subList(0, positions));
            reverseList(list.subList(positions,list.size()));
            reverseList(list);


        }

    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        int position=2;
        System.out.println("Original list "+list);
        rotateList(list,position);

        System.out.println("after rotating by given position "+list);

    }

}
