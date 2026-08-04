package com.samit.lld.solid.openclosed.goodcode;

// Better approach following Open/Closed Principle
abstract class Shape {
    abstract double calculateArea();
    // We can also use an interface instead of an abstract class
}

class Circle extends Shape {
    private double radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    public Circle() {}
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {}

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Adding a new shape without modifying existing code
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GoodCodeOpenClose {
    public static void main(String[] args) {
        Shape shape = new Circle(2);
        double areaCircle=shape.calculateArea();
        System.out.println(areaCircle);
        System.out.println("--------------------------");
        shape=new Rectangle(2,4);
        double areaRec=shape.calculateArea();
        System.out.println(areaRec);
        System.out.println("--------------------------");
        shape=new Triangle(2,4);
        double areaTr=shape.calculateArea();
        System.out.println(areaTr);
    }
}