package GFGDynamicProgrammin;

public class minSumPartition {

    public static int findMin(int arr[], int currentIndex, int currentSum, int total, int dp[][]) {
        if (currentIndex >= arr.length) {
            return Math.abs(total - 2 * currentSum);
        }
        if (dp[currentIndex][currentSum] != -1) {
            return dp[currentIndex][currentSum];
        }
        int take = findMin(arr, currentIndex + 1, currentSum + arr[currentIndex], total, dp);
        int notTake = findMin(arr, currentIndex + 1, currentSum, total, dp);
        dp[currentIndex][currentSum] = Math.min(take, notTake);
        return dp[currentIndex][currentSum];
    }

    public static void main(String[] args) {
        int arr[] = { 1 };
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int dp[][] = new int[arr.length][total + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < total + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findMin(arr, 0, 0, total, dp));
    }

}
