package top150InterviewProblem.DPOneDimansion;

public class climbingStair {

    public static int findTotalNumberOfWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return findTotalNumberOfWays(n - 1) + findTotalNumberOfWays(n - 2);
    }

    public static int findDynamicWays(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(findTotalNumberOfWays(n));
        System.out.println(findDynamicWays(n));
    }

}
