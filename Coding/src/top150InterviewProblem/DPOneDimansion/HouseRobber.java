package top150InterviewProblem.DPOneDimansion;

public class HouseRobber {

    public static int findMaxValue(int nums[], int currentIndex) {
        if (currentIndex < 0) {
            return 0;
        }
        int pick = nums[currentIndex] + findMaxValue(nums, currentIndex - 2);
        int notPick = findMaxValue(nums, currentIndex - 1);
        return Math.max(pick, notPick);
    }

    public static int findMax(int nums[]) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i - 2 < 0) {
                dp[i] = Math.max(nums[i], dp[0]);
            } else {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 9, 3, 1 };
        System.out.println(findMaxValue(nums, nums.length - 1));
        System.out.println(findMax(nums));
    }

}
