package top150InterviewProblem.slidingWindowRevision;

public class binarySubArrayWithSum {

    public static int totalNumberOfSubarrayWithSum(int nums[], int goal) {
        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int total = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left++];
            }
            total += right - left + 1;
            right++;

        }
        return total;

    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 1, 1, 1 };
        int target = 3;
        int result = 0;
        for (int row = 0; row < nums.length; row++) {
            int currentSum = 0;
            for (int column = row; column < nums.length; column++) {
                currentSum += nums[column];
                if (currentSum == target) {
                    result++;
                }

            }
        }
        System.out.println(result);
        // System.out.println(totalNumberOfSubarrayWithSum(nums, result));
        // System.out.println(totalNumberOfSubarrayWithSum(nums, result));
        System.out.println(totalNumberOfSubarrayWithSum(nums, target));
        System.out.println(totalNumberOfSubarrayWithSum(nums, target - 1));
        int goal = totalNumberOfSubarrayWithSum(nums, target);
        int lessGoal = totalNumberOfSubarrayWithSum(nums, target - 1);
        System.out.println(goal - lessGoal);
    }

}
