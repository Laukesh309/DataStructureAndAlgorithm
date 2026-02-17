package GFGDynamicProgrammin;

public class BuyStockTransaction {

    public static int findMaxProfit(int arr[], int curIndex, int buy, int k, int dp[][]) {
        if (curIndex >= arr.length) {
            return 0;
        }
        if (dp[curIndex][buy] != -1) {
            return dp[curIndex][buy];
        }
        if (buy == 1) {
            dp[curIndex][buy] = Math.max(arr[curIndex] + findMaxProfit(arr, curIndex + 1, 0, k, dp) - k,
                    findMaxProfit(arr, curIndex + 1, buy, k, dp));
        } else {
            dp[curIndex][buy] = Math.max(findMaxProfit(arr, curIndex + 1, 1, k, dp) - arr[curIndex],
                    findMaxProfit(arr, curIndex + 1, buy, k, dp));
        }
        return dp[curIndex][buy];
    }

    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        int k = 1;
        int dp[][] = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        System.out.println(findMaxProfit(arr, 0, 0, k, dp));

    }

}
