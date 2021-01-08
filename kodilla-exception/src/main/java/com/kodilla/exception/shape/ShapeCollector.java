package com.kodilla.exception.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapeList = new ArrayList<>();


    public List<Shape> getShapeList() {
        return shapeList;
    }

    public boolean addFigure(Shape shape) {
        return shapeList.add(shape);
    }
    public boolean removeFigure(Shape shape) {
        return shapeList.remove(shape);
    }
    public Shape getFigure(int n) {
        Shape theFigure = null;
        if(n>=0 && n< shapeList.size()) {
            theFigure = shapeList.get(n);
        }
        return theFigure;
    }
    public void showFigure() {
        System.out.println(shapeList.toString());
    }
}

