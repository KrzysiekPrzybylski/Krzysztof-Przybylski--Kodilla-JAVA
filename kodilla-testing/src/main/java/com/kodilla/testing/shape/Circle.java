package com.kodilla.testing.shape;

public class Circle implements Shape{

    private final static String name = "Circle";
    private double radiusLength;

    public Circle(double radiusLength) {
        this.radiusLength = radiusLength;
    }


    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radiusLength,2);
    }
}
