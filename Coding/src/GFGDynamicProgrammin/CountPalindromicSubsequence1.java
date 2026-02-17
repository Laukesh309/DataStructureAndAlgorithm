package GFGDynamicProgrammin;

public class CountPalindromicSubsequence1 {

    public static int findTotalPalindromicSequence(String s, int startIndex, int endIndex, int dp[][]) {
        if (startIndex == endIndex) {
            return 1;
        }
        if (startIndex > endIndex) {
            return 0;
        }
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            dp[startIndex][endIndex] = 1 + findTotalPalindromicSequence(s, startIndex + 2, endIndex, dp)
                    + findTotalPalindromicSequence(s, startIndex, endIndex - 2, dp);
        } else {
            dp[startIndex][endIndex] = findTotalPalindromicSequence(s, startIndex + 1, endIndex, dp)
                    + findTotalPalindromicSequence(s, startIndex, endIndex - 1, dp)
                    - findTotalPalindromicSequence(s, startIndex + 1, endIndex - 1, dp);
        }
        return dp[startIndex][endIndex];
    }

    public static void main(String[] args) {
        String s = "abcd";
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findTotalPalindromicSequence(s, 0, s.length() - 1, dp));
    }

}
