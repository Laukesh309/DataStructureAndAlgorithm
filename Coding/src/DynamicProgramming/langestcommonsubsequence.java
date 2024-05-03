package DynamicProgramming;

public class langestcommonsubsequence {

    public static int findLongestCommonSubSequence(String str1, String str2, int firstCurrentIndex,
            int secondCurrentIndex, int dp[][]) {
        if (firstCurrentIndex < 0 || secondCurrentIndex < 0) {
            return 0;
        }
        if (dp[firstCurrentIndex][secondCurrentIndex] != 0) {
            return dp[firstCurrentIndex][secondCurrentIndex];
        }
        if (str1.charAt(firstCurrentIndex) == str2.charAt(secondCurrentIndex)) {
            dp[firstCurrentIndex][secondCurrentIndex] = 1
                    + findLongestCommonSubSequence(str1, str2, firstCurrentIndex - 1, secondCurrentIndex - 1, dp);
        } else {
            dp[firstCurrentIndex][secondCurrentIndex] = Math.max(
                    findLongestCommonSubSequence(str1, str2, firstCurrentIndex - 1, secondCurrentIndex, dp),
                    findLongestCommonSubSequence(str1, str2, firstCurrentIndex, secondCurrentIndex - 1, dp));
        }
        return dp[firstCurrentIndex][secondCurrentIndex];
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }

    public static int findMaxByTabulisation(String str1, String str2) {
        int row = str1.length();
        int column = str2.length();
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= column; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        printDp1(dp);
        return dp[row][column];

    }

    public static void printDp1(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // String str1 = "abcde";
        // String str2 = "ace";
        String str1 = "abcdge";
        String str2 = "abedg";
        // int dp[][] = new int[str1.length()][str2.length()];
        // System.out.println(findLongestCommonSubSequence(str1, str2, str1.length() -
        // 1, str2.length() - 1, dp));
        System.err.println(findMaxByTabulisation(str1, str2));
        // printDp1(dp);
    }

}
