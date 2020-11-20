package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeCollector = new ArrayList<>();


    public List<Shape> getShapeCollector() {
        return shapeCollector;
    }

    public void addFigure(Shape shape) {
        shapeCollector.add(shape);

    }

    public boolean removeFigure(Shape shape) {
        return shapeCollector.remove(shape);
    }

    public Shape getFigure(int n) {
        Shape shape1 = null;
        if (n >= 0 && n < shapeCollector.size())
            shape1 = shapeCollector.get(n);

        return shape1;
    }


        public void showFigures () {
            System.out.println(shapeCollector.toString());
        }
    }

