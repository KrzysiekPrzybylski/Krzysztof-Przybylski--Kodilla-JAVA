package com.kodilla.testing.Codility.PermCheck;

public class PermCheck {

    public int solution(int[] A) {

        boolean[] result = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            int index = A[i] - 1;
            if (index > A.length - 1) return 0;
            if (!result[index]) {
                result[index] = true;
            } else {
                return 0;
            }
        }
        return 1;
    }
}

