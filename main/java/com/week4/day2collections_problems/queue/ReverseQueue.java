package com.week4.day2collections_problems.queue;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue.isEmpty()) {
            return;
        }
        T front = queue.remove(); // Remove front element
        reverseQueue(queue);      // Recursively reverse the remaining queue
        queue.add(front);         // Add the removed element back at the end
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}

