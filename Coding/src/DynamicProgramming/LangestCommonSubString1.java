package DynamicProgramming;

public class LangestCommonSubString1 {

    public static int findMaxCommonSubString(String str1, String str2, int currrentResult) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return currrentResult;
        }
        if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
            return findMaxCommonSubString(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1),
                    currrentResult + 1);
        } else {
            int leftMaxValue = findMaxCommonSubString(str1, str2.substring(0, str2.length() - 1), 0);
            int rightMaxValue = findMaxCommonSubString(str1.substring(0, str1.length() - 1), str2, 0);
            return Math.max(currrentResult, Math.max(leftMaxValue, rightMaxValue));
        }

    }

    public static int findMaxCommonSubStringTabulisation(String str1, String str2) {
        int row = str1.length();
        int column = str2.length();
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        int maxValue = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxValue = Math.max(maxValue, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.println(findMaxCommonSubString(str1, str2, 0));
        System.out.println(findMaxCommonSubStringTabulisation(str1, str2));
    }

}
