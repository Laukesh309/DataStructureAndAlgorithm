package GreedyAlgorithm;

import java.util.Arrays;

public class minimumSum {
    public static void main(String[] args) {
        int arrA[] = { 4, 1, 8, 7 };
        int arrB[] = { 2, 3, 6, 5 };
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int totalSum = 0;
        for (int i = 0; i < arrA.length; i++) {
            // totalSum = Math.max(arrA[i], arrB[i]) - Math.min(arrA[i], arrB[i]) +
            // totalSum;
            totalSum = Math.abs(arrA[i] - arrB[i]) + totalSum;

        }
        System.out.println("totalSum => " + totalSum);
    }

}
