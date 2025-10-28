package com.samit.designpattern.factory;

interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ShapeFactory{
    public static Shape getShape(String type){
        if ("circle".equalsIgnoreCase(type)){
            return new Circle();
        }else if ("square".equalsIgnoreCase(type)) {
            return new Square();
        }
        return null;
    }
}

public class FactoryPatternEx {

    public static void main(String[] args) {
        Shape shape1=ShapeFactory.getShape("circle");
        Shape shape2=ShapeFactory.getShape("square");
        assert shape1 != null;
        shape1.draw();
        assert shape2 != null;
        shape2.draw();
    }
}
