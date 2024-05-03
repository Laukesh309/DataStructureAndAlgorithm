package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class longestCommonSubsequence {

    public static int findLangestCommonSubsequece(int arr[], int currentIndex, int currentLargest, int result) {

        if (currentIndex < 0) {
            return result;
        }
        if (currentLargest >= arr[currentIndex]) {
            return findLangestCommonSubsequece(arr, currentIndex - 1, arr[currentIndex], result + 1);
        } else {
            int excludeResult = findLangestCommonSubsequece(arr, currentIndex, arr[currentIndex], 0);
            int includeResult = findLangestCommonSubsequece(arr, currentIndex - 1, currentLargest, result);
            result = Math.max(includeResult, excludeResult);
            return result;
        }

    }

    public static int lcs(int arr[], int arr2[]) {
        int n = arr.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][arr2.length];
    }

    public static int findMaximumSequence(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        int arr2[] = new int[hs.size()];
        int i = 0;
        for (int item : hs) {
            arr2[i] = item;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr, arr2);

    }

    public static void main(String[] args) {
        // int arr[] = { 50, 3, 10, 7, 40, 80 };
        int arr[] = { 3, 10, 2 };
        int currentLargest = arr[arr.length - 1];
        System.out.println(findLangestCommonSubsequece(arr, arr.length - 1, currentLargest, 0));
        System.out.println(findMaximumSequence(arr));

    }
}
