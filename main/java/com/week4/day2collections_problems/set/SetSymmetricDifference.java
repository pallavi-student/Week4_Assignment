package com.week4.day2collections_problems.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

public class SetSymmetricDifference {

        public static <T> Set<T> setsDifference(Set<T>s1, Set<T>s2){
            HashSet<T> temp=new HashSet<>();
            for(T element:s1){
                if(!s2.contains(element))

                  temp.add(element);
            }
            for(T element:s2){
                if(!s1.contains(element))

                  temp.add(element);
            }
            return temp;

        }


            public static void main(String[] args) {
                Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3,5,6,7));
                Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 2, 1,0,7,3,4));
                out.println("set1 : "+set1);
                out.println("set2 : "+set2);

                out.println("Symmetric Difference: "+setsDifference(set1,set2));


            }
        }

