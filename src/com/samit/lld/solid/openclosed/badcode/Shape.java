package com.samit.lld.solid.openclosed.badcode;

// Incorrect approach
class Shape {
    private String type;
    public double calculateArea() {
        if (type.equals("circle")) {
            // Circle area calculation
        } else if (type.equals("rectangle")) {
            // Rectangle area calculation
        }
        // Adding a triangle requires modifying this method
        return 0.0d;
    }
}