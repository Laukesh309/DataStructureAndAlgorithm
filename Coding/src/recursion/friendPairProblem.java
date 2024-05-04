package recursion;

public class friendPairProblem {

    public static int findTotalWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int single = findTotalWays(n - 1);
        int mix = (n - 1) * findTotalWays(n - 2);
        return single + mix;
    }

    public static int findTotalWaysByTabulisation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int totalFriend = 3;
        System.out.println(findTotalWays(totalFriend));
        System.out.println(findTotalWaysByTabulisation(totalFriend));

    }

}
