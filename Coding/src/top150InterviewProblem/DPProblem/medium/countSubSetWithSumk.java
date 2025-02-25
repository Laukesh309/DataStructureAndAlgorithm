package top150InterviewProblem.DPProblem.medium;

public class countSubSetWithSumk {

    public static int findTotalSum(int arr[], int currentIndex, int currentSum) {

        if (currentSum == 0) {
            return 1;
        }
        if (currentIndex >= arr.length || currentSum < 0) {
            return 0;
        }
        int take = findTotalSum(arr, currentIndex + 1, currentSum - arr[currentIndex]);
        int notTake = findTotalSum(arr, currentIndex + 1, currentSum);
        return take + notTake;
    }

    public static void printArray(int dp[][]) {
        for (int row = 0; row < dp.length; row++) {
            for (int coloumn = 0; coloumn < dp[0].length; coloumn++) {
                System.out.print(dp[row][coloumn] + " ");
            }
            System.out.println();
        }
    }

    public static int findTotalSumDynamic(int arr[], int totalSum) {
        int dp[][] = new int[arr.length + 1][totalSum + 1];
        for (int row = 0; row <= arr.length; row++) {
            for (int column = 0; column <= totalSum; column++) {
                if (row == 0 && column == 0) {
                    dp[row][column] = 1;
                }
            }
        }
        for (int row = 1; row <= arr.length; row++) {
            for (int column = 0; column <= totalSum; column++) {
                int notTake = dp[row - 1][column];
                int take = 0;
                if (column - arr[row - 1] >= 0) {
                    take = dp[row - 1][column - arr[row - 1]];
                }
                dp[row][column] = notTake + take;
            }
        }
        return dp[arr.length][totalSum];
    }

    public static void main(String[] args) {
        int arr[] = { 0, 10, 0 };
        int totalSum = 0;
        System.out.println(findTotalSum(arr, 0, totalSum));
        System.out.println(findTotalSumDynamic(arr, totalSum));

    }

}
