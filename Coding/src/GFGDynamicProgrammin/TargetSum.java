package GFGDynamicProgrammin;

public class TargetSum {

    public static int findTotalNoOfWays(int nums[], int currentIndex, int total, int currentSum, int dp[][]) {

        if (currentIndex == nums.length && currentSum == total) {
            return 1;
        }
        if (currentIndex >= nums.length) {
            return 0;
        }
        if (dp[currentIndex][currentSum] != 0) {
            return dp[currentIndex][currentSum];
        }
        int plus = findTotalNoOfWays(nums, currentIndex + 1, total, currentSum + nums[currentIndex], dp);
        int minus = findTotalNoOfWays(nums, currentIndex + 1, total, currentSum - nums[currentIndex], dp);
        dp[currentIndex][currentSum] = plus + minus;
        return dp[currentIndex][currentSum];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0 }, target = 1;
        int dp[][] = new int[nums.length][];
        for(int i=0;i<nums.length;i++){
            dp[i][] =-1;
        }
        System.out.println(findTotalNoOfWays(nums, 0, target, 0, dp));
    }

}
