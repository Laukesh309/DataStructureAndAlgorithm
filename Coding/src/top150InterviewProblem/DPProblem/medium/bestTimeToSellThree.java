package top150InterviewProblem.DPProblem.medium;

public class bestTimeToSellThree {

    public static int findMaxDynamic(int price[], int index, int buy, int cap, int dp[][][]) {
        if (cap < 0 || index >= price.length) {
            return 0;
        }
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }
        if (buy == 1) {
            dp[index][buy][cap] = Math.max(findMaxDynamic(price, index + 1, 0, cap, dp) - price[index],
                    findMaxDynamic(price, index + 1, 1, cap, dp));
        } else {
            dp[index][buy][cap] = Math.max(price[index] + findMaxDynamic(price, index + 1, 1, cap - 1, dp),
                    findMaxDynamic(price, index + 1, 0, cap, dp));
        }
        return dp[index][buy][cap];
    }

    public static int findMaxDynamicKCap(int price[], int index, int buy, int cap, int dp[][][]) {
        if (cap < 0 || index >= price.length) {
            return 0;
        }
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }
        if (buy == 1) {
            dp[index][buy][cap] = Math.max(findMaxDynamic(price, index + 1, 0, cap, dp) - price[index],
                    findMaxDynamic(price, index + 1, 1, cap, dp));
        } else {
            dp[index][buy][cap] = Math.max(price[index] + findMaxDynamic(price, index + 1, 1, cap - 1, dp),
                    findMaxDynamic(price, index + 1, 0, cap, dp));
        }
        return dp[index][buy][cap];
    }

    // public static int findMax(int price[]) {
    // int dp[][][] = new int[price.length][2][2];
    // dp[price.length - 1][1][1] = 0;
    // dp[price.length - 1][1][0] = 0;
    // dp[price.length - 1][0][1] = price[price.length - 1];
    // dp[price.length - 1][0][0] = price[price.length - 1];
    // for (int row = price.length - 2; row >= 0; row--) {
    // for (int column = 1; column >= 0; column--) {
    // if (column == 1) {
    // dp[row][column][1] = Math.max(dp[row + 1][0][0] - price[row], dp[row +
    // 1][1][1]);
    // dp[row][column][0] = Math.max(dp[xrow + 1][0][0] - price[row], dp[row +
    // 1][1][0]);
    // } else {
    // dp[row][column][1] = Math.max(price[row] + dp[row + 1][1][0], dp[row +
    // 1][0][1]);
    // dp[row][column][0] = Math.max(price[row], dp[row + 1][0][0]);
    // }
    // }
    // }
    // return dp[0][1][1];

    // }

    public static void main(String[] args) {
        int price[] = { 2, 4, 1 };
        // System.out.println(findMax(price));
        int cap = 2;
        int dp[][][] = new int[price.length][2][cap];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < cap; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(findMaxDynamic(price, 0, 1, 1, dp));
        System.out.println(findMaxDynamicKCap(price, 0, 1, cap - 1, dp));
    }

}
