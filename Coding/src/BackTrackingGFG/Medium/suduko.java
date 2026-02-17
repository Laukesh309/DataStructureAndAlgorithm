package BackTrackingGFG.Medium;

public class suduko {

    public static void printArray(int arr[][]) {
        for (int[] is : arr) {
            for (int item : is) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean validDigit(int mat[][], int row, int col, int currentDigit) {

        // check int currentrow
        for (int i = 0; i < mat.length; i++) {
            if (mat[row][i] == currentDigit) {
                return false;
            }
        }
        // check in currentCol
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] == currentDigit) {
                return false;
            }
        }
        /// check in square
        int baseRow = row / 3 * 3;
        int baseCol = col / 3 * 3;
        for (int row1 = baseRow; row1 < baseRow + 3; row1++) {
            for (int col1 = baseCol; col1 < baseCol + 3; col1++) {
                if (mat[row1][col1] == currentDigit) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean findSuduko(int mat[][], int currentRow, int currentCol) {
        // System.out.println(currentRow + " " + currentCol + " " + mat.length);
        if (currentRow >= mat.length) {
            return true;
        }
        if (currentCol >= mat.length) {
            return findSuduko(mat, currentRow + 1, 0);
        }
        if (mat[currentRow][currentCol] != 0) {
            return findSuduko(mat, currentRow, currentCol + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (validDigit(mat, currentRow, currentCol, i)) {
                mat[currentRow][currentCol] = i;
                if (findSuduko(mat, currentRow, currentCol + 1)) {
                    return true;
                }
                mat[currentRow][currentCol] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = { { 3, 0, 6, 5, 7, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, {
                        0, 0, 5, 2, 8, 6, 3, 0, 0
                } };
        // printArray(mat);
        findSuduko(mat, 0, 0);
        printArray(mat);
        System.out.println("testing");
    }

}
