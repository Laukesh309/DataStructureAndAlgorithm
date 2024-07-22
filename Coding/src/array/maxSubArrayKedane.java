package array;

public class maxSubArrayKedane {

    public static int findMaxSumArray(int arr[]) {
        int row = arr.length;
        int column = arr.length;
        int dp[][] = new int[row][column];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == j) {
                    dp[i][j] = arr[i];
                } else {
                    dp[i][j] = Integer.MIN_VALUE;
                }
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = i + 1; j < column; j++) {
                dp[i][j] = arr[j] + dp[i][j - 1];
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        // int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int arr[] = { 1 };
        System.out.println(findMaxSumArray(arr));
    }

}
