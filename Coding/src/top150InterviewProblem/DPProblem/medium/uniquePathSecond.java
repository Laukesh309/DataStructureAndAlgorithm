package top150InterviewProblem.DPProblem.medium;

public class uniquePathSecond {

    public static int findMaxPath(int obstacleGrid[][]) {

        // fill lastRow
        int totalRow = obstacleGrid.length;
        int totalColumn = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[totalRow - 1][totalColumn - 1] == 1) {
            return 0;
        }
        int dp[] = new int[totalColumn];
        dp[totalColumn - 1] = 1;
        for (int i = totalColumn - 2; i >= 0; i--) {
            if (obstacleGrid[totalRow - 1][i] == 1) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        printPath(dp);
        for (int row = totalRow - 2; row >= 0; row--) {
            System.out.println(row);
            for (int column = totalColumn - 1; column >= 0; column--) {
                System.out.println(row + "this" + column);
                if (obstacleGrid[row][column] == 1) {

                    dp[column] = 0;
                } else {
                    int right = 0;
                    int down = 0;
                    if (column + 1 < totalColumn) {
                        right = dp[column + 1];
                    }

                    down = dp[column];
                    dp[column] = right + down;
                }
            }
        }
        return dp[0];
    }

    public static void printPath(int dp[]) {
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int obstacleGrid[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(findMaxPath(obstacleGrid));

    }

}
