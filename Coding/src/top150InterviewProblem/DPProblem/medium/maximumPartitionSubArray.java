package top150InterviewProblem.DPProblem.medium;

public class maximumPartitionSubArray {

    public static int findMaxValue(int arr[], int start, int k, int dp[]) {
        if (start == arr.length) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        int result = Integer.MIN_VALUE;
        int tempValue = Integer.MIN_VALUE;
        for (int i = start; i < start + k && i < arr.length; i++) {
            tempValue = Math.max(tempValue, arr[i]);
            int currentValue = tempValue * (i - start + 1) + findMaxValue(arr, i + 1, k, dp);
            result = Math.max(result, currentValue);
        }
        dp[start] = result;
        return dp[start];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
        int k = 4;
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = -1;
        }
        System.out.println(findMaxValue(arr, 0, k, dp));
    }

}
