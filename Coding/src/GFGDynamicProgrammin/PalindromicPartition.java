package GFGDynamicProgrammin;

import TreeStriver.staticTesting;

public class PalindromicPartition {

    public static boolean checkPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;

    }

    public static int findMaxLength(String s, int startIndex, int endIndex, int dp[][]) {
        if (checkPalindrome(s, startIndex, endIndex)) {
            return 0;
        }
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        int total = Integer.MAX_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            int left = findMaxLength(s, startIndex, i, dp);
            int right = findMaxLength(s, i + 1, endIndex, dp);
            total = Math.min(total, 1 + left + right);
        }
        dp[startIndex][endIndex] = total;
        return dp[startIndex][endIndex];

    }

    public static void print(boolean isPalindrome[][]) {
        for (boolean[] bs : isPalindrome) {
            for (boolean item : bs) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static int findMinPartition(String s) {
        int dp[][] = new int[s.length()][s.length()];
        boolean isPalindrome[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 0;
            isPalindrome[i][i] = true;
        }
        for (int row = s.length() - 2; row >= 0; row--) {
            for (int col = row + 1; col < s.length(); col++) {
                if (s.charAt(row) == s.charAt(col)) {
                    if (row + 1 >= col - 1) {
                        isPalindrome[row][col] = true;
                    } else {
                        isPalindrome[row][col] = isPalindrome[row + 1][col - 1];
                    }
                }
                if (isPalindrome[row][col]) {
                    dp[row][col] = 0;
                } else {
                    int total = Integer.MAX_VALUE;
                    for (int k = row; k < col; k++) {
                        total = Math.min(total, 1 + dp[row][k] + dp[k + 1][col]);
                    }
                    dp[row][col] = total;
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "geek";
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(findMaxLength(s, 0, s.length() - 1, dp));
        findMinPartition(s);
    }

}
