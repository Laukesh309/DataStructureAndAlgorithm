package DynamicProgramming;

public class EditStringR1 {

    public static int findMinimumOperation(String str1, String str2) {
        if (str1.isEmpty()) {
            return str2.length();
        }
        if (str2.isEmpty()) {
            return str1.length();
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            return findMinimumOperation(str1.substring(1), str2.substring(1));
        } else {
            int insert = 1 + findMinimumOperation(str1.substring(1), str2);
            int delete = 1 + findMinimumOperation(str1, str2.substring(1));
            int replace = 1 + findMinimumOperation(str1.substring(1), str2.substring(1));
            return Math.min(Math.min(insert, delete), replace);
        }
    }

    public static int findMinimumOperationTabulisation(String str1, String str2) {
        int row = str1.length();
        int column = str2.length();
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0) {
                        dp[i][j] = j;
                    }
                    if (j == 0) {
                        dp[i][j] = i;
                    }
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    int delete = 1 + dp[i][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(findMinimumOperation(str1, str2));
        System.out.println(findMinimumOperationTabulisation(str1, str2));

    }

}
