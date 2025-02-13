package com.week4.day2collections_problems.map;

import java.util.*;

class ShoppingCart<T> {
    private Map<T, Double> priceMap = new HashMap<>(); // Stores product prices
    private Map<T, Double> orderedCart = new LinkedHashMap<>(); // Maintains order of items added
    private TreeMap<T, Double> sortedCart = new TreeMap<>(Comparator.comparing(priceMap::get)); // Sorts items by price

    // Add a product with price
    public void addProduct(T product, double price) {
        priceMap.put(product, price);
        orderedCart.put(product, price);
    }

    // Display items in order they were added (LinkedHashMap)
    public void displayCartInOrder() {
        System.out.println("\nShopping Cart (Order of Addition):");
        for (Map.Entry<T, Double> entry : orderedCart.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    // Display items sorted by price (TreeMap)
    public void displaySortedByPrice() {
        sortedCart.putAll(priceMap); // Sort the HashMap by price
        System.out.println("\nShopping Cart (Sorted by Price):");
        for (Map.Entry<T, Double> entry : sortedCart.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    // Calculate and display total price
    public void displayTotalPrice() {
        double total = 0;
        for (double price : orderedCart.values()) {
            total += price;
        }
        System.out.println("\nTotal Price: $" + total);
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        ShoppingCart<String> cart = new ShoppingCart<>();

        // Adding products
        cart.addProduct("Laptop", 1200.99);
        cart.addProduct("Mouse", 25.49);
        cart.addProduct("Keyboard", 45.99);
        cart.addProduct("Monitor", 199.99);

        // Display cart in order of addition
        cart.displayCartInOrder();

        // Display cart sorted by price
        cart.displaySortedByPrice();

        // Display total price
        cart.displayTotalPrice();
    }
}
