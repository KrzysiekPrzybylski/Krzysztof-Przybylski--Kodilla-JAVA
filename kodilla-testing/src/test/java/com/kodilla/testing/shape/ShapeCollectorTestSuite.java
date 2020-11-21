package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import java.util.ArrayList;
import java.util.List;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("This is the beginning test. ");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("All Test are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Prepering to execute Test # " + testCounter);
    }


    @Nested
    @DisplayName("Test Add And Remove Figure")
    class TestAddAndRemove {
        @Test
        public void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(5);

            //When
            shapeCollector.addFigure(shape);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCollector().size());
        }

        @Test
        public void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(5);
            shapeCollector.addFigure(shape);

            //When
            boolean result = shapeCollector.removeFigure(shape);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCollector().size());
        }

        @Test
        public void testRemoveFigureWhichNotExist() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Square(5));

            //When
            boolean result = shapeCollector.removeFigure(new Square(5));

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCollector().size());
        }
    }
    @Nested
    @DisplayName("Test get number of existing figure and show figure")
    class TestGetNumberAndShowFigure {
        @Test
        public void testGetFigureExistNumber() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(5);
            shapeCollector.addFigure(shape);

            //When
            Shape shapeResult = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(shape, shapeResult);
        }

        @Test
        public void testShowFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(5);
            shapeCollector.addFigure(shape);
            List<Shape> shapeList = new ArrayList<>();
            shapeList.add(shape);

            //When
            List<Shape> resultShapeList = shapeCollector.getShapeCollector();

            //Then
            Assertions.assertEquals(shapeList.toString(), resultShapeList.toString());

        }
    }
}
