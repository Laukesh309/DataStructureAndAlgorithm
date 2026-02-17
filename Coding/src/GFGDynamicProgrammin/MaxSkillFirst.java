package GFGDynamicProgrammin;

import java.util.ArrayList;

public class MaxSkillFirst {

    public static int findTotalElement(int arr[], int startIndex, int endIndex, int dp[][]) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        int totalMax = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            int currentRating = arr[startIndex - 1] * arr[i] * arr[endIndex + 1];
            int leftTotal = findTotalElement(arr, startIndex, i - 1, dp);
            int rightTotal = findTotalElement(arr, i + 1, endIndex, dp);
            totalMax = Math.max(totalMax, currentRating + leftTotal + rightTotal);
        }
        dp[startIndex][endIndex] = totalMax;
        return dp[startIndex][endIndex];

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 5, 8 };
        int newArray[] = new int[arr.length + 2];
        newArray[0] = 1;
        int dp[][] = new int[arr.length + 1][arr.length + 1];
        newArray[arr.length + 1] = 1;
        for (int i = 1; i <= arr.length; i++) {
            newArray[i] = arr[i - 1];
        }
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < arr.length + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findTotalElement(newArray, 1, arr.length, dp));
    }

}
