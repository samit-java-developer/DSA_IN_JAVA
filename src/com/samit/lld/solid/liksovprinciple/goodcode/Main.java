package com.samit.lld.solid.liksovprinciple.goodcode;

abstract class Vehicle {
    public abstract void move(); // Movement logic
}

abstract class EngineVehicle extends Vehicle {
    public abstract void startEngine();
}

abstract class NonEngineVehicle extends Vehicle {
}

class Car extends EngineVehicle{
    @Override
    public void move() {
    }

    @Override
    public void startEngine() {
    }
}

class Bicycle extends NonEngineVehicle{

    @Override
    public void move() {

    }
}

public class Main {
    public static void main(String[] args) {
        // Using EngineVehicle
        EngineVehicle car = new Car();
        car.startEngine();  // Output: Car-specific engine starting logic
        car.move();         // Output: Movement logic

        // Using NonEngineVehicle
        NonEngineVehicle bicycle = new Bicycle();
        bicycle.move();  // Output: Movement logic
    }
}
