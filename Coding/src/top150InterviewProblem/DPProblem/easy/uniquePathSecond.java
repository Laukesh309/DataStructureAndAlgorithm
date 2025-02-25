package top150InterviewProblem.DPProblem.easy;

public class uniquePathSecond {

    public static int findMax(int obstacleGrid[][], int destinationRow, int destinationColumn,
            int currentRow, int currentColumn) {

        if (currentRow > destinationRow || currentColumn > destinationColumn) {
            return 0;
        }
        if (currentRow == destinationRow && currentColumn == destinationColumn) {
            if (obstacleGrid[currentRow][currentColumn] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (obstacleGrid[currentRow][currentColumn] == 0) {
            return findMax(obstacleGrid, destinationRow, destinationColumn, currentRow, currentColumn + 1)
                    + findMax(obstacleGrid, destinationRow, destinationColumn, currentRow + 1, currentColumn);

        } else {
            return 0;
        }

    }

    public static void printArrayDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMaxRoute(int obstableGrid[][]) {
        int dp[][] = new int[obstableGrid.length + 1][obstableGrid[0].length + 1];
        for (int i = obstableGrid.length - 1; i >= 0; i--) {
            for (int j = obstableGrid[0].length - 1; j >= 0; j--) {
                if (obstableGrid[i][j] == 0) {
                    if (i == obstableGrid.length - 1 && j == obstableGrid[0].length - 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {

        int obstacleGrid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(findMax(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, 0, 0));
        System.out.println(findMaxRoute(obstacleGrid));
    }

}
