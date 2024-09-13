package Sheet.String.Medium;

public class LongestCommonPelindrome {

    public static boolean findPelindromicString(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public static String printAllPelindromicSubString(String str) {
        String max = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String currentString = str.substring(i, j);
                if (findPelindromicString(currentString)) {
                    max = max.length() > currentString.length() ? max : currentString;
                }
            }
        }
        return max;
    }

    public static void printDp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String findPelindromicSubStringByDynamicMethod(String str) {
        boolean dp[][] = new boolean[str.length()][str.length()];
        String result = "";
        for (int row = 0; row < str.length(); row++) {
            for (int column = 0; column < str.length(); column++) {
                if (row >= column) {
                    dp[row][column] = true;
                    if (row == column) {
                        result = str.substring(row, column + 1);
                    }

                } else {
                    dp[row][column] = false;
                }
            }
        }
        for (int row = str.length() - 1; row >= 0; row--) {
            for (int column = row + 1; column < str.length(); column++) {
                if (str.charAt(row) == str.charAt(column)) {
                    dp[row][column] = dp[row + 1][column - 1];
                } else {
                    dp[row][column] = false;
                }
                if (dp[row][column]) {
                    result = result.length() > str.substring(row, column + 1).length() ? result
                            : str.substring(row, column + 1);
                }

            }
        }
        return result;

    }

    public static void main(String[] args) {
        String str = "a";
        // System.out.println(printAllPelindromicSubString(str));
        System.out.println(findPelindromicSubStringByDynamicMethod(str));

    }

}
