package DynamicProgramming;

public class climbingThreeStarir {

    public static int findtotalWays(int n, String result) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            System.out.println(result);
            return 1;
        }

        return findtotalWays(n - 1, n - 1 + result) + findtotalWays(n - 2, n - 2 + result)
                + findtotalWays(n - 3, n - 3 + result);
    }

    public static int findTotalWaysByTabulisation(int n, int dp[]) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;
        int result[] = new int[n + 1];
        System.out.println(findtotalWays(n, ""));
        System.out.println(findTotalWaysByTabulisation(n, result));
    }

}
