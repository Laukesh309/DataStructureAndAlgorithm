package DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class langestContinueusSubsequence {

    public static String findLangestCommonSubsequece(int arr[], int currentIndex, int currentMaxValue, int result,
            String str) {

        if (currentIndex >= arr.length) {
            return str;
        }

        if (currentMaxValue <= arr[currentIndex]) {
            return findLangestCommonSubsequece(arr, currentIndex + 1, arr[currentIndex], result + 1,
                    str + " " + arr[currentIndex]);
        } else {
            String includeMax = findLangestCommonSubsequece(arr, currentIndex + 1, currentMaxValue, result, str);
            String exludeMax = findLangestCommonSubsequece(arr, currentIndex + 1, arr[currentIndex], 1,
                    arr[currentIndex] + " ");
            // return Math.max(includeMax, exludeMax);
            return includeMax.length() >= exludeMax.length() ? includeMax : exludeMax;
        }

    }

    public static int findMaxSequenceByTabulisation(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        int arr2[] = new int[hs.size()];
        int index = 0;
        for (int item : hs) {
            arr2[index++] = item;
        }
        Arrays.sort(arr2);
        int dp[][] = new int[arr2.length + 1][arr.length + 1];
        int row = arr2.length;
        int column = arr.length;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (arr2[i - 1] == arr[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[row][column];

    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        int maxValue = Integer.MIN_VALUE;
        System.out.println(findLangestCommonSubsequece(arr, 0, maxValue, 0, ""));
        System.out.println(findMaxSequenceByTabulisation(arr));
    }

}
