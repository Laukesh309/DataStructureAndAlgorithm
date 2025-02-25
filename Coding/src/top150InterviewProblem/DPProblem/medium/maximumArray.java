package top150InterviewProblem.DPProblem.medium;

public class maximumArray {

    public static int findMaxValue(int dp[][]) {
        int result = 0;
        for (int row = 0; row < dp.length; row++) {
            for (int column = 0; column < dp[0].length; column++) {
                result = Math.max(result, dp[row][column]);
            }
        }
        return result;
    }

    public static int findMaximuArea(char matrix[][]) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            dp[row][0] = matrix[row][0] == '1' ? 1 : 0;
        }
        for (int column = 0; column < matrix[0].length; column++) {
            dp[0][column] = matrix[0][column] == '1' ? 1 : 0;
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][column] == '1') {
                    dp[row][column] = Math.min(dp[row - 1][column],
                            Math.min(dp[row][column - 1], dp[row - 1][column - 1])) + 1;
                } else {
                    dp[row][column] = 0;
                }

            }
        }
        int result = findMaxValue(dp);
        return result * result;
    }

    public static void main(String[] args) {
        char matrinx[][] = { { '0', '1' }, { '1', '0' } };
        System.out.println(findMaximuArea(matrinx));
    }
}
