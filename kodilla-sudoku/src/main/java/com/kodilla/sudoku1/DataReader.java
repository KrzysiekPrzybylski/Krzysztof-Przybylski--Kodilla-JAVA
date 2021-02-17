package com.kodilla.sudoku1;

import java.util.Scanner;

public class DataReader {
    private Scanner sc;

    public DataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }
    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }
}
