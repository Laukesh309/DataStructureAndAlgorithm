package top150InterviewProblem.DPProblem.easy;

public class houseRobber {

    public static int findMax(int arr[], int currentIndex, int sum) {
        if (currentIndex > arr.length - 1) {
            return sum;
        }
        sum = sum + arr[currentIndex];
        int leftValue = findMax(arr, currentIndex + 2, sum);
        sum = sum - arr[currentIndex];
        int rightValue = findMax(arr, currentIndex + 1, sum);
        return Math.max(leftValue, rightValue);
    }

    public static int findMaxDynamic(int arr[]) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i - 2 < 0) {
                dp[i] = Math.max(dp[i - 1], arr[i]);
            } else {
                int currentValue = arr[i] + dp[i - 2];
                dp[i] = Math.max(currentValue, dp[i - 1]);
            }
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 9, 3, 1 };
        System.out.println(findMax(arr, 0, 0));
        System.out.println(findMaxDynamic(arr));
    }

}
