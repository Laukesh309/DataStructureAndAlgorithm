package DynamicProgramming;

public class LCSR1 {

    public static int findLangestSubSequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            return 1 + findLangestSubSequence(str1.substring(1), str2.substring(1));
        }
        int firstValue = findLangestSubSequence(str1.substring(1), str2);
        int secondValue = findLangestSubSequence(str1, str2.substring(1));
        return Math.max(firstValue, secondValue);
    }

    public static int findLangestSubSequenceByTabulisation(String str1, String str2) {
        int row = str1.length();
        int column = str2.length();
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                dp[i][j] = 0;

            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int includedValue = dp[i][j - 1];
                    int excludedValue = dp[i - 1][j];
                    dp[i][j] = Math.max(includedValue, excludedValue);
                }
            }
        }

        return dp[row][column];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        // String str1 = "abcdge";
        // String str2 = "abedg";
        System.out.println(findLangestSubSequence(str1, str2));
        System.out.println(findLangestSubSequenceByTabulisation(str1, str2));
    }

}
