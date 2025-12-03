package top150InterviewProblem.DPTwoDimenstion;

public class bestTimeToBuyThree {
    public static int findMaxProfit(int price[], int currentIndex, int buy, int cap) {
        if (cap == 0 || currentIndex >= price.length) {
            return 0;
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(findMaxProfit(price, currentIndex + 1, 0, cap) - price[currentIndex],
                    findMaxProfit(price, currentIndex + 1, 1, cap));
        } else {
            profit = Math.max(price[currentIndex] + findMaxProfit(price, currentIndex + 1, 1, cap - 1),
                    findMaxProfit(price, currentIndex + 1, 0, cap));
        }
        return profit;

    }

    public static int findMaxProfitDynamic(int price[], int currentIndex, int buy, int cap, int dp[][][]) {
        if (cap < 0 || currentIndex >= price.length) {
            return 0;
        }
        if (dp[currentIndex][buy][cap] != -1) {
            return dp[currentIndex][buy][cap];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(findMaxProfitDynamic(price, currentIndex + 1, 0, cap, dp) - price[currentIndex],
                    findMaxProfitDynamic(price, currentIndex + 1, 1, cap, dp));
        } else {
            profit = Math.max(price[currentIndex] + findMaxProfitDynamic(price, currentIndex + 1, 1, cap - 1, dp),
                    findMaxProfitDynamic(price, currentIndex + 1, 0, cap, dp));
        }
        dp[currentIndex][buy][cap] = profit;
        return dp[currentIndex][buy][cap];

    }

    public static void main(String[] args) {
        int price[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(findMaxProfit(price, 0, 1, 2));
        int dp[][][] = new int[price.length][2][2];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(findMaxProfitDynamic(price, 0, 1, 1, dp));
    }

}
