package top150InterviewProblem.Array;

public class BuyAndSellProblem {

    public static int findMaxProfit(int price[]) {
        int dp[] = new int[price.length];
        for (int i = price.length - 1; i >= 0; i--) {
            int currentBuyPrice = price[i];
            int currentProfit = 0;
            for (int j = i; j < price.length; j++) {
                if (j + 1 < price.length) {
                    currentProfit = Math.max((price[j] - currentBuyPrice) + dp[j + 1], currentProfit);
                } else {
                    currentProfit = Math.max((price[j] - currentBuyPrice), currentProfit);
                }
            }
            dp[i] = currentProfit;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int price[] = { 1, 2, 3, 4, 5 };
        System.out.println(findMaxProfit(price));

    }

}
