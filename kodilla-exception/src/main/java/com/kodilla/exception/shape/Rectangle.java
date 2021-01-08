package com.kodilla.exception.shape;

public class Rectangle implements Shape{


    private final String name = "Rectangle";
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return null;
    }

    @Override
    public double getField() {
        return width*height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        return name != null ? name.equals(rectangle.name) : rectangle.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
