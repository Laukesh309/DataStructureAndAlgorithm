package DynamicProgramming;

public class climbingStair1 {

    public static int findNoOfWaysOfStairRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return findNoOfStair(n - 1) + findNoOfStair(n - 2);
    }

    public static int findNoOfWaysStairByMemoisation(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = findNoOfWaysStairByMemoisation(n - 1, dp) + findNoOfWaysStairByMemoisation(n - 2, dp);
        return dp[n];
    }

    public static int findNoOfStair(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n + 1];
        System.out.println(findNoOfWaysOfStairRecursion(n));
        System.out.println(findNoOfStair(n));
        System.out.println(findNoOfWaysStairByMemoisation(n, dp));
    }

}
