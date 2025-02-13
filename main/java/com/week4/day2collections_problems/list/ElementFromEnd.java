package com.week4.day2collections_problems.list;

public  class ElementFromEnd {
    // Generic Node class
    static class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    // Reverse Linked List
    public static <T> Node<T> reverseList(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> nextNode = null;

        while (current != null) {
            nextNode = current.next; // Store next node
            current.next = prev; // Reverse pointer
            prev = current; // Move prev to current
            current = nextNode; // Move current forward
        }
        return prev; // New head of the reversed list
    }

    // Get Nth element from end using two-pointer method
    public static <T> T getNthElementFromEnd(Node<T> head, int index) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }

        Node<T> first = head;
        Node<T> second = head;

        // Move first pointer `index` steps ahead
        for (int i = 0; i < index; i++) {
            if (first == null) {
                throw new IllegalArgumentException("Index out of bounds");
            }
            first = first.next;
        }

        // Move both pointers until `first` reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;
    }

    public static void main(String[] args) {
        // Creating a LinkedList: 10 -> 20 -> 30 -> 40 -> 50
        Node<Integer> head = new Node<>(10);
        head.next = new Node<>(20);
        head.next.next = new Node<>(30);
        head.next.next.next = new Node<>(40);
        head.next.next.next.next = new Node<>(50);

        // Print original list
        System.out.print("Original List: ");
        printList(head);

        // Reverse the list
//        head = reverseList(head);
//        System.out.print("Reversed List: ");
//        printList(head);

        // Get 2nd element from the end
        int index = 3;
        System.out.println("Element at index " + index + " from the end: " + getNthElementFromEnd(head, index));
    }

    // Helper method to print the linked list
    public static <T> void printList(Node<T> head) {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}