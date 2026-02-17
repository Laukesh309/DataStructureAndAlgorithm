package GFGDynamicProgrammin;

public class LangestCommanPalindromicSubSequence {
    public static int findMaximum(String s, int startIndex, int endIndex, int dp[][], String result) {
        if (startIndex == endIndex) {
            System.out.println(result + s.charAt(endIndex));
            return 1;
        }
        if (startIndex > endIndex) {
            System.out.println(result + s.charAt(endIndex));
            return 0;
        }
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        int taken = 0;
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            taken = 2 + findMaximum(s, startIndex + 1, endIndex - 1, dp,
                    result + s.charAt(startIndex) + s.charAt(endIndex));
        }
        int left = findMaximum(s, startIndex, endIndex - 1, dp, result);
        int right = findMaximum(s, startIndex + 1, endIndex, dp, result);
        dp[startIndex][endIndex] = Math.max(taken, Math.max(right, left));
        return dp[startIndex][endIndex];

    }

    public static void findPalindromicSequence(String s) {
        System.out.println("testing--9");
        String dp[][] = new String[s.length()][s.length()];
        for (int row = 0; row < s.length(); row++) {
            for (int col = 0; col < s.length(); col++) {
                dp[row][col] = "";
            }
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = s.charAt(i) + "";
        }
        for (int row = s.length() - 2; row >= 0; row--) {
            for (int col = row + 1; col < s.length(); col++) {
                System.out.println(row + " " + col);
                if (s.charAt(row) == s.charAt(col)) {
                    dp[row][col] = s.charAt(row) + dp[row + 1][col - 1] + s.charAt(row);
                } else {
                    if (dp[row + 1][col].length() > dp[row][col - 1].length()) {
                        dp[row][col] = dp[row + 1][col] + "";
                    } else {
                        dp[row][col] = dp[row][col - 1] + "";
                    }
                }
            }
        }
        System.out.println("testing2");
        System.out.println(dp[0][s.length() - 1]);
    }

    public static int findMaximumPalindromicSubSequence(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "bbabcbcab";
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        // System.out.println(findMaximum(s, 0, s.length() - 1, dp, ""));
        // System.out.println(findMaximumPalindromicSubSequence(s));
        findPalindromicSequence(s);
    }

}
