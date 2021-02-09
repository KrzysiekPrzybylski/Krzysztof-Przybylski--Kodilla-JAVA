package com.kodilla.testing.Codility.FrogRiverOne;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution= new Solution2();
        int solution1 = solution.solution(6, new int[]{3, 2, 1, 4, 5, 5,4,3,6});
        System.out.println(solution1);
    }

    public int solution(int X, int[] A) {


        int steps = X;
        boolean[] bitmap = new boolean[steps + 1];
        for (int i = 0; i < A.length; i++) {
            if (!bitmap[A[i]]) {
                bitmap[A[i]] = true;
                steps--;
                if (steps == 0) return i;
            }
        }
        return -1;
    }
}
