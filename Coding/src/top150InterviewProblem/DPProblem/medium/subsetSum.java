package top150InterviewProblem.DPProblem.medium;

public class subsetSum {

    public static boolean findSubSet(int arr[], int target, int currentIndex) {
        if (target == 0) {
            return true;
        }
        if (currentIndex > arr.length - 1) {
            return false;
        }
        return findSubSet(arr, target - arr[currentIndex], currentIndex + 1)
                || findSubSet(arr, target, currentIndex + 1);

    }

    public static boolean findSubSetDynamic(int arr[], int target) {
        boolean dp[][] = new boolean[arr.length + 1][target + 1];
        for (int row = 0; row < dp.length; row++) {
            for (int column = 0; column < dp[0].length; column++) {
                if (column == 0) {
                    dp[row][column] = true;
                }
            }
        }
        for (int row = 1; row < dp.length; row++) {
            for (int column = 1; column < dp[0].length; column++) {
                if (column < arr[row - 1]) {
                    dp[row][column] = dp[row - 1][column];
                } else {
                    dp[row][column] = dp[row - 1][column - arr[row - 1]] || dp[row - 1][column];
                }
            }
        }
        return dp[arr.length][target];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int target = 30;
        System.out.println(findSubSet(arr, target, 0));
        System.out.println(findSubSetDynamic(arr, target));
    }

}
