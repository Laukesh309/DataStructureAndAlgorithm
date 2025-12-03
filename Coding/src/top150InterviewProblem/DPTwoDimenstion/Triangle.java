package top150InterviewProblem.DPTwoDimenstion;

public class Triangle {

    public static int findMinSum(int num[][], int row, int column) {
        if (row >= num.length) {
            return 0;
        }
        int currentValue = num[row][column];
        return Math.min(findMinSum(num, row + 1, column) + currentValue,
                findMinSum(num, row + 1, column + 1) + currentValue);

    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMin(int nums[][]) {
        int row = nums.length;
        int column = nums.length;
        int dp[][] = new int[row][column];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = nums[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = nums[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = nums[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }

            }
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < column; i++) {
            max = Math.min(max, dp[nums.length - 1][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[][] = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };

        System.out.println(findMinSum(nums, 0, 0));
        System.out.println(findMin(nums));

    }

}
