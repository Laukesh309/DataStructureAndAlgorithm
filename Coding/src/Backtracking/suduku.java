package Backtracking;

public class suduku {

    public static boolean isSafe(int sudoku[][], int row, int column, int value) {
        int baseRow = (row / 3) * 3;
        int baseColumn = (column / 3) * 3;
        //// column traversal
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][column] == value) {
                return false;
            }

        }
        /// int row traversal
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }
        /// grid traversal
        for (int i = baseRow; i < baseRow + 3; i++) {
            for (int j = baseColumn; j < baseColumn + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSuduko(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean findSudoko(int sudoku[][], int row, int column) {

        int nextRow = row;
        int nextColumn = column;
        if (nextColumn == 9) {
            nextColumn = 0;
            nextRow = nextRow + 1;
        }
        if (nextRow >= sudoku.length) {
            printSuduko(sudoku);
            return true;
        }
        if (sudoku[nextRow][nextColumn] != 0) {
            return findSudoko(sudoku, nextRow, nextColumn + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (isSafe(sudoku, nextRow, nextColumn, i)) {
                sudoku[nextRow][nextColumn] = i;
                if (findSudoko(sudoku, nextRow, nextColumn + 1)) {
                    return true;
                }
                sudoku[nextRow][nextColumn] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        System.out.println(findSudoko(sudoku, 0, 0));
    }

}
