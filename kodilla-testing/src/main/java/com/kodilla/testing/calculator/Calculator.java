package com.kodilla.testing.calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public void run(){
         System.out.println("sum: " + add(5,6));
         System.out.println("substract: " + subtract(64,56));
    }
}
