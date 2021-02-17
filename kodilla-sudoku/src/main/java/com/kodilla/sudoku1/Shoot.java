package com.kodilla.sudoku1;

import java.util.ArrayList;

import static com.kodilla.sudoku1.SudokuGame.setUserChoice;

public class Shoot {
    private ArrayList<Integer> shoot = new ArrayList<>();
    public ArrayList<Integer> getShoot() {
        return shoot;
    }
    public void setShoot(){
        SudokuGame.setShoot(shoot);
    }

    public void sudoku(){
        setUserChoice(3);
    }
    public void exit(){
        setUserChoice(0);
    }
    public  void resetBoard(){
        setUserChoice(1);
    }
    public  void repeatMenu(){
        setUserChoice(2);
    }
    public  void printBoard(){
        setUserChoice(4);
    }
}
