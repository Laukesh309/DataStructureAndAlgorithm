package DynamicProgramming;

public class TargetSumSubSetTabulisation {

    public static void printDp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isExist(int arr[], int totalsum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][totalsum + 1];
        for (int j = 0; j <= totalsum; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalsum; j++) {
                if (arr[i - 1] <= j) {
                    boolean include = dp[i - 1][j - arr[i - 1]];
                    boolean exclude = dp[i - 1][j];
                    dp[i][j] = exclude || include;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDp(dp);
        return dp[n][totalsum];
    }

    public static void main(String[] args) {
        int number[] = { 4, 2, 7, 1, 3 };
        int targetSum = 10;
        System.out.println(isExist(number, targetSum));

    }

}
