package GFGDynamicProgrammin;

public class MaximumPath {

    public static int findMax(int mat[][], int currentRow, int currentCol, int dp[][]) {

        int deltRow[] = { 1, 1, 1 };
        int deltaCol[] = { 0, 1, -1 };
        int maxValue = Integer.MIN_VALUE;
        if (dp[currentRow][currentCol] != -1) {
            return dp[currentRow][currentCol];
        }

        for (int i = 0; i < 3; i++) {
            int nextRow = deltRow[i] + currentRow;
            int nextCol = deltaCol[i] + currentCol;
            if (nextRow < 0 || nextCol < 0 || nextCol >= mat[0].length || nextRow >= mat.length) {
                continue;
            }
            maxValue = Math.max(maxValue, findMax(mat, nextRow, nextCol, dp));
        }
        if (maxValue == Integer.MIN_VALUE) {
            dp[currentRow][currentCol] = mat[currentRow][currentCol];
        } else {
            dp[currentRow][currentCol] = maxValue + mat[currentRow][currentCol];
        }

        return dp[currentRow][currentCol];
    }

    public static void main(String[] args) {

        int mat[][] = { { 3, 6, 1 }, { 2, 3, 4 }, { 5, 5, 1 } };
        int maxValue = Integer.MIN_VALUE;
        int dp[][] = new int[mat.length][mat[0].length];
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                dp[row][col] = -1;
            }
        }
        for (int col = 0; col < mat[0].length; col++) {
            maxValue = Math.max(maxValue, findMax(mat, 0, col, dp));
        }

        System.out.println(maxValue);

    }

}
