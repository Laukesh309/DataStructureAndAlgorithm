package GFGDynamicProgrammin;

public class DiceThrow1 {

    public static int findTotalNoOfWays(int m, int n, int total, int dp[][]) {
        if (n == 0 && total == 0) {
            return 1;
        }
        if (n < 0 || total <= 0) {
            return 0;
        }
        if (dp[n][total] != -1) {
            return dp[n][total];
        }
        int max = 0;
        for (int i = 1; i <= m; i++) {
            max = max + findTotalNoOfWays(m, n - 1, total - i, dp);
        }
        dp[n][total] = max;
        return dp[n][total];
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 3;
        int x = 12;
        int dp[][] = new int[n + 1][x + 1];
        for (int row = 0; row < n + 1; row++) {
            for (int col = 0; col < x + 1; col++) {
                dp[row][col] = -1;
            }
        }
        System.out.println(findTotalNoOfWays(m, n, x, dp));

    }

}
