package com.kodilla.exception.test;

public class ExceptionHandling {


        public static void main(String[] args) {

            SecondChallenge secondChallenge = new SecondChallenge();
            try {
                String result = secondChallenge.probablyIWillThrowException(2,1.5);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("x must be between 1 and 2. y can't be equals 1.5  " + e);
            } finally {
                System.out.println("Always are exceptions");
            }
        }
    }


