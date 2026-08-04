package com.samit.lld.solid.liksovprinciple.badcode;

// Problematic approach that violates LSP
class Vehicle {
    public void startEngine() {
    }
}

class Car extends Vehicle {
    @Override
    public void startEngine() {
        // Car-specific engine starting logic
    }
}

class Bicycle extends Vehicle {
    @Override
    public void startEngine() {
        // Problem: Bicycles don't have engines!
        throw new UnsupportedOperationException("Bicycles don't have engines");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating objects of different subclasses
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        // Using polymorphism
        System.out.println("Car:");
        car.startEngine();  // Output: Car engine started.
        System.out.println(" Bicycle:");
        try {
            bicycle.startEngine();  // Throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

   // In this problematic approach, the Vehicle class has a startEngine() method,
    //which is appropriate for Car but not for Bicycle. This violates the Liskov Substitution
    //Principle (LSP) because the Bicycle class cannot be substituted / used in place of the Vehicle
   // class without causing unexpected behavior (i.e., throwing an exception).
   // When a subclass cannot fulfill the contract of its parent class, it leads to a breakdown in
    //polymorphism, making the code less reliable and predictable. The Bicycle class, when forced to implement the
    //startEngine() method, must either provide a meaningless implementation or
    //throw an exception, both of which are undesirable outcomes.
}
