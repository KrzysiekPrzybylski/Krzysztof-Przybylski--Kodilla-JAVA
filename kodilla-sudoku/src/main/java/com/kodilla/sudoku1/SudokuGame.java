package com.kodilla.sudoku1;

import java.util.ArrayList;

import static com.kodilla.sudoku1.Text.getLOGO;

public class SudokuGame {
    protected static int userChoice=1;
    protected static ArrayList<Integer> shoot;

    public static ArrayList<Integer> getShoot() {
        return shoot;
    }

    public static void setShoot(ArrayList<Integer> shoot) {
        SudokuGame.shoot = shoot;
    }

    public static void setUserChoice(int userChoice) {
        SudokuGame.userChoice = userChoice;
    }

    public static int getUserChoice() {
        return userChoice;
    }


    private boolean resolveSudoku() {
        Menu menu = new Menu();
        Board board = new Board();
        FillingBoard fillingBoard = new FillingBoard();
        boolean result=true;

        menu.makeChoice();
        while (getUserChoice() != 0) {

            switch (getUserChoice()) {
                case 0:
                    return true;
                case 1:
                    fillingBoard.resetBoard();
                    setUserChoice(2);
                    break;
                case 2:
                    while (getUserChoice() == 2) {
                        System.out.println(board.toString());
                        menu.makeChoice();
                    }
                    break;
                case 3:
                    fillingBoard.randomFilling(9);
                    setUserChoice(2);
                    break;
                default:
                    boolean isSuccess=fillingBoard.fillBoard(getShoot());
                    setUserChoice(2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getLOGO());
        boolean gameFinished = false;
        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }
    }


}