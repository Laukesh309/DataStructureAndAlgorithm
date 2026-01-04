package top150InterviewProblem.DPProblem.medium;

public class buyandsellsecond {

    public static int findMaximum(int prices[], int currentIndex, int buy, int transaction, int dp[][][]) {
        if (transaction < 0 || currentIndex >= prices.length) {
            return 0;
        }
        if (dp[currentIndex][buy][transaction] != -1) {
            return dp[currentIndex][buy][transaction];
        }

        if (buy == 0) {
            int take = findMaximum(prices, currentIndex + 1, 1, transaction, dp) - prices[currentIndex];
            int notTake = findMaximum(prices, currentIndex + 1, 0, transaction, dp);
            dp[currentIndex][buy][transaction] = Math.max(take, notTake);
            return dp[currentIndex][buy][transaction];
        } else {
            int sell = prices[currentIndex] + findMaximum(prices, currentIndex + 1, 0, transaction - 1, dp);
            int notsell = findMaximum(prices, currentIndex + 1, 1, transaction, dp);
            dp[currentIndex][buy][transaction] = Math.max(sell, notsell);
            return dp[currentIndex][buy][transaction];
        }
    }

    public static void main(String[] args) {
        int prices[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int k = 2;
        int dp[][][] = new int[prices.length][2][k];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(findMaximum(prices, 0, 0, k, dp));

    }

}
