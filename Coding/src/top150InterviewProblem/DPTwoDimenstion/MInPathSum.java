package top150InterviewProblem.DPTwoDimenstion;

public class MInPathSum {

    public static int findMinPath(int grid[][], int row, int column, int visit[][]) {
        if (row >= grid.length || column >= grid[0].length || row < 0 || column < 0) {
            return Integer.MAX_VALUE;
        }
        if ((row == grid.length - 1) && (column == grid[0].length - 1)) {
            return grid[row][column];
        }
        if (visit[row][column] == 1) {
            return Integer.MAX_VALUE;
        }
        //
        visit[row][column] = 1;
        int left = findMinPath(grid, row, column - 1, visit);
        int right = findMinPath(grid, row, column + 1, visit);
        int top = findMinPath(grid, row - 1, column, visit);
        int bottom = findMinPath(grid, row + 1, column, visit);
        visit[row][column] = 0;

        int currentResult = Math.min(Math.min(Math.min(right, bottom), left), top);
        if (currentResult != Integer.MAX_VALUE) {
            return grid[row][column] + currentResult;
        } else {
            return currentResult;
        }

    }

    public static int findMin(int grid[][], int row, int column, int dp[][]) {
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return grid[row][column];
        }
        if (row >= grid.length || column >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][column] != 0) {
            return dp[row][column];
        }
        int right = findMin(grid, row, column + 1, dp);
        int down = findMin(grid, row + 1, column, dp);
        int result = Math.min(right, down);
        if (result == Integer.MAX_VALUE) {
            dp[row][column] = Integer.MAX_VALUE;
        } else {
            dp[row][column] = result + grid[row][column];
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        int dp[][] = new int[grid.length][grid[0].length];
        int visit[][] = new int[grid.length][grid[0].length];
        System.out.println(findMinPath(grid, 0, 0, visit));
        System.out.println(findMin(grid, 0, 0, dp));

    }

}
