package DynamicProgramming;

public class unboundedKnapsack {

    public static int findTotalProfit(int value[], int weight[], int totalWight) {
        int n = value.length;
        int dp[][] = new int[n + 1][totalWight + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= totalWight; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalWight; j++) {
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(value[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totalWight];
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int totalWeight = 7;
        System.out.println(findTotalProfit(value, weight, totalWeight));
    }

}
