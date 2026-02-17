package GFGDynamicProgrammin;

public class LargestCommonSubSequence {

    public static int findMaxLength(String s1, String s2, int firstIndex, int secondIndex) {
        if (firstIndex >= s1.length() || secondIndex >= s2.length()) {
            return 0;
        }
        if (s1.charAt(firstIndex) == s2.charAt(secondIndex)) {
            return 1 + findMaxLength(s1, s2, firstIndex + 1, secondIndex + 1);
        }
        return Math.max(findMaxLength(s1, s2, firstIndex + 1, secondIndex),
                findMaxLength(s1, s2, firstIndex, secondIndex + 1));
    }

    public static int findMaxLengthDynamic(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int row = 0; row < dp.length; row++) {
            dp[row][0] = 0;
        }
        for (int col = 0; col < dp[0].length; col++) {
            dp[0][col] = 0;
        }
        for (int row = 1; row <= s1.length(); row++) {
            for (int col = 1; col <= s2.length(); col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "ABC", s2 = "AC";
        System.out.println(findMaxLength(s1, s2, 0, 0));
        System.out.println(findMaxLengthDynamic(s1, s2));
    }

}
