package com.kodilla.personalproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static com.kodilla.personalproject.Controller.whoFirst;
import static com.kodilla.personalproject.MainScene.buildMainScene;
import static com.kodilla.personalproject.StartMenu.getStartGrid;
import static com.kodilla.personalproject.StartMenu.startButton;


public class TicTacToe extends Application{

    public static GameStatus gameStatus = new GameStatus();
    public static Stage primaryStageClone;

    public static Scene startScene = new Scene(getStartGrid(), 700, 400, Color.RED);


    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        gameStatus.setRoundNumber(1);
        gameStatus.setPlayerScore(0);
        gameStatus.setComputerScore(0);

        primaryStage.setTitle("TIC TAC TOE");
        primaryStage.setScene(startScene);
        primaryStage.show();

        startButton.setOnAction((e) ->{
            primaryStage.setScene(buildMainScene());
            whoFirst();
        });
        primaryStageClone = primaryStage;
    }



}