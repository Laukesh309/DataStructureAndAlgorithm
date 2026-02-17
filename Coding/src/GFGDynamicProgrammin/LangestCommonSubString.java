package GFGDynamicProgrammin;

public class LangestCommonSubString {

    public static void findLangestSubStringDynamic(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int row = 1; row < s1.length(); row++) {
            for (int col = 1; col < s2.length(); col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        int row = s1.length();
        int col = s2.length();
        String result = "";
        while (row > 0 && col > 0) {
            if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                result = s1.charAt(row - 1) + result;
                row--;
                col--;
            } else if (dp[row - 1][col] > dp[row][col - 1]) {
                row--;
            } else {
                col--;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        findLangestSubStringDynamic(s1, s2);

    }

}
