package GreedyAlgorithm;

public class jumpGameSecond {

    public static int findMinJump(int nums[], int index, int dp[]) {
        if (index >= nums.length - 1) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            int tempValue = findMinJump(nums, index + i, dp);
            if (tempValue != Integer.MAX_VALUE) {
                minValue = Math.min(minValue, 1 + findMinJump(nums, index + i, dp));
            }
        }
        dp[index] = minValue;
        return dp[index];
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 0, 1, 4 };
        int dp[] = new int[nums.length];
        System.out.println(findMinJump(nums, 0, dp));
    }

}
