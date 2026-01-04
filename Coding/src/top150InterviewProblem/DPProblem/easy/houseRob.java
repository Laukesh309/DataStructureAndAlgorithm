package top150InterviewProblem.DPProblem.easy;

public class houseRob {

    public static int findMax(int nums[], int currentIndex) {
        if (currentIndex >= nums.length) {
            return 0;
        }

        return Math.max(nums[currentIndex] + findMax(nums, currentIndex + 2), findMax(nums, currentIndex + 1));
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 9, 3, 1 };
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        System.out.println(findMax(nums, 0));
    }

}
