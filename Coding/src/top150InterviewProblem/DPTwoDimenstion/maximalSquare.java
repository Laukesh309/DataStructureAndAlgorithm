package top150InterviewProblem.DPTwoDimenstion;

public class maximalSquare {

    public static int findMaximalSquare(String matrix[][]) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == "1" ? 1 : 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("1")) {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                } else {
                    dp[row][col] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        String matrix[][] = { { "1", "0", "1", "0", "0" }, { "1", "0", "1", "1", "1" }, { "1", "1", "1", "1", "1" },
                { "1", "0", "0", "1", "0" } };

        System.out.println(findMaximalSquare(matrix));

    }

}
