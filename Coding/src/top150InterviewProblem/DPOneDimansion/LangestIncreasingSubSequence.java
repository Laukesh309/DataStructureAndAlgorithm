package top150InterviewProblem.DPOneDimansion;

public class LangestIncreasingSubSequence {

    public static int findMaxSubSequence(int nums[], int currentIndex, int prevValue) {
        if (currentIndex < 0) {
            return 0;
        }
        int notPick = findMaxSubSequence(nums, currentIndex - 1, prevValue);
        int pick = 0;
        if (nums[currentIndex] < prevValue) {
            pick = 1 + findMaxSubSequence(nums, currentIndex - 1, nums[currentIndex]);
        }
        return Math.max(notPick, pick);
    }

    public static int findMaxSubSequenceIndex(int nums[], int currentIndex, int prevIndex, int dp[][]) {
        if (currentIndex < 0) {
            return 0;
        }
        if (prevIndex != -1 && dp[currentIndex][prevIndex] != 0) {
            return dp[currentIndex][prevIndex];
        }
        int notPick = findMaxSubSequenceIndex(nums, currentIndex - 1, prevIndex, dp);
        int pick = 0;
        if (prevIndex == -1 || nums[currentIndex] < nums[prevIndex]) {
            pick = 1 + findMaxSubSequenceIndex(nums, currentIndex - 1, currentIndex, dp);
        }
        int maxValue = Math.max(notPick, pick);
        if (prevIndex == -1) {
            dp[currentIndex][nums.length] = maxValue;
            return dp[currentIndex][nums.length];
        }
        dp[currentIndex][prevIndex] = maxValue;
        return dp[currentIndex][prevIndex];

    }

    public static int findLangestIncreasingSubSequence(int arr[]) {
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int currentValue = arr[i];
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < currentValue) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int nums[] = { 4, 10, 4, 3, 8, 9 };
        int dp[][] = new int[nums.length][nums.length + 1];
        System.out.println(findMaxSubSequence(nums, nums.length - 1, Integer.MAX_VALUE));
        System.out.println(findMaxSubSequenceIndex(nums, nums.length - 1, -1, dp));
        System.out.println(findLangestIncreasingSubSequence(nums));

    }

}
