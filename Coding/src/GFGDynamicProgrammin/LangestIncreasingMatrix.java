package GFGDynamicProgrammin;

public class LangestIncreasingMatrix {

    public static int findMaxPath(int matrix[][], boolean visited[][], int row, int col, int result[][]) {

        if (result[row][col] != -1) {
            return result[row][col];
        }
        visited[row][col] = true;

        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaCol[] = { 0, 0, 1, -1 };
        int totalPath = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + deltaRow[i];
            int nextCol = col + deltaCol[i];
            if (nextRow < matrix.length && nextCol < matrix[0].length && nextRow >= 0 && nextCol >= 0
                    && visited[nextRow][nextCol] == false && matrix[nextRow][nextCol] > matrix[row][col]) {
                totalPath = Math.max(totalPath, 1 + findMaxPath(matrix, visited, nextRow, nextCol, result));
            }
        }
        visited[row][col] = false;
        result[row][col] = totalPath;
        return result[row][col];
    }

    public static int findMaxValue(int matrix[][]) {
        int pathMaxValue = Integer.MIN_VALUE;
        int result[][] = new int[matrix.length][matrix[0].length];
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                result[row][col] = -1;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (result[row][col] != -1) {
                    pathMaxValue = Math.max(pathMaxValue, result[row][col]);
                } else {
                    pathMaxValue = Math.max(pathMaxValue, 1 + findMaxPath(matrix, visited, row, col, result));
                }

            }
        }
        return pathMaxValue;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println(findMaxValue(matrix));
    }

}
