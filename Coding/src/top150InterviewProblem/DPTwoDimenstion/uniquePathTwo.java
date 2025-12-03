package top150InterviewProblem.DPTwoDimenstion;

public class uniquePathTwo {

    public static int printAllPath(int grid[][], int row, int column, int dp[][]) {
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return 1;
        }
        if (row >= grid.length || column >= grid[0].length || grid[row][column] == 1) {
            return 0;
        }
        if (dp[row][column] != 0) {
            return dp[row][column];
        }
        int rightPath = printAllPath(grid, row + 1, column, dp);
        int leftPath = printAllPath(grid, row, column + 1, dp);
        dp[row][column] = rightPath + leftPath;
        return dp[row][column];
    }

    public static void main(String[] args) {
        int obstacleGrid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        System.out.println(printAllPath(obstacleGrid, 0, 0, dp));
    }

}
