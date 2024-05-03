package DynamicProgramming;

public class wildCardPattern {

    public static void printDp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean findPatternExit(String str1, String pattern) {
        int row = pattern.length();
        int column = str1.length();
        boolean dp[][] = new boolean[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    if (pattern.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (pattern.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(i - 1) == '*') {
                    boolean firstValue = dp[i - 1][j - 1];
                    boolean secondValue = dp[i - 1][j];
                    boolean thirdValue = dp[i][j - 1];
                    dp[i][j] = firstValue || secondValue || thirdValue;
                } else if (pattern.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        // String str1 = "aa";
        // String pattern = "*";
        // String str1 = "baaabab";
        // String pattern = "a*ab";
        String str1 = "baaabab";
        String pattern = "*****ba*****ab";
        System.out.println(findPatternExit(str1, pattern));
    }

}
