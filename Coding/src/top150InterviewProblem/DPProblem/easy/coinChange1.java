package top150InterviewProblem.DPProblem.easy;

import java.util.Arrays;

public class coinChange1 {

    public static int findTotalCoin(int coins[], int amount) {
        if (amount == 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            dp[coins[i]] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }
        System.out.println(dp[amount]);
        return dp[amount];

    }

    public static void printArray(int dp[]) {
        for (int i : dp) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int amount = 11;
        System.out.println(findTotalCoin(coins, amount));

    }

}
