package top150InterviewProblem.DPProblem.medium;

import java.util.Arrays;

public class coinchangeDynamic {

    public static void printDp(int arr[][]) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[0].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static int findMaxValue(int arr[], int amount) {
        int dp[][] = new int[arr.length + 1][amount + 1];
        for (int row = 0; row <= arr.length; row++) {
            for (int column = 0; column <= amount; column++) {
                if (row == 0 && column > 0) {
                    dp[row][column] = Integer.MAX_VALUE;
                } else {
                    dp[row][column] = 0;
                }

            }
        }

        for (int row = 1; row <= arr.length; row++) {
            for (int column = 1; column <= amount; column++) {
                if (column - arr[row - 1] >= 0) {
                    if (dp[row][column - arr[row - 1]] != Integer.MAX_VALUE) {
                        dp[row][column] = Math.min(1 + dp[row][column - arr[row - 1]], dp[row - 1][column]);
                    } else {
                        dp[row][column] = dp[row - 1][column];
                    }
                } else {
                    dp[row][column] = dp[row - 1][column];
                }
            }
        }
        return dp[arr.length][amount] == Integer.MAX_VALUE ? -1 : dp[arr.length][amount];
    }

    public static void main(String[] args) {
        int arr[] = { 1 };
        int amount = 0;
        Arrays.sort(arr);
        System.out.println(findMaxValue(arr, amount));
    }

}
