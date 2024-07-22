package array;

public class maximumProductSubArray {

    public static int maximumSumSubArray(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        int maximumValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    dp[i][j] = arr[i];
                    maximumValue = Math.max(maximumValue, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                dp[i][j] = dp[i][j - 1] * arr[j];
                maximumValue = Math.max(maximumValue, dp[i][j]);
            }
        }
        return maximumValue;
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 3, -2, 4 };
        int arr[] = { -2, 0, -1 };
        System.out.println(maximumSumSubArray(arr));

    }

}
