package com.week4.day2collections_problems.queue;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

class StackUsingQueues<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    // Push operation: Always push to queue1
    public void push(T value) {
        queue1.add(value);
    }

    // Pop operation: Move all elements except last to queue2, remove last, swap queues
    public T pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        T topElement = queue1.remove(); // Remove last element

        // Swap queues
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Top operation: Return the last added element without removing
    public T top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        T topElement = queue1.peek(); // Get last element

        queue2.add(queue1.remove()); // Move last element to queue2

        // Swap queues
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackImplementationFromQueue {


    public class StackDemo {
        public static void main(String[] args) {
            StackUsingQueues<Integer> stack = new StackUsingQueues<>();

            stack.push(1);
            stack.push(2);
            stack.push(3);

            out.println("Top: " + stack.top()); // Output: 3
            out.println("Pop: " + stack.pop()); // Output: 3
            out.println("Pop: " + stack.pop()); // Output: 2
            out.println("Pop: " + stack.pop()); // Output: 1
        }
    }

}
