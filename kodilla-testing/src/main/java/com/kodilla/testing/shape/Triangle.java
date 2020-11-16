package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private final static String name = "Triangle";
    private double edgeLengthA;
    private double heightTriangle;

    public Triangle(double edgeLengthA, double heightTriangle) {
        this.edgeLengthA = edgeLengthA;
        this.heightTriangle = heightTriangle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.edgeLengthA, edgeLengthA) != 0) return false;
        return Double.compare(triangle.heightTriangle, heightTriangle) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(edgeLengthA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(heightTriangle);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return (edgeLengthA*heightTriangle)/2;
    }
}
