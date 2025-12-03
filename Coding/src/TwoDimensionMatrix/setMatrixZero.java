package TwoDimensionMatrix;

// https://leetcode.com/problems/set-matrix-zeroes/description/
public class setMatrixZero {
    public static void printArray(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int xRow = 1;
        int yColumn = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                yColumn = 0;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                xRow = 0;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                }

            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                int currentColumn = 0;
                while (currentColumn < matrix[0].length) {
                    matrix[i][currentColumn] = 0;
                }

            }
        }
        for (int i = 1; i < matrix[0].length; i++) {

            if (matrix[0][i] == 0) {
                int currentRow = 0;
                while (currentRow < matrix.length) {
                    matrix[currentRow++][i] = 0;
                }
            }
        }
        if (xRow == 0) {
            int currentColumn = 0;
            while (currentColumn < matrix[0].length) {
                matrix[0][currentColumn++] = 0;
            }
        }
        if (yColumn == 0) {
            int currentRow = 0;
            while (currentRow < matrix.length) {
                matrix[currentRow++][0] = 0;
            }
        }
    }
}
