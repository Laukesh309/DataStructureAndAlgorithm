package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LangestCommonSubString {

    public static void findMaxNumber(String str1, String str2, ArrayList<Integer> arr, int result,
            int firstCurrentIndex,
            int secondCurrentIndex, String resultStr) {
        if (firstCurrentIndex < 0 || secondCurrentIndex < 0) {
            // System.out.println(resultStr);
            arr.add(result);
            return;
        }
        if (str1.charAt(firstCurrentIndex) == str2.charAt(secondCurrentIndex)) {
            resultStr += str1.charAt(firstCurrentIndex);
            findMaxNumber(str1, str2, arr, result + 1, firstCurrentIndex - 1, secondCurrentIndex - 1, resultStr);
        } else {
            arr.add(result);
            findMaxNumber(str1, str2, arr, 0, firstCurrentIndex - 1, secondCurrentIndex, "");
            findMaxNumber(str1, str2, arr, 0, firstCurrentIndex, secondCurrentIndex - 1, "");
        }
    }

    public static int findMaximumByTabulisation(String str1, String str2) {
        int row = str1.length();
        int column = str2.length();
        int dp[][] = new int[row + 1][column + 1];
        int ans = 0;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        // String str1 = "ABCDGH";
        // String str2 = "ACDGHR";
        String resultStr = "";
        ArrayList<Integer> arr = new ArrayList<>();
        int result = 0;

        findMaxNumber(str1, str2, arr, result, str1.length() - 1, str2.length() - 1, resultStr);
        System.out.println(Collections.max(arr));
        System.out.println(findMaximumByTabulisation(str1, str2));

    }

}
