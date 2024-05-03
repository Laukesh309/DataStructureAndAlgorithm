package DynamicProgramming;

public class LangestSubSequence1 {

    public static int findLangestCommonSubSequenceRecursion(String str1, String str2, int firstCurrentIndex,
            int secondCurrentIndex) {
        if (firstCurrentIndex >= str1.length() || secondCurrentIndex >= str2.length()) {
            return 0;
        }
        if (str1.charAt(firstCurrentIndex) == str2.charAt(secondCurrentIndex)) {
            return 1 + findLangestCommonSubSequenceRecursion(str1, str2, firstCurrentIndex + 1, secondCurrentIndex + 1);
        } else {
            int firstValue = findLangestCommonSubSequenceRecursion(str1, str2, firstCurrentIndex + 1,
                    secondCurrentIndex);
            int secondValue = findLangestCommonSubSequenceRecursion(str1, str2, firstCurrentIndex,
                    secondCurrentIndex + 1);
            return Math.max(firstValue, secondValue);
        }
    }

    public static int findMaxSubSequenceByTabulisation(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int dp[][] = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "acde";
        System.out.println(findLangestCommonSubSequenceRecursion(str1, str2, 0, 0));
        System.out.println(findMaxSubSequenceByTabulisation(str1, str2));
    }

}
