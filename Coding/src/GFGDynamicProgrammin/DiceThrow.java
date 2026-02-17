package GFGDynamicProgrammin;

public class DiceThrow {

    public static int findTotalSum(int m, int n, int sum) {
        int total = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (i + j == sum) {
                    total++;
                }
            }
        }
        return total;
    }

    public static int findTotalNoOfWays(int m, int n, int x, int dp[][]) {

        if (n == 0 && x == 0) {
            return 1;
        }
        if (n == 0 || x <= 0) {
            return 0;
        }
        if (dp[n][x] != -1) {
            return dp[n][x];
        }
        int total = 0;
        for (int i = 1; i <= m; i++) {
            total = total + findTotalNoOfWays(m, n - 1, x - i, dp);
        }
        dp[n][x] = total;
        return dp[n][x];
    }

    public static int findTotalWays(int m, int n, int x) {
        int dp[][] = new int[n + 1][x + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m; k++) {
                    if (j - k >= 0) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j - k];
                    }
                }
            }
        }
        System.out.println(dp[n][x]);
        return dp[n][x];
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 3;
        int x = 12;
        int dp[][] = new int[n + 1][x + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < x + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findTotalNoOfWays(m, n, x, dp));
        System.out.println(findTotalWays(m, n, x));
    }

}
