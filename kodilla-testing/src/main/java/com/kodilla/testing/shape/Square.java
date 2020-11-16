package com.kodilla.testing.shape;

public class Square implements Shape {

    private final static String name = "Square";
    private double edgeLenght;

    public Square(double edgeLenght) {
        this.edgeLenght = edgeLenght;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.edgeLenght, edgeLenght) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(edgeLenght);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(edgeLenght, 2);

    }
}
