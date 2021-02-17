package com.kodilla.sudoku1;

import java.util.ArrayList;

public class SudokuRow {
    private final ArrayList<SudokuElement> sudokuElements = new ArrayList<>();
    public SudokuRow(){
        for(int n =0;n<9;n++) {
            sudokuElements.add(n,new SudokuElement());
        }
    }
    public ArrayList<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }
}
