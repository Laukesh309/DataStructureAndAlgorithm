package DynamicProgramming;

public class zeroOneKnapSackMaxProfit {

    public static int findMaxProfit(int value[], int weight[], int totalWeight, int currentIndex) {
        if (totalWeight <= 0 || currentIndex >= weight.length) {
            return 0;
        }
        if (weight[currentIndex] <= totalWeight) {
            return Math.max(
                    value[currentIndex]
                            + findMaxProfit(value, weight, totalWeight - weight[currentIndex], currentIndex + 1),
                    findMaxProfit(value, weight, totalWeight, currentIndex + 1));
        } else {
            return findMaxProfit(value, weight, totalWeight, currentIndex + 1);
        }
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMaximumProfitTabulisation(int value[], int weight[], int totalWeight) {
        int n = value.length;
        int dp[][] = new int[n + 1][totalWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalWeight; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalWeight; j++) {
                if (weight[i - 1] <= j) {
                    int include = value[i - 1] + dp[i - 1][j - weight[i - 1]];
                    int excliude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, excliude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDp(dp);
        return dp[n][totalWeight];
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int totalWeight = 7;
        System.out.println(findMaxProfit(value, weight, totalWeight, 0));
        System.out.println(findMaximumProfitTabulisation(value, weight, totalWeight));
    }

}
