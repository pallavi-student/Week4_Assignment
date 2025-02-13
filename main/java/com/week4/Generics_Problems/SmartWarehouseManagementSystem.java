package com.week4.day1;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a generic warehouse item
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item: " + name;
    }
}

// Electronics class extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Electronics - " + getName();
    }
}

// Groceries class extending WarehouseItem
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Groceries - " + getName();
    }
}

// Furniture class extending WarehouseItem
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Furniture - " + getName();
    }
}

// Generic Storage class for storing items of type T (bounded by WarehouseItem)
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
    }

    public List<T> getAllItems() {
        return items;
    }
}

// class to display all items in storage
class WarehouseUtility {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("\nDisplaying all items in storage:");
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        // Create storage instances for different types of items
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to electronics storage
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        // Add items to groceries storage
        groceriesStorage.addItem(new Groceries("Apple"));
        groceriesStorage.addItem(new Groceries("Milk"));

        // Add items to furniture storage
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Display all items from each storage
        WarehouseUtility.displayAllItems(electronicsStorage.getAllItems());
        WarehouseUtility.displayAllItems(groceriesStorage.getAllItems());
        WarehouseUtility.displayAllItems(furnitureStorage.getAllItems());
    }
}

