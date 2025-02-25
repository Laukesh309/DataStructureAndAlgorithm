package DynamicProgramming;

import java.util.Arrays;
import java.util.Collection;

public class MaximumIncreasingSubSequence {

    public static int findMaxIncreasingCommonSubSequence(int arr[], int currentIndex, int currentMaxValue, int result) {
        if (currentIndex < 0) {
            return result;
        }
        if (arr[currentIndex] <= currentMaxValue) {
            return findMaxIncreasingCommonSubSequence(arr, currentIndex - 1, arr[currentIndex], result + 1);
        } else {
            int includedValue = findMaxIncreasingCommonSubSequence(arr, currentIndex, arr[currentIndex], 0);
            int exludedValue = findMaxIncreasingCommonSubSequence(arr, currentIndex - 1, currentMaxValue, result);
            return Math.max(includedValue, exludedValue);
        }
    }

    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public static int findLangestCommanIncreasingTabulisation(int arr[]) {
        int row = arr.length;
        int column = arr.length;

        int arr2[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2);
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int leftValue = dp[i - 1][j];
                    int rightValue = dp[i][j - 1];
                    dp[i][j] = Math.max(leftValue, rightValue);
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {

        int arr[] = { 7, 7, 7, 7, 7, 7, 7 };
        System.out.println(findMaxIncreasingCommonSubSequence(arr, arr.length - 1, arr[arr.length - 1], 0));
        System.out.println(findLangestCommanIncreasingTabulisation(arr));

    }

}
