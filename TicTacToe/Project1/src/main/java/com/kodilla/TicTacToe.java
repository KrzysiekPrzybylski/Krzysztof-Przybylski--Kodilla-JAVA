package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

import static com.kodilla.Statistic.textFieldName;


public class TicTacToe extends Application {

    public static Statistic statistic = new Statistic();


    private GameMechanics myGame;
    private Button[] buttonsArray;


    public static void main(String[] args) {
        launch(args);
    }

    private static void accept(ButtonType rs) {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        statistic.setRoundNumber(1);
        statistic.setPlayerScore(0);
        statistic.setComputerScore(0);


        Scene scene = new Scene(createBoard());
        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createBoard() {
        GridPane grid = new GridPane();

        Text helloLabel = new Text("Kolko i Krzyzyk");
        helloLabel.setFont(new Font("Arial", 18));

        grid.add(helloLabel, 0, 0, 1, 1);



        Text round = new Text("Round "+statistic.getRoundNumber()+"/3");
        round.setFont(fontInApplication());
        Text score = new Text("Score");
        Text player = new Text();
        Text computer = new Text("Computer: "+statistic.getComputerScore());

        if(textFieldName.getText().equals("")){
            player.setText("You: "+statistic.getPlayerScore());
        }
        else {
            player.setText(textFieldName.getText() + ": " + statistic.getPlayerScore());
        }

        grid.add(round, 8,0,1,1);
        grid.add(score, 8,1,1,1);
        grid.add(player,8,2,1,1);
        grid.add(computer, 8, 3,1,1);

        Label whoStartsLabel = new Label("Kto rozpoczyna?");
        whoStartsLabel.setFont(fontInApplication());

        RadioButton playerStarts = new RadioButton("Gracz");
        playerStarts.setFont(fontInApplication());

        RadioButton computerStarts = new RadioButton("Komputer");
        computerStarts.setFont(fontInApplication());


        ToggleGroup toggleGroupWhoStart = new ToggleGroup();
        playerStarts.setToggleGroup(toggleGroupWhoStart);
        computerStarts.setToggleGroup(toggleGroupWhoStart);


        grid.add(whoStartsLabel, 5, 0, 1, 1);
        grid.add(playerStarts, 5, 1, 1, 1);
        grid.add(computerStarts, 5, 2, 1, 1);


        Label whatShape = new Label("Wybierz ksztalt: ");
        whatShape.setFont(fontInApplication());

        RadioButton chooseCross = new RadioButton("Krzyzyk");
        chooseCross.setFont(fontInApplication());

        RadioButton chooseCircle = new RadioButton("Kolko");
        chooseCircle.setFont(fontInApplication());

        ToggleGroup toggleGroupWhatShape = new ToggleGroup();
        chooseCircle.setToggleGroup(toggleGroupWhatShape);
        chooseCross.setToggleGroup(toggleGroupWhatShape);

        grid.add(whatShape, 6, 0, 1, 1);
        grid.add(chooseCircle, 6, 1, 1, 1);
        grid.add(chooseCross, 6, 2, 1, 1);

        Label difficultyLevel = new Label("Poziom trudnosci");
        difficultyLevel.setFont(fontInApplication());

        RadioButton easyLevel = new RadioButton("3x3");
        easyLevel.setFont(fontInApplication());
        RadioButton hardLevel = new RadioButton("5x5");
        hardLevel.setFont(fontInApplication());

        ToggleGroup toggleWhichLevel = new ToggleGroup();
        easyLevel.setToggleGroup(toggleWhichLevel);
        hardLevel.setToggleGroup(toggleWhichLevel);
        easyLevel.setOnMouseClicked(event -> {
            cleanupButtonsArray(buttonsArray);
            create3x3(grid);
        });
        hardLevel.setOnMouseClicked(event -> {
            cleanupButtonsArray(buttonsArray);
            create5x5(grid);
        });

        grid.add(difficultyLevel, 7, 0, 1, 1);
        grid.add(easyLevel, 7, 1, 1, 1);
        grid.add(hardLevel, 7, 2, 1, 1);


        Button newGameButton = new Button("Rozpocznij");
        newGameButton.setFont(fontInApplication());
        newGameButton.setId("100");

        grid.add(newGameButton, 3, 0, 2, 1);

        newGameButton.setOnAction((event) -> {
            cleanup(buttonsArray, (RadioButton) toggleGroupWhoStart.getSelectedToggle(),
                    (RadioButton) toggleGroupWhatShape.getSelectedToggle(), grid);
        });

        createHelloBox();
        create3x3(grid);


        return grid;
    }

    private void setWhichLevel(RadioButton selectedButtonWhichLevel, GridPane grid) {

        if (selectedButtonWhichLevel.getText().equals("3x3")) {
            cleanupButtonsArray(buttonsArray);
            create3x3(grid);
        }
        if (selectedButtonWhichLevel.getText().equals("5x5")) {
            cleanupButtonsArray(buttonsArray);
            create5x5(grid);
        }
    }


    private void cleanup(Button[] buttonsArrayHard, RadioButton selectedButtonWhoStart, RadioButton selectedButtonWhatShape, GridPane grid) {

        setWhoStart(selectedButtonWhoStart, selectedButtonWhatShape);

        cleanupButtonsArray(buttonsArray);

        if (myGame.getGameStatus().getActualPlayer() instanceof Computer) {
            myGame.computerClickButton(grid);
        }
    }
    private void cleanupButtonsArray(Button[] buttonsArray) {

        for(int i = 0; i < buttonsArray.length; i ++) {
            buttonsArray[i].setGraphic(null);
            buttonsArray[i].setDisable(false);
        }
    }

    private void setWhoStart(RadioButton selectedButtonWhoStart, RadioButton selectedButtonWhatShape) {

        if(selectedButtonWhoStart.getText().equals("Gracz")) {
            myGame = new GameMechanics(new User());
        } else if(selectedButtonWhoStart.getText().equals("Komputer")) {
            myGame = new GameMechanics(new Computer());
        }

        if(selectedButtonWhatShape.getText().equals("Kolko")) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Circle());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Cross());
        }else if(selectedButtonWhatShape.getText().equals("Krzyzyk")) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Cross());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Circle());
        }
    }

    public void createHelloBox() {
        Alert alert = new Alert(Alert.AlertType.NONE, "Hello", ButtonType.NEXT);
        alert.setTitle("Witaj!");
        alert.setHeaderText("Witaj w grze w kolko i krzyzyk");
        alert.setContentText("Przed rozpoczeciem gry wybierz gracza rozpoczynajacego oraz jego symbol. Nastepnie kliknij przycisk nowej gry.");
        alert.showAndWait().ifPresent(TicTacToe::accept);
    }

    public void create3x3 (GridPane grid) {
                buttonsArray = new Button[9];

        for(int i = 0; i < 9; i++) {
            Button button = new Button(" ");
            button.setMinSize(180, 180);
            button.setId(String.valueOf(i+1));
            button.setDisable(true);
            buttonsArray[i] = button;
        }

        grid.add(buttonsArray[0], 0,3);
        grid.add(buttonsArray[1], 1,3);
        grid.add(buttonsArray[2], 2,3);
        grid.add(buttonsArray[3], 0,4);
        grid.add(buttonsArray[4], 1,4);
        grid.add(buttonsArray[5], 2,4);
        grid.add(buttonsArray[6], 0,5);
        grid.add(buttonsArray[7], 1,5);
        grid.add(buttonsArray[8], 2,5);

        for(int i = 0; i < 9; i++) {
            int finalI = i;
            buttonsArray[i].setOnAction((event) -> {
                myGame.clickButton(buttonsArray[finalI], grid);
                buttonsArray[finalI].setDisable(true);
            });
        }
    }
    public void create5x5 (GridPane grid) {
        buttonsArray = new Button[25];

        for(int i = 0; i < 25; i++) {
            Button button = new Button(" ");
            button.setMinSize(100,100);
            button.setId(String.valueOf(i+1));
            button.setDisable(true);
            buttonsArray[i] = button;
        }

        grid.add(buttonsArray[0],0,1);
        grid.add(buttonsArray[1],1,1);
        grid.add(buttonsArray[2],2,1);
        grid.add(buttonsArray[3],3,1);
        grid.add(buttonsArray[4],4,1);
        grid.add(buttonsArray[5],0,2);
        grid.add(buttonsArray[6],1,2);
        grid.add(buttonsArray[7],2,2);
        grid.add(buttonsArray[8],3,2);
        grid.add(buttonsArray[9],4,2);
        grid.add(buttonsArray[10],0,3);
        grid.add(buttonsArray[11],1,3);
        grid.add(buttonsArray[12],2,3);
        grid.add(buttonsArray[13],3,3);
        grid.add(buttonsArray[14],4,3);
        grid.add(buttonsArray[15],0,4);
        grid.add(buttonsArray[16],1,4);
        grid.add(buttonsArray[17],2,4);
        grid.add(buttonsArray[18],3,4);
        grid.add(buttonsArray[19],4,4);
        grid.add(buttonsArray[20],0,5);
        grid.add(buttonsArray[21],1,5);
        grid.add(buttonsArray[22],2,5);
        grid.add(buttonsArray[23],3,5);
        grid.add(buttonsArray[24],4,5);

        for(int i = 0; i < 25; i++) {
            int finalI = i;
            buttonsArray[i].setOnAction((event) -> {
                myGame.clickButtonHard(buttonsArray[finalI], grid);
                buttonsArray[finalI].setDisable(true);
            });
        }
    }




    private Font fontInApplication() {

        Font applicationFont = new Font("Arial", 13);
        return applicationFont;
    }
}