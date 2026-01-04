package top150InterviewProblem.BackTracking;

public class NQueenProblem {

    public static boolean isSafe(int dp[][], int currentRow, int currentCol) {
        /// check current column
        for (int row = currentRow - 1; row >= 0; row--) {
            if (dp[row][currentCol] == 1) {
                return false;
            }
        }
        // check for left diagonal
        for (int row = currentRow - 1, col = currentCol - 1; row >= 0 && col >= 0; row--, col--) {
            if (dp[row][col] == 1) {
                return false;
            }
        }
        // check for right diagonal
        for (int row = currentRow - 1, col = currentCol + 1; row >= 0 && col < dp.length; row--, col++) {
            if (dp[row][col] == 1) {
                return false;
            }
        }
        return true;

    }

    public static void findTotal(int n, int currentRow, int dp[][], int total[]) {
        if (currentRow >= n) {
            total[0] = total[0] + 1;
            return;
        }
        for (int i = 0; i < n; i++) {

            if (isSafe(dp, currentRow, i)) {
                dp[currentRow][i] = 1;
                findTotal(n, currentRow + 1, dp, total);
                dp[currentRow][i] = 0;
            }
        }

    }

    public static void pringDp(int dp[][]) {
        for (int[] singleDp : dp) {
            for (int item : singleDp) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 1;
        int dp[][] = new int[n][n];
        int total[] = new int[1];
        findTotal(n, 0, dp, total);
        System.out.println(total[0]);
    }

}
