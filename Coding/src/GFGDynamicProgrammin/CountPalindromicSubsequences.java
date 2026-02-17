package GFGDynamicProgrammin;

import java.util.Arrays;

public class CountPalindromicSubsequences {

    public static int findTotalElement(String s, int startIndex, int endIndex, int totalLength, int dp[][][]) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (startIndex == endIndex) {
            if (totalLength - 1 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[startIndex][endIndex][totalLength] != -1) {
            return dp[startIndex][endIndex][totalLength];
        }
        dp[startIndex][endIndex][totalLength] = +findTotalElement(s, startIndex + 1, endIndex, totalLength, dp)
                + findTotalElement(s, startIndex, endIndex - 1, totalLength, dp)
                - findTotalElement(s, startIndex + 1, endIndex - 1, totalLength, dp);
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            dp[startIndex][endIndex][totalLength] = dp[startIndex][endIndex][totalLength]
                    + findTotalElement(s, startIndex + 1, endIndex - 1, totalLength - 2, dp);
        }
        return dp[startIndex][endIndex][totalLength];
    }

    public static void main(String[] args) {
        String s = "0000000";
        int dp[][][] = new int[s.length()][s.length()][6];
        for (int[][] row : dp) {
            for (int[] secondRow : row) {
                Arrays.fill(secondRow, -1);

            }

        }
        System.out.println(findTotalElement(s, 0, s.length() - 1, 5, dp));

    }

}
