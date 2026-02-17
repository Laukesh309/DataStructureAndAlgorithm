package GFGDynamicProgrammin;

public class CoinChange {

    public static int findMaxSubSet(int coins[], int currentIndex, int sum) {
        if (currentIndex >= coins.length) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        int include = 0;
        if (coins[currentIndex] <= sum) {
            include = findMaxSubSet(coins, currentIndex, sum - coins[currentIndex]);
        }
        int exclude = findMaxSubSet(coins, currentIndex + 1, sum);
        return include + exclude;

    }

    public static int findMax(int coins[], int sum) {
        int dp[][] = new int[coins.length + 1][sum + 1];
        for (int row = 0; row < coins.length + 1; row++) {
            dp[row][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int currentCoin = coins[i - 1];
                dp[i][j] = dp[i - 1][j];
                if (currentCoin <= j) {
                    dp[i][j] = dp[i][j] + dp[i][j - currentCoin];
                }
            }
        }
        return dp[coins.length][sum];
    }

    public static void main(String[] args) {
        int sum = 10;
        int coins[] = { 2, 5, 3, 6 };
        System.out.println(findMaxSubSet(coins, 0, sum));
        System.out.println(findMax(coins, sum));
    }

}
