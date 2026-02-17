package GFGDynamicProgrammin;

public class shortestCommanSubSequence {

    public static int findMaximumCommonSubSequence(String s1, String s2, int firstCurrentIndex,
            int secondCurrentIndex) {
        if (firstCurrentIndex >= s1.length() || secondCurrentIndex >= s2.length()) {
            return 0;
        }
        if (s1.charAt(firstCurrentIndex) == s2.charAt(secondCurrentIndex)) {
            return 1 + findMaximumCommonSubSequence(s1, s2, firstCurrentIndex + 1, secondCurrentIndex + 1);
        }
        int firstPick = findMaximumCommonSubSequence(s1, s2, firstCurrentIndex + 1, secondCurrentIndex);
        int secondPick = findMaximumCommonSubSequence(s1, s2, firstCurrentIndex, secondCurrentIndex + 1);
        return Math.max(firstPick, secondPick);
    }

    public static int findLangestCommonSubSequence(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "geek", s2 = "eke";
        System.out.println(findMaximumCommonSubSequence(s1, s2, 0, 0));
        System.out.println(findLangestCommonSubSequence(s1, s2));
    }

}
