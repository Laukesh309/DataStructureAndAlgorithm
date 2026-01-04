package top150InterviewProblem.DPProblem.medium;

public class maxSquare {

    public static int maxSquare(char matrix[][]) {
        int totalRow = matrix.length;
        int totalColumn = matrix[0].length;
        int dp[][] = new int[totalRow][totalColumn];
        int max = 1;
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalColumn; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                }
            }
        }
        for (int row = 1; row < totalRow; row++) {
            for (int col = 1; col < totalColumn; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                    max = Math.max(dp[row][col], max);
                }
            }
        }
        System.out.println(max);
        return max * max;
    }

    public static void main(String[] args) {
        char matrix[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };

        maxSquare(matrix);
    }

}
