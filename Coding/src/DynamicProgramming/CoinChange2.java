package DynamicProgramming;

import java.util.Arrays;

public class CoinChange2 {

    public static int findMaxCoint(int coins[], int amount, int currentIndex) {
        if (amount == 0) {
            return 0;
        }
        if (currentIndex < 0) {
            return Integer.MAX_VALUE;
        }
        int leftValue = findMaxCoint(coins, amount, currentIndex - 1);
        int rightValue = Integer.MAX_VALUE;
        int currentValue = coins[currentIndex];
        if (currentValue <= amount) {
            rightValue = findMaxCoint(coins, amount - currentValue, currentIndex);
        }
        if (rightValue != Integer.MAX_VALUE) {
            rightValue = rightValue + 1;
        }
        return Math.max(leftValue, rightValue);
    }

    public static int findMinValue(int coins[], int amount) {
        int dp[] = new int[coins.length + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int currentCoint = coins[i];
            dp[currentCoint] = 1;
            for (int j = currentCoint + 1; j <= amount; j++) {
               dp[j] = Math.min(dp[j], 1+dp[j-currentCoint);
            }
        }
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int amount = 11;
    }

}
