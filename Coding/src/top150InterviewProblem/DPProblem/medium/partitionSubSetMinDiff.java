package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.Collections;

public class partitionSubSetMinDiff {

    public static int minDiff(int arr[], int currentIndex, int currentSubSetSum, int totalSum) {
        if (currentIndex >= arr.length) {
            return Math.abs(totalSum - 2 * currentSubSetSum);
        }
        int take = minDiff(arr, currentIndex + 1, currentSubSetSum + arr[currentIndex], totalSum);
        int notTake = minDiff(arr, currentIndex + 1, currentSubSetSum, totalSum);
        return Math.min(take, notTake);

    }

    public static void printArray(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMinDifference(int arr[], int totalSum) {

        boolean dp[][] = new boolean[arr.length + 1][totalSum + 1];
        for (int row = 0; row <= arr.length; row++) {
            for (int column = 0; column <= totalSum; column++) {
                if (column == 0) {
                    dp[row][column] = true;
                }
            }
        }
        int minDiff = totalSum;
        for (int row = 1; row <= arr.length; row++) {
            for (int column = 1; column <= totalSum; column++) {
                if (column - arr[row - 1] >= 0) {
                    dp[row][column] = dp[row - 1][column - arr[row - 1]] || dp[row - 1][column];
                } else {
                    dp[row][column] = dp[row - 1][column];
                }
                if (dp[row][column]) {
                    System.out.println(minDiff);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * column));
                }
            }
        }
        printArray(dp);
        return minDiff;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };
        int totalsum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalsum += arr[i];
        }
        // System.out.println(minDiff(arr, 0, 0, totalsum));
        System.out.println(findMinDifference(arr, totalsum));

    }

}
