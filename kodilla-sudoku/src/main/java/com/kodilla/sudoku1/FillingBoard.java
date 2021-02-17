package com.kodilla.sudoku1;

import java.util.ArrayList;
import java.util.Random;

public class FillingBoard {
    private CheckBoard checkBoard = new CheckBoard();
    private int randomValue;
    Random random = new Random();
    protected static SudokuRow[] boardsList = new SudokuRow[10];


    public static SudokuRow[] getBoardsList() {
        return boardsList;
    }

    public void resetBoard() {
        for (int i = 0; i < 9; i++) {
            for (int b = 0; b < 9; b++) {
                checkBoard.setValue(b, i, -1);
            }
        }
    }

    public boolean fillBoard(ArrayList<Integer> shoot) {
        boolean isRepeated;
        isRepeated = checkBoard.checkBoardSetValue(shoot.get(0), shoot.get(1), shoot.get(2));
        if(shoot.size()>3&&shoot.size()<7) {
            isRepeated = checkBoard.checkBoardSetValue(shoot.get(3), shoot.get(4), shoot.get(5));
        }
        return isRepeated;
    }

    public boolean randomFilling(int number) {
        boolean isRepeated = false;
        int secondCounter = 0;
        int thirdCounter=0;




        //    int numberOfLine = 0;
//        while (numberOfLine < 9) {
//
//
//


        linesloop:
        for (int numberOfLine = 0; numberOfLine < 9; numberOfLine++) {
            int counter = 0;
            levelsLoop:
            while (checkBoard.countNumbersInLine(numberOfLine) <= number) {
                columnesLoop:
                for (int numberOfColumne = 0; numberOfColumne < 9; numberOfColumne++) {
                    randomValue = random.nextInt(10);
                    while (randomValue < 1) {
                        randomValue = random.nextInt(10);
                    }
                    for (int i = 0; i < 100; i++) {
                        isRepeated = checkBoard.checkBoardSetValue(numberOfColumne, numberOfLine, randomValue);
                        if (isRepeated) {
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (isRepeated) {
                        counter++;
                    }
                    if (checkBoard.countNumbersInLine(numberOfLine) == number) {
                        break levelsLoop;
                    }
                }
                if (counter > 100) {
                    for (int b = 0; b < 9; b++) {
                        checkBoard.setValue(b, numberOfLine, -1);
                    }
                    counter = 0;
                    secondCounter++;
                }
                if (secondCounter == 100) {
                    for (int b = 0; b < 9; b++) {
                        checkBoard.setValue(b, numberOfLine, -1);
                    }
                    if (numberOfLine > 0) {
                        numberOfLine = numberOfLine - 1;
                        for (int b = 0; b < 9; b++) {
                            checkBoard.setValue(b, numberOfLine, -1);
                        }
                        if (numberOfLine >= 1) {
                            numberOfLine = numberOfLine - 1;
                            for (int b = 0; b < 9; b++) {
                                checkBoard.setValue(b, numberOfLine, -1);
                            }
                        }
                    }
                    secondCounter++;
                } else if (secondCounter == 150) {
                    resetBoard();
                    thirdCounter++;
                    numberOfLine = 0;
                    secondCounter=0;
                }
                if (thirdCounter == 2) {
                    return true;
                }

            }
        }
        return true;
    }
}
