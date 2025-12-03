package GraphRevision;

public class rootenTommato {

    public static void findMinimumTime(int grid[][], int visited[][], int isChanged[], int row, int column) {

        // top
        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaCol[] = { 0, 0, 1, -1 };
        for (int i = 0; i < 4; i++) {
            int curRow = row + deltaRow[i];
            int curCol = column + deltaCol[i];
            if (curCol >= 0 && curRow >= 0 && curRow < grid.length && curCol < grid[0].length
                    && grid[curRow][curCol] == 1) {
                visited[curRow][curCol] = 2;
                isChanged[0] = 1;
            }
        }

    }

    public static

    public static void main(String[] args) {
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int isChanged[] = { 1 };
        int count = 0;
        while (isChanged[0] == 1) {
            isChanged[0] = 0;
            int visited[][] = new int[grid.length][grid[0].length];
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[0].length; column++) {
                    visited[row][column] = grid[row][column];
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        findMinimumTime(grid, visited, isChanged, i, j);
                    }
                }
            }
            if (isChanged[0] == 1) {
                count++;
                for (int row = 0; row < grid.length; row++) {
                    for (int column = 0; column < grid[0].length; column++) {
                        grid[row][column] = visited[row][column];
                    }
                }
            }

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

}
