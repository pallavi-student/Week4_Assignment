package com.week4.day2collections_problems.queue;

import java.util.Arrays;

class CircularBuffer<T> {
    private T[] buffer;
    private int head = 0; // Points to the oldest element
    private int tail = 0; // Points to the next insertion point
    private int size = 0; // Current number of elements
    private int capacity; // Fixed buffer size

    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = (T[]) new Object[capacity]; // Generic array creation
    }

    // Add an element to the buffer (overwrite if full)
    public void add(T value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity; // Circular increment
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Overwrite the oldest element
        }
    }

    // Get the current buffer contents
    public T[] getBufferContents() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return result;
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the buffer is full
    public boolean isFull() {
        return size == capacity;
    }
}

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println("Buffer: " + Arrays.toString(buffer.getBufferContents())); // Output: [1, 2, 3]

        buffer.add(4); // Overwrites 1
        System.out.println("Buffer: " + Arrays.toString(buffer.getBufferContents())); // Output: [2, 3, 4]
    }
}

