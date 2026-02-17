package GFGDynamicProgrammin;

public class EditDistance {

    public static int findEditDistance(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int row = 1; row < s1.length() + 1; row++) {
            dp[row][0] = row;
        }
        for (int col = 1; col < s2.length() + 1; col++) {
            dp[0][col] = col;
        }
        for (int row = 1; row < s1.length() + 1; row++) {
            for (int col = 1; col < s2.length() + 1; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    int insert = dp[row][col - 1] + 1;
                    int delete = dp[row - 1][col] + 1;
                    int replace = dp[row - 1][col - 1] + 1;
                    dp[row][col] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "geek", s2 = "gesek";
        System.out.println(findEditDistance(s1, s2));

    }
}
