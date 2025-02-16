package com.week4.day6.annotation;
import java.util.ArrayList;
public class SuppressWarning {
        @SuppressWarnings("unchecked")
        public static void main(String[] args) {
            ArrayList list = new ArrayList();  // No generics (raw type)
            list.add("Java");
            list.add(100);

            for (Object obj : list) {
                System.out.println(obj);
            }
        }
    }


