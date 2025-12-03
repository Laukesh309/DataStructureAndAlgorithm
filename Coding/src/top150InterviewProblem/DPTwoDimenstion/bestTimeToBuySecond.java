package top150InterviewProblem.DPTwoDimenstion;

public class bestTimeToBuySecond {

    public static int maxProfit(int price[], int currentIndex, int buy, int dp[][]) {
        if (currentIndex >= price.length) {
            return 0;
        }

        if (dp[currentIndex][buy] != -1) {
            return dp[currentIndex][buy];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(maxProfit(price, currentIndex + 1, 0, dp) - price[currentIndex],
                    maxProfit(price, currentIndex + 1, 1, dp));
        } else {
            profit = Math.max(price[currentIndex] + maxProfit(price, currentIndex + 1, 1, dp),
                    maxProfit(price, currentIndex + 1, 0, dp));
        }
        dp[currentIndex][buy] = profit;
        return dp[currentIndex][buy];
    }

    public static void printDp(int prices[]) {
        for (int i : prices) {
            System.out.print(i + " -->");
        }
    }

    public static int findMax(int price[]) {
        int dp[] = new int[price.length + 1];
        dp[price.length] = 0;
        for (int i = price.length - 1; i >= 0; i--) {
            int currentbuy = price[i];
            int maxProfit = 0;
            for (int j = i; j < price.length; j++) {
                int sell = price[j];
                if (i == 0) {
                    System.out.print(sell - currentbuy + "  ");
                }
                maxProfit = Math.max(maxProfit, sell - currentbuy + dp[j + 1]);
            }
            dp[i] = maxProfit;
        }
        // printDp(dp);
        System.out.println(dp[0]);
        return dp[0];
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(maxProfit(prices, 0, 1, dp));
        System.out.println(findMax(prices));
    }

}
