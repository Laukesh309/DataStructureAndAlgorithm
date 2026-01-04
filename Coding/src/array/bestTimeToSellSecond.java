package array;

public class bestTimeToSellSecond {

    public static int findMaxProfit(int prices[], int currentIndex, int buy, int dp[][]) {
        if (currentIndex >= prices.length) {
            return 0;
        }
        int profit = 0;
        if (dp[currentIndex][buy] != -1) {
            return dp[currentIndex][buy];
        }
        if (buy == 1) {
            profit = prices[currentIndex] + findMaxProfit(prices, currentIndex + 1, 0, dp);
        } else {
            profit = findMaxProfit(prices, currentIndex + 1, 1, dp) - prices[currentIndex];
        }
        return Math.max(profit, findMaxProfit(prices, currentIndex + 1, buy, dp));
    }

    public static void main(String[] args) {
        int prices[] = { 1, 5, 7 };
        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findMaxProfit(prices, 0, 0, dp));

    }

}
