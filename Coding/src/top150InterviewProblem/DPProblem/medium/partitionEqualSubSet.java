package top150InterviewProblem.DPProblem.medium;

public class partitionEqualSubSet {

    public static boolean findParition(int arr[], int currentIndex, int currentSum) {
        if (currentSum == 0) {
            return true;
        }
        if (currentSum < 0 || currentIndex > arr.length - 1) {
            return false;
        }

        boolean take = findParition(arr, currentIndex + 1, currentSum - arr[currentIndex]);
        boolean noTake = findParition(arr, currentIndex + 1, currentSum);
        return take || noTake;

    }

    public static boolean findPartitionDynamic(int arr[], int totalSum) {
        int totalRow = arr.length + 1;
        int totalColumn = totalSum + 1;
        boolean dp[][] = new boolean[totalRow][totalColumn];
        for (int row = 0; row < totalRow; row++) {
            for (int column = 0; column < totalColumn; column++) {
                if (column == 0) {
                    dp[row][column] = true;
                } else {
                    dp[row][column] = false;
                }
            }
        }
        for (int row = 1; row < totalRow; row++) {
            for (int column = 1; column < totalColumn; column++) {
                if (column - arr[row - 1] >= 0) {
                    dp[row][column] = dp[row][column - arr[row - 1]] || dp[row - 1][column];
                } else {
                    dp[row][column] = dp[row - 1][column];
                }
            }
        }
        return dp[totalRow - 1][totalColumn - 1];

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 5 };
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 == 0) {
            System.out.println(findParition(nums, 0, totalSum));
            System.out.println(findPartitionDynamic(nums, totalSum));
        } else {
            System.out.println("false");
        }
    }

}
