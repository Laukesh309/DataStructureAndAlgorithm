package GfGGraph.Easy;

public class ReplaceOwithX {

    public static void replaceZero(char grid[][], int currentRow, int currentCol) {
        if (currentRow < 0 || currentCol < 0 || currentCol >= grid[0].length || currentRow >= grid.length
                || grid[currentRow][currentCol] != 'O') {
            return;
        }
        grid[currentRow][currentCol] = 'L';
        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaCol[] = { 0, 0, 1, -1 };
        for (int i = 0; i < 4; i++) {
            replaceZero(grid, currentRow + deltaRow[i], currentCol + deltaCol[i]);
        }
    }

    public static void changeZero(char grid[][]) {

        // firstRow
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[0][col] == 'O') {
                replaceZero(grid, 0, col);
            }
        }
        // firstCol
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] == 'O') {
                replaceZero(grid, row, 0);
            }
        }
        // lastRow
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[grid.length - 1][col] == 'O') {
                replaceZero(grid, grid.length - 1, col);
            }
        }
        // last Col
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][grid[0].length - 1] == 'O') {
                replaceZero(grid, row, grid[0].length - 1);
            }
        }
    }

    public static void printArray(char grid[][]) {
        for (char[] cs : grid) {
            for (char cs2 : cs) {
                System.out.print(cs2 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char grid[][] = { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' } };
        changeZero(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
                if (grid[i][j] == 'L') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

}
