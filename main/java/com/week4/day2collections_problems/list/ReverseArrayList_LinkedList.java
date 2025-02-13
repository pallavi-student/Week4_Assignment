package com.week4.day2collections_problems.list;
import java.util.*;
    public class ReverseArrayList_LinkedList {
        // Reverse a List (ArrayList and LinkedList)
        public static <T>void reverseList(List<T>list){
        int left=0,right=list.size()-1;
        while(left<right){
            T temp=list.get(left);
            list.set(left,list.get(right));
            list.set(right,temp);
            left++;
            right--;
        }

    }

/// main method for execution of programme
        public static void main(String[] args) {
            //Reverse list for  LinkedList
            LinkedList<Integer>list=new LinkedList<>(Arrays.asList(1,2,3,4,5));
            System.out.println("Before reverse original List "+list);
            reverseList(list);
            System.out.println("After reverse function called "+list);

            //Reverse list for ArrayList
            ArrayList<String>arraylist=new ArrayList<>(Arrays.asList("pallavi","sanjana","Sujal","Suman"));
            System.out.println("Original ArrayList "+arraylist);
            reverseList(arraylist);
            System.out.println("reverse ArrayList "+arraylist);
}
}