package top150InterviewProblem.DPProblem.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class minimumCastToCutString {

    public static int findMinMumCut(int start, int last, int arr[], int dp[][]) {
        if (start > last) {
            return 0;
        }
        if (dp[start][last] != -1) {
            return dp[start][last];
        }
        int totalCast = Integer.MAX_VALUE;
        for (int i = start; i <= last; i++) {
            int currentCut = arr[last + 1] - arr[start - 1];
            int leftValue = findMinMumCut(start, i - 1, arr, dp);
            int rightValue = findMinMumCut(i + 1, last, arr, dp);
            totalCast = Math.min(totalCast, currentCut + leftValue + rightValue);
        }

        dp[start][last] = totalCast;
        return dp[start][last];

    }

    public static void main(String[] args) {
        int n = 7;
        int cuts[] = { 1, 3, 4, 5 };
        int newCuts[] = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        for (int i = 1; i <= cuts.length; i++) {
            newCuts[i] = cuts[i - 1];
        }
        Arrays.sort(newCuts);
        int dp[][] = new int[newCuts.length][newCuts.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findMinMumCut(1, newCuts.length - 2, newCuts, dp));
    }

}
