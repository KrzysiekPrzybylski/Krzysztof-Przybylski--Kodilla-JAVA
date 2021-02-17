package com.kodilla.sudoku1;

public class Text {
    private static final String DASHED_LINE="-------------------";
    private static final String LOGO=DASHED_LINE+"\n"+"     SUDOKU"+"\n"+DASHED_LINE;

    private static final String MENU_TEXT="Input 3 numbers or multiple it,\n"  +
            "first is a x position, second is a y position, third number is a value. ,\n" +
            "You can also multiple that combination,\n" +
            "Ex. 345321 - where a 5 and 1 are the values,\n" +
            "\"sudoku\" is finishing game with autofile the board"+"\n"+
            "button x - is exit with question \"Are you sure?\",\n" +
            "button  n - means restart with question \"Are you sure?\",";

    public static String getMENU_TEXT() {
        return MENU_TEXT;
    }

    public static String getLOGO() {
        return LOGO;
    }
}

