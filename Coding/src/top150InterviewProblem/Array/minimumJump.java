package top150InterviewProblem.Array;

public class minimumJump {

    public static int minJump(int nums[], int start) {
        // System.out.println(start);
        if (start >= nums.length - 1) {
            return 0;
        }
        int currentValue = nums[start];
        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= currentValue; i++) {
            if (minJump(nums, start + i) == Integer.MAX_VALUE) {
                continue;
            }
            int currentMin = 1 + minJump(nums, i + start);
            result = Math.min(result, currentMin);
        }

        return result;
    }

    public static int findMinJump(int nums[]) {
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int currentValue = nums[i];
            int result = Integer.MAX_VALUE;
            for (int j = 1; j <= currentValue; j++) {
                if (i + j >= nums.length - 1) {
                    result = 1;
                } else {
                    if (dp[i + j] != Integer.MAX_VALUE) {
                        result = Math.min(result, 1 + dp[i + j]);
                    }

                }

            }
            dp[i] = result;
        }
        return dp[0];

    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 1, 4 };
        System.out.println(minJump(nums, 0));
        System.out.println(findMinJump(nums));

    }

}
