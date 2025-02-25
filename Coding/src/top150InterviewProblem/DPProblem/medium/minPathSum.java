package top150InterviewProblem.DPProblem.medium;

public class minPathSum {

    public static int findMinSum(int arr[][], int row, int column) {
        if (row == arr.length - 1 && column == arr[0].length - 1) {
            return arr[row][column];
        }
        if (row > arr.length - 1 || column > arr[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        // Down index
        int currentValue = arr[row][column];
        int down = findMinSum(arr, row + 1, column);
        int right = findMinSum(arr, row, column + 1);
        return currentValue + Math.min(down, right);
    }

    public static int findMinSumPathDynamic(int arr[][]) {
        int totalRow = arr.length;
        int totalColumn = arr[0].length;
        int dp[][] = new int[totalRow][totalColumn];
        for (int row = totalRow - 1; row >= 0; row--) {
            for (int column = totalColumn - 1; column >= 0; column--) {
                int currentValue = arr[row][column];
                if (row == totalRow - 1 && column == totalColumn - 1) {
                    dp[row][column] = arr[row][column];
                } else if (row + 1 >= totalRow) {
                    dp[row][column] = currentValue + dp[row][column + 1];
                } else if (column + 1 >= totalColumn) {
                    dp[row][column] = currentValue + dp[row + 1][column];
                } else {
                    dp[row][column] = currentValue + Math.min(dp[row + 1][column], dp[row][column + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int map[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(findMinSum(map, 0, 0));
        System.out.println(findMinSumPathDynamic(map));
    }

}
