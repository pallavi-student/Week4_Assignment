package com.week4.day6.annotation;


    // Parent class Animal
    class Animal {
        public void makeSound() {
            System.out.println("Animal makes a sound.");
        }
    }

    // Child class Dog overriding makeSound()
    class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Dog barks.");
        }
    }

    // Main class
    public class Overrideex {
        public static void main(String[] args) {
            Animal myDog = new Dog();
            myDog.makeSound(); // Output: Dog barks.
        }
    }


