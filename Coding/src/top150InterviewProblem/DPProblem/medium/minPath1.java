package top150InterviewProblem.DPProblem.medium;

public class minPath1 {

    public static int findMinPath(int[][] grid) {
        int dp[] = new int[grid[0].length];
        dp[grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        // full fill last row
        for (int j = grid[0].length - 2; j >= 0; j--) {
            dp[j] = grid[grid.length - 1][j] + dp[j + 1];
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                int currentValue = grid[i][j];
                int right = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                if (j + 1 <= grid[i].length - 1) {
                    right = dp[j + 1];
                }
                down = dp[j];
                dp[j] = currentValue + Math.min(right, down);
            }
            printArray(dp);
        }
        return -1;

    }

    public static void printArray(int dp[]) {
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        findMinPath(grid);
    }

}
