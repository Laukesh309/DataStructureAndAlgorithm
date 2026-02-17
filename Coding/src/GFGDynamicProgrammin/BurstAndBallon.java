package GFGDynamicProgrammin;

public class BurstAndBallon {

    public static int maximumCoin(int nums[], int startIndex, int endIndex, int dp[][]) {
        if (startIndex > endIndex) {
            return 0;
        }
        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            int profit = nums[i] * nums[startIndex - 1] * nums[endIndex + 1];
            int left = maximumCoin(nums, startIndex, i - 1, dp);
            int right = maximumCoin(nums, i + 1, endIndex, dp);
            maxProfit = Math.max(maxProfit, profit + left + right);
        }
        dp[startIndex][endIndex] = maxProfit;
        return dp[startIndex][endIndex];
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, 5, 8 };
        int newArray[] = new int[nums.length + 2];
        newArray[0] = 1;
        newArray[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newArray[i + 1] = nums[i];
        }

        int dp[][] = new int[newArray.length][newArray.length];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(maximumCoin(newArray, 1, nums.length, dp));
    }

}
