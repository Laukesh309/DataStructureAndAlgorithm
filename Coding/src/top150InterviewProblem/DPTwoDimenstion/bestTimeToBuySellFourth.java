package top150InterviewProblem.DPTwoDimenstion;

public class bestTimeToBuySellFourth {

    public static int findMax(int price[], int currentIndex, int buy, int k) {
        if (k < 0 || currentIndex >= price.length) {
            return 0;
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(findMax(price, currentIndex + 1, 0, k) - price[currentIndex],
                    findMax(price, currentIndex + 1, 1, k));
        } else {
            profit = Math.max(findMax(price, currentIndex + 1, 1, k - 1) + price[currentIndex],
                    findMax(price, currentIndex + 1, 0, k));
        }
        return profit;

    }

    public static int findMaxDynamic(int price[], int currentIndex, int buy, int k, int dp[][][]) {
        if (k < 0 || currentIndex >= price.length) {
            return 0;
        }
        if (dp[currentIndex][buy][k] != -1) {
            return dp[currentIndex][buy][k];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(findMaxDynamic(price, currentIndex + 1, 0, k, dp) - price[currentIndex],
                    findMaxDynamic(price, currentIndex + 1, buy, k, dp));
        } else {
            profit = Math.max(findMaxDynamic(price, currentIndex + 1, 1, k - 1, dp) + price[currentIndex],
                    findMaxDynamic(price, currentIndex + 1, buy, k, dp));
        }
        dp[currentIndex][buy][k] = profit;
        return dp[currentIndex][buy][k];
    }

    public static void main(String[] args) {
        int price[] = { 2, 4, 1 };
        int k = 2;
        System.out.println(findMax(price, 0, 1, k - 1));
        int dp[][][] = new int[price.length][2][k];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int c = 0; c < k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }
        System.out.println(findMaxDynamic(price, 0, 1, k - 1, dp));
    }

}
