package com.kodilla.sudoku1;

import static com.kodilla.sudoku1.Board.getBoard;

public class CheckBoard {
    private boolean isValueRepeated=false;

    public boolean checkLevel(int y,int value){
        for (int n = 0; n < 9; n++) {
            if (value == getBoard()[y].getSudokuElements().get(n).getValue()) {
                isValueRepeated = true;
                break;
            }
        }
        return isValueRepeated;
    }

    public boolean checkVertical(int x,int value){
        for (int n = 0; n < 9; n++) {
            if (value == getBoard()[n].getSudokuElements().get(x).getValue()) {
                isValueRepeated = true;
                break;
            }
        }
        return isValueRepeated;
    }

    public boolean checkBlock(int number,int value){
        switch(number){
            case 0: {
                for(int z=0;z<3;z++){
                    for(int i=0;i<3;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 1: {
                for(int z=0;z<3;z++){
                    for(int i=3;i<6;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 2: {
                for(int z=0;z<3;z++){
                    for(int i=6;i<9;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 3: {
                for(int z=3;z<6;z++){
                    for(int i=0;i<3;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 4: {
                for(int z=3;z<6;z++){
                    for(int i=3;i<6;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 5: {
                for(int z=3;z<6;z++){
                    for(int i=6;i<9;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 6: {
                for(int z=6;z<9;z++){
                    for(int i=0;i<3;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 7: {
                for(int z=6;z<9;z++){
                    for(int i=3;i<6;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
            case 8: {
                for(int z=6;z<9;z++){
                    for(int i=6;i<9;i++){
                        if(getBoard()[z].getSudokuElements().get(i).getValue()==value){
                            isValueRepeated = true;
                            break;
                        }
                    }
                }
                return isValueRepeated;
            }
        }
        return isValueRepeated=false;
    }



    public boolean setValue(int x,int y,int value){
        getBoard()[y].getSudokuElements().get(x).setValue(value);
        return true;
    }

    public int countNumbersInLine(int numberOfLine) {
        int counter = 0;
        for (int n = 0; n < 9; n++) {
            if (getBoard()[numberOfLine].getSudokuElements().get(n).getValue() != -1) {
                counter++;
            }
        }
        return counter;
    }

    public boolean checkBoardSetValue(int x,int y,int value){
        isValueRepeated=true;
        boolean isPositionEmpty=getBoard()[y].getSudokuElements().get(x).getValue()==-1;
        //isPositionEmpty=true; //cheatmode
        if(isPositionEmpty) {
            isValueRepeated=false;
            if(!checkLevel(y,value)) {
                if(!checkVertical(x,value)) {
                    if (x <= 2 && y <= 2) {
                        if (!checkBlock(0,value)) {
                            setValue(x,y,value);
                        }
                    }
                    if (x > 2 && x <= 5 && y <= 2) {
                        if (!checkBlock(1,value)) {
                            setValue(x,y,value);
                        }
                    }
                    if (x > 5 && x <= 8 && y <= 2) {
                        if (!checkBlock(2, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x <= 2 && y <= 5 && y > 2) {
                        if (!checkBlock(3, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if(x > 2 && x <= 5 && y <= 5 && y > 2) {
                        if (!checkBlock(4, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && y <= 5 && y > 2) {
                        if (!checkBlock(5, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x <= 2 && y > 5) {
                        if (!checkBlock(6, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 2 && x <= 5 && y > 5) {
                        if (!checkBlock(7, value)) {
                            setValue(x, y, value);
                        }
                    }
                    if (x > 5 && y > 5) {
                        if (!checkBlock(8, value)) {
                            setValue(x, y, value);
                        }
                    }
                }
            }
        }
        return isValueRepeated;
    }
}
