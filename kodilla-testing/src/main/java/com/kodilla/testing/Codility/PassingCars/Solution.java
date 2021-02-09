package com.kodilla.testing.Codility.PassingCars;

public class Solution {

    public int solution(int[] A) {
    int count = 0;
    int countZero = 0;
        for(
    int i = 0;
    i<A.length;i++)

    {
        if (A[i] == 0) {
            countZero++;
        }
        if (A[i] == 1) {
            count += countZero;
        }
        if (count > 100000) {
            return -1;
        }
    }
        return count;
}
}
