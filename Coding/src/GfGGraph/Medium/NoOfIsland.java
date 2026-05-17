package GfGGraph.Medium;

import tree.topView;

public class NoOfIsland {

    public static void connectGraph(char grid[][], int sourceRow, int sourceCol) {
        if (sourceRow < 0 || sourceCol < 0 || sourceRow >= grid.length || sourceCol >= grid[0].length
                || grid[sourceRow][sourceCol] != '1') {
            return;
        }
        grid[sourceRow][sourceCol] = 'x';
        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaCol[] = { 0, 0, 1, -1 };
        for (int i = 0; i < 4; i++) {
            int curRow = sourceRow + deltaRow[i];
            int curCol = sourceCol + deltaCol[i];
            connectGraph(grid, curRow, curCol);
        }
    }

    public static int findTotalIsland(char grid[][]) {
        int total = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    connectGraph(grid, row, col);
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        char grid[][] = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(findTotalIsland(grid));
    }

}
