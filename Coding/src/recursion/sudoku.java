package recursion;

public class sudoku {

    public static boolean isSafe(char grid[][], int row, int column, char value) {
        int baseRow = (row / 3) * 3;
        int baseColumn = (column / 3) * 3;

        /// check for perticularRow
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] != '.' && grid[row][i] == value) {
                return false;
            }
        }
        /// check for perticularColumn

        for (int i = 0; i < 9; i++) {
            if (grid[i][column] != '.' && grid[i][column] == value) {
                return false;
            }
        }

        /// check for grid

        for (int j = baseRow; j <= baseRow + 2; j++) {
            for (int k = baseColumn; k <= baseColumn + 2; k++) {
                if (grid[j][k] != '.' && grid[j][k] == value) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void printSuduku(char grid[][]) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
                System.out.print(grid[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean solveSuduko(char grid[][], int row, int column) {
        if (row >= grid.length) {
            System.out.println("problem soleved");
            printSuduku(grid);
            return true;
        }

        if (column >= grid.length) {
            return solveSuduko(grid, row + 1, 0);
        }

        if (grid[row][column] != '.') {
            return solveSuduko(grid, row, column + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(grid, row, column, (char) (i + '0'))) {
                grid[row][column] = (char) (i + '0');
                if (solveSuduko(grid, row, column + 1)) {
                    return true;
                }
                ;
                grid[row][column] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSuduko(grid, 0, 0);
        printSuduku(grid);

    }

}
