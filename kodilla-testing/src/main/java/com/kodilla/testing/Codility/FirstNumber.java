package com.kodilla.testing.Codility;

public class FirstNumber {

    public static void main(String[] args) {

        FirstNumber firstNumber = new FirstNumber();
        int[] ints = {1,2,3,5,6,7,7,8,9};
        int solution1 = firstNumber.solution(ints);
        System.out.println(solution1);
    }


    public int solution(int[] A) {

        boolean[] existingNumbers = new boolean[100_001];

        for (int i: A) {
            if(i>0 && i<100001) {
                existingNumbers[i-1] = true;
            }
        }

        for (int i = 0; i < existingNumbers.length; i++) {
            if(!existingNumbers[i]) {
                return i+1;
            }
        }

        return 0;
        }
    }





