package com.kodilla.testing.Codility.FrogRiverOne;

public class Solution {
    public static void main(String[] args) {
        Solution2 solution= new Solution2();
        int solution1 = solution.solution(6, new int[]{3, 2, 1, 4, 5, 5,4,3,6});
        System.out.println(solution1);
    }

    public int solution(int X, int[] A) {

        int max= 0;
        int[] alreadyFallen = new int[A.length];
        for (int i = 0; i < alreadyFallen.length; i++) {
            alreadyFallen[i] = -1;
        }
        for (int i = 0; i < A.length; i++) {
            int position = A[i];
            if(position-1<alreadyFallen.length && alreadyFallen[position-1] == -1) {
                alreadyFallen[position-1] = i;
            }
            if (A[i] > max) {
                max=A[i];
            }
        }
        int lastLeaf = 0;
        for (int i = 0; i < X; i++) {
            if(alreadyFallen[i] >=0) {
                if(alreadyFallen[i] >lastLeaf) {
                    lastLeaf = alreadyFallen[i];
                }
            } else {
                return -1;
            }
        }
        if(max==0) {
            return -1;
        }
        return lastLeaf;
    }
}

//    //Solution 2
//    int steps = X;
//    boolean[] bitmap = new boolean[steps+1];
//        for(int i = 0; i < A.length; i++){
//        if(!bitmap[A[i]]){
//        bitmap[A[i]] = true;
//        steps--;
//        if(steps == 0) return i;
//        }
//        }
//        return -1;