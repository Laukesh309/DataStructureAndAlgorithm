package GfGGraph.Easy;

public class NumberOfIsland {

    public static void makeConnected(char grid[][], int currentRow, int currentCol, boolean visited[][]) {
        visited[currentRow][currentCol] = true;
        int deltaRow[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
        int deltaCol[] = { 0, 1, -1, 0, 1, -1, -1, 1 };
        for (int i = 0; i < 8; i++) {
            int nextRow = currentRow + deltaRow[i];
            int nextCol = currentCol + deltaCol[i];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
                    && visited[nextRow][nextCol] == false
                    && grid[nextRow][nextCol] == 'L') {
                makeConnected(grid, nextRow, nextCol, visited);
            }
        }
    }

    public static int findTotalIsland(char grid[][]) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == 'L') {
                    total++;
                    makeConnected(grid, i, j, visited);
                }
            }
        }
        return total;

    }

    public static void main(String[] args) {
        char grid[][] = { { 'W', 'L', 'L', 'L', 'W', 'W', 'W' },
                { 'W', 'W', 'L', 'L', 'W', 'L', 'W' } };
        System.out.println(findTotalIsland(grid));
    }

}
