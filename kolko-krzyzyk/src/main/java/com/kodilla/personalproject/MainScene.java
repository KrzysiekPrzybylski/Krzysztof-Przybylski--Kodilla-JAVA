package com.kodilla.personalproject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static com.kodilla.personalproject.FencingFloorGrid.getFencingFloorGrid;
import static com.kodilla.personalproject.SummaryGrid.getSummaryGrid;


public class MainScene {

    public static Scene buildMainScene(){

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.add(getFencingFloorGrid(), 1, 2);
        mainGrid.add(getSummaryGrid(), 1, 1);
        Scene mainScene = new Scene(mainGrid, 1000, 800, Color.SILVER);
        return mainScene;
    }
}