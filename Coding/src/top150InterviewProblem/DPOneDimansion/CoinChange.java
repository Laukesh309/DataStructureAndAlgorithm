package top150InterviewProblem.DPOneDimansion;

public class CoinChange {

    public static int findMinCoint(int nums[], int total, int currentIndex, int dp[][]) {
        if (currentIndex < 0 || total < 0) {
            return Integer.MAX_VALUE;
        }
        if (total == 0) {
            return 0;
        }

        if (dp[currentIndex][total] != 0) {
            return dp[currentIndex][total];
        }
        int notPick = findMinCoint(nums, total, currentIndex - 1, dp);
        int pick = Integer.MAX_VALUE;
        if (total > 0) {
            pick = findMinCoint(nums, total - nums[currentIndex], currentIndex, dp);
        }
        if (pick != Integer.MAX_VALUE) {
            pick = 1 + pick;
        }
        dp[currentIndex][total] = Math.min(pick, notPick);
        return dp[currentIndex][total];
    }

    public static int findMinCastDynamic(int nums[], int target) {
        int dp[][] = new int[nums.length + 1][target + 1];
        for (int row = 0; row <= nums.length; row++) {
            for (int column = 0; column <= target; column++) {
                if (row == 0 && column > 0) {
                    dp[row][column] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    if (dp[i][j - nums[i - 1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(1 + dp[i][j - nums[i - 1]], dp[i - 1][j]);

                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args) {

        int nums[] = { 1, 2, 5 };
        int total = 11;
        int dp[][] = new int[nums.length][total + 1];
        System.out.println(findMinCoint(nums, total, nums.length - 1, dp));
        System.out.println(findMinCastDynamic(nums, total));

    }

}
