package com.kodilla.exception.io;

import com.kodilla.exception.shape.Rectangle;
import com.kodilla.exception.shape.Shape;
import com.kodilla.exception.shape.ShapeCollector;
import com.kodilla.exception.shape.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    @Test
    void testAddFigure() {
        //Given

        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Triangle(2.5, 3);

        //When

        //Then
        Assertions.assertTrue(shapeCollector.addFigure(shape));
        Assertions.assertEquals(1, shapeCollector.getShapeList().size());
    }

    @Test
    public void testAddFigure1() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Rectangle(5, 5);

        //When
        shapeCollector.addFigure(shape);
        //Then
        Assertions.assertEquals(1, shapeCollector.getShapeList().size());
    }

    @Test
    void testRemoveFigure() {
        //Given
        Triangle triangle = new Triangle(2.5, 3);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(triangle);

        //When
        boolean result = shapeCollector.removeFigure(triangle);

        //Then
        Assertions.assertTrue(result);
    }
    @Test
    public void testShowFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Triangle(2.5, 3);
        shapeCollector.addFigure(shape);
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(shape);

        //When
        List<Shape> result = shapeCollector.getShapeList();

        //Then
        Assertions.assertEquals(shapeList, result);
    }
}


