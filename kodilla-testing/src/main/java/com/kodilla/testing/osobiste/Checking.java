package com.kodilla.testing.osobiste;

import java.math.BigInteger;

public class Checking {

    public static void main(String[] args) {
//        Polindrom polindrom = new Polindrom();
//
//        char[] slowo = {'A','B','O','R','Y','G','E','N','E','G','Y','R','O','B','A'};
//
//       if (polindrom.czyPolindrom(slowo,0,14)==true) {
//           System.out.println("O kurwa dziala");
//       } else {
//            System.out.println("Gówno z dupy");
//        }
//
//        Zliczanie zliczanie = new Zliczanie();
//        System.out.println("Suma  " + zliczanie.czyPoliczone(15781));

        Fibonacci fibonacci = new Fibonacci();
        int n = 52;

        System.out.println("Fibonacci z " + n + " = " + fibonacci.fib(n));

    }
}
