package com.kodilla.personalproject;

import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import static com.kodilla.personalproject.FencingFloorGrid.stackPaneHashMap;
import static com.kodilla.personalproject.StartMenu.circleRadio;


public interface EnterSymbol {

    double lineWidth = 5;

    static void putCross(StackPane sp) {
        Line line1 = new Line(10, 10, 140, 140);
        Line line2 = new Line(10, 140, 140, 10);
        line1.setStrokeWidth(lineWidth);
        line2.setStrokeWidth(lineWidth);
        Shape cross = Shape.union(line1, line2);
        sp.getChildren().add(cross);
        stackPaneHashMap.put(sp, Symbol.CROSS.number);

    }


    static void putCircle(StackPane sp) {

        Ellipse circle = new Ellipse(20, 20, 70, 70);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(lineWidth);
        sp.getChildren().add(circle);
        stackPaneHashMap.put(sp, Symbol.CIRCLE.number);
    }

    static void drawComputerSymbol(Toggle toggle) {
        ArrayList<StackPane> list = new ArrayList<>();
        for (Map.Entry<StackPane, Integer> entry : stackPaneHashMap.entrySet()) {
            if (entry.getValue() == Symbol.EMPTY.number) {
                list.add(entry.getKey());
            }
        }
        Random random = new Random();
        int index = random.nextInt(list.size());

        if (!toggle.equals(circleRadio)) {
            EnterSymbol.putCircle(list.get(index));
        } else {
            EnterSymbol.putCross(list.get(index));
        }
    }
}
