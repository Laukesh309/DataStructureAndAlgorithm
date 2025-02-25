package top150InterviewProblem.DPProblem.medium;

import java.util.Arrays;
import java.util.Collections;

public class longestIncreasingSubSequence {

    public static int findLargestCommonSubSequence(int arr1[], int arr2[]) {
        int dp[][] = new int[arr1.length + 1][arr2.length + 1];
        for (int row = 0; row <= arr1.length; row++) {
            for (int column = 0; column <= arr2.length; column++) {
                if (row == 0 || column == 0) {
                    dp[row][column] = 0;
                }
            }
        }
        for (int row = 1; row <= arr1.length; row++) {
            for (int column = 1; column <= arr2.length; column++) {
                if (arr1[row - 1] == arr2[column - 1]) {
                    dp[row][column] = 1 + dp[row - 1][column - 1];
                } else {
                    dp[row][column] = Math.max(dp[row - 1][column], dp[row][column - 1]);
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }

    public static void main(String[] args) {
        int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int arr2[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2);
        System.out.println(findLargestCommonSubSequence(arr, arr2));

    }

}
