package DynamicProgramming;

public class zeroKnapSackTabulation {

    public static int maximumProfit(int value[], int weight[], int totalWeigh) {
        int n = value.length;
        int dp[][] = new int[n + 1][totalWeigh + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalWeigh; j++) {
                int currentWight = weight[i - 1];
                if (currentWight <= j) {
                    int includeProfit = value[i - 1] + dp[i - 1][j - currentWight];
                    int excludeWight = dp[i - 1][j];
                    dp[i][j] = Math.max(includeProfit, excludeWight);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][totalWeigh];
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int totalWeight = 7;
        System.out.println(maximumProfit(value, weight, totalWeight));
    }

}
