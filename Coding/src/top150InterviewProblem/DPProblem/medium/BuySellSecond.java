package top150InterviewProblem.DPProblem.medium;

public class BuySellSecond {

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int column = 0; column < 2; column++) {
                System.out.print(dp[i][column] + " ");
            }
            System.out.println();
        }
    }

    public static int findMax(int price[], int currentIndex, int buy, int dp[][]) {
        if (currentIndex >= price.length) {
            return 0;
        }

        if (dp[currentIndex][buy] != -1) {
            return dp[currentIndex][buy];
        }
        if (buy == 1) {
            dp[currentIndex][buy] = Math.max(findMax(price, currentIndex + 1, 0, dp) - price[currentIndex],
                    findMax(price, currentIndex + 1, 1, dp));
        } else {
            dp[currentIndex][buy] = Math.max(price[currentIndex] + findMax(price, currentIndex + 1, 1, dp),
                    findMax(price, currentIndex + 1, 0, dp));
        }
        return dp[currentIndex][buy];
    }

    public static int findMaxDynamic(int price[]) {
        int dp[][] = new int[price.length][2];
        dp[price.length - 1][0] = price[price.length - 1];
        dp[price.length - 1][1] = 0;
        for (int row = price.length - 2; row >= 0; row--) {
            for (int column = 1; column >= 0; column--) {
                if (column == 1) {
                    dp[row][column] = Math.max(dp[row + 1][0] - price[row], dp[row + 1][1]);
                } else {
                    dp[row][column] = Math.max(price[row] + dp[row + 1][1], 0 + dp[row + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    public static int findMaxValueCap(int price[]) {
        int cap = 3;
        int dp[][][] = new int[price.length][2][cap];
        dp[price.length - 1][0][2] = price[price.length - 1];
        dp[price.length - 1][0][1] = price[price.length - 1];
        dp[price.length - 1][0][0] = price[price.length - 1];
        for (int i = price.length - 2; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int k = cap - 1; k > 0; k--) {
                    if (j == 1) {
                        dp[i][j][k] = Math.max(-price[i] + dp[i + 1][0][k], dp[i + 1][j][k]);

                    } else {
                        dp[i][j][k] = Math.max(price[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
                    }
                }
            }

        }
        return dp[0][1][cap - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int dp[][] = new int[arr.length][2];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < 2; column++) {
                dp[row][column] = -1;
            }
        }

        System.out.println(findMax(arr, 0, 1, dp));
        printDp(dp);
        System.out.println(findMaxDynamic(arr));
        System.out.println(findMaxValueCap(arr));
    }

}
