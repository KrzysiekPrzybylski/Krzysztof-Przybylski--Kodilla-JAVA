package com.kodilla.tesujemy;

import java.util.ArrayList;
import java.util.List;

public class Testowy {

    public List<String> sudokuRow = new ArrayList<>();
    protected static int[] board = new int[10];



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
               if (i == 0 && j == 0) {
                    result.append("    ");
               } else if (i==0) {
                  result.append("_   ");
               } else if (j==0) {
                   result.append("  | ");
               } else {
                   result.append("_ | ");
               }
            }
            result.append("\n");
        }
        return result.toString();
    }

    public String kaka() {
        String result = "";
        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++) {
                if(i==0 && j==0) {
                    result += " " + "   ";
                }
                else if(i==0) {
                    result += "_" + "   ";
                }
                   /*else if(i==3 || i==6) {
                        result += "_" + " | ";
                    }*/
                else if(j==0) {
                    result += " " + " | ";
                }
                    /*else if(j==3 || j==6) {
                        result += "_" + " || ";
                    }*/
                else result += "_" + " | ";
            }
            result += "\n";
        }
        return result;
    }
    public static int[] getBoard() {
        return board;
    }
    public static void writeMatrix(int[][] solution) {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0){
                System.out.println(" -----------------------");}
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0)
                    System.out.print("|       ");

            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
}
