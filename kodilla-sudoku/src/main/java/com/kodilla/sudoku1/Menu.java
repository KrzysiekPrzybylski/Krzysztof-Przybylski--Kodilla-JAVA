package com.kodilla.sudoku1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.kodilla.sudoku1.Text.getMENU_TEXT;

public class Menu {
    public void makeChoice() {
        System.out.println(getMENU_TEXT());
        Scanner reading = new Scanner(System.in);
        System.out.println("\n");
        String choice = reading.next();
        List<String> choiceList = new ArrayList<>(Arrays.asList("sudoku","x","n"));
        Shoot shoot = new Shoot();
        switch (choice) {
            case "sudoku":
                shoot.sudoku();
                break;
            case "x":
                System.out.println("Do you want exit?  yes/no");
                System.out.println("\n");
                choice=reading.next();
                if(choice.equals("yes")){
                    shoot.exit();
                } else shoot.repeatMenu();
                break;
            case "n":
                System.out.println("Do you want repeat?  yes/no");
                System.out.println("\n");
                choice=reading.next();
                if(choice.equals("yes")){
                    shoot.resetBoard();
                } else shoot.repeatMenu();
                break;
            default:
                shoot.getShoot().clear();
                for (int i = 0; i < choice.length(); i++) {
                    int j=0;
                    if(i!=2&&i!=5) {
                        j = Character.digit(choice.charAt(i), 10)-1;

                    } else {
                        j = Character.digit(choice.charAt(i), 10);
                    }
                    if (j >= 0 && j <= 9) {
                        shoot.getShoot().add(j);
                    } else {
                        shoot.repeatMenu();
                    }
                }
                shoot.setShoot();
                shoot.printBoard();
        }
    }
}
