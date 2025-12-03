package GraphRevision;

public class noOfIsland1 {

    public static void findVisited(int grid[][], int row, int column, boolean visited[][]) {
        if (visited[row][column] == true || grid[row][column] == 'W') {
            return;
        }
        visited[row][column] = true;
        int dRow[] = { 0, 0, -1, -1, -1, 1, 1, 1 };
        int dCol[] = { 1, -1, 0, -1, 1, 1, 0, -1 };
        for (int i = 0; i < 8; i++) {
            int cRow = row + dRow[i];
            int cCol = column + dCol[i];

            if (cRow >= 0 && cCol >= 0 && cCol < grid[0].length && cRow < grid.length) {
                findVisited(grid, cRow, cCol, visited);
            }
        }

    }

    public static int noOfIsland(int grid[][]) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 'L') {
                    count++;
                    findVisited(grid, i, j, visited);
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int grid[][] = { { 'W', 'L', 'L', 'L', 'W', 'W', 'W' }, { 'W', 'W', 'L', 'L', 'W', 'L', 'W' } };
        System.out.println(noOfIsland(grid));
    }

}
