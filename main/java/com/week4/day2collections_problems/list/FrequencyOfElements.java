package com.week4.day2collections_problems.list;



import java.util.*;
public class FrequencyOfElements {
    //Find frequency of Elements
    public static <T> Map<T,Integer>findFrequency(List<T>list){
     Map<T,Integer>frequencyMap=new HashMap<>();
     for(T s:list){
         frequencyMap.put(s,frequencyMap.getOrDefault(s,0)+1);
     }
     return frequencyMap;
    }


public static void main(String[] args) {
    List<String>arr=new ArrayList<>(Arrays.asList("Ab","Ab","ba","ca","ba","ca","dda"));
    System.out.println("original ArrayList :"+arr);
   Map<String,Integer>frequencyMap= FrequencyOfElements.findFrequency(arr);
    System.out.println("Frequency of elements in a list "+frequencyMap);
}
}





