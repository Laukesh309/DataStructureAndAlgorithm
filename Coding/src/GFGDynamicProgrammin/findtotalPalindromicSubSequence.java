package GFGDynamicProgrammin;

import java.util.Arrays;

public class findtotalPalindromicSubSequence {

    public static int findLangest(String str, int startIndex, int endIndex, int dp[][]) {
        if (startIndex == endIndex) {
            return 1;
        }
        if (startIndex > endIndex) {
            return 0;
        }
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        if (str.charAt(startIndex) == str.charAt(endIndex)) {
            dp[startIndex][endIndex] = 2 + findLangest(str, startIndex + 1, endIndex - 1, dp);
        } else {
            dp[startIndex][endIndex] = Math.max(findLangest(str, startIndex + 1, endIndex, dp),
                    findLangest(str, startIndex, endIndex - 1, dp));
        }
        return dp[startIndex][endIndex];
    }

    public static int findLargestSubSequence(String str) {

        int dp[][] = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        for (int row = str.length() - 2; row >= 0; row--) {
            for (int col = row + 1; col < str.length(); col++) {
                if (str.charAt(row) == str.charAt(col)) {
                    dp[row][col] = 2 + dp[row + 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[0][str.length() - 1];

    }

    public static void main(String[] args) {
        String str = "bbbab";
        int dp[][] = new int[str.length()][str.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(findLangest(str, 0, str.length() - 1, dp));

    }

}
