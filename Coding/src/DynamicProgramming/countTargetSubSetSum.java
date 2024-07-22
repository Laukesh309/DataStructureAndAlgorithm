package DynamicProgramming;

public class countTargetSubSetSum {

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findTotalNumberOfSubSet(int arr[], int currentIndex, int targetSum, String result) {
        if (targetSum == 0) {
            System.out.println(result);
            return 1;
        }
        if (currentIndex >= arr.length) {
            return 0;
        }
        if (arr[currentIndex] <= targetSum) {
            return findTotalNumberOfSubSet(arr, currentIndex + 1, targetSum - arr[currentIndex],
                    result + arr[currentIndex]) + findTotalNumberOfSubSet(arr, currentIndex + 1, targetSum, result);
        } else {
            return findTotalNumberOfSubSet(arr, currentIndex + 1, targetSum, result);
        }
    }

    public static int findTotalNumberOfSubSetTabulisation(int arr[], int totalSum) {
        int row = arr.length;
        int column = totalSum;
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printDp(dp);

        return dp[row][column];

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 6, 8, 10 };
        int targetSum = 10;
        System.out.println(findTotalNumberOfSubSet(arr, 0, targetSum, ""));
        System.out.println(findTotalNumberOfSubSetTabulisation(arr, targetSum));
    }

}
