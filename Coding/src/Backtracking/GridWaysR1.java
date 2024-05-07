package Backtracking;

public class GridWaysR1 {

    public static int result = 0;

    public static void printGrid(int grid[][]) {
        result++;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("new Grid======>");
    }

    public static int findAllPossibleRoute(int grid[][], int sourceRow, int sourceColumn, int destinationRow,
            int destinationColumn) {
        if (sourceRow == destinationRow && sourceColumn == destinationColumn) {
            grid[sourceRow][sourceColumn] = 1;
            printGrid(grid);
            grid[sourceRow][sourceColumn] = 0;
            return 1;
        }
        // if we move down to grid
        if (sourceRow >= grid.length) {
            return 0;
        }
        // if we move right to grid
        if (sourceColumn >= grid[0].length) {
            return 0;
        }
        grid[sourceRow][sourceColumn] = 1;
        int rightPathValue = findAllPossibleRoute(grid, sourceRow + 1, sourceColumn, destinationRow, destinationColumn);
        int leftPathValue = findAllPossibleRoute(grid, sourceRow, sourceColumn + 1, destinationRow, destinationColumn);
        grid[sourceRow][sourceColumn] = 0;
        return rightPathValue + leftPathValue;

    }

    public static void main(String[] args) {
        int grid[][] = new int[3][3];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                grid[row][column] = 0;
            }
        }
        System.out.println(findAllPossibleRoute(grid, 0, 0, grid.length - 1, grid[0].length - 1));
        System.out.println(result);

    }

}
