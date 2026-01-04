package top150InterviewProblem.DPProblem.easy;

import java.util.Arrays;

public class langestCommonIncreasing {

    public static int findMax(int nums[]) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }

            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 7, 7, 7, 7, 7, 7, 7 };
        findMax(nums);
    }

}
