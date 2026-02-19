package GfGGraph.Medium;

public class XTotalShapes {

    public static void findDFS(char grid[][], int currentRow, int currentCol, boolean visited[][]) {
        visited[currentRow][currentCol] = true;
        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaCol[] = { 0, 0, 1, -1 };
        for (int i = 0; i < 4; i++) {
            int nextRow = currentRow + deltaRow[i];
            int nextCol = currentCol + deltaCol[i];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
                    && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 'X') {
                findDFS(grid, nextRow, nextCol, visited);
            }
        }
    }

    public static int findTotalDisconnectedGraph(char grid[][]) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int totalCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 'X') {
                    totalCount++;
                    findDFS(grid, i, j, visited);
                }
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        char grid[][] = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'X', 'X' } };

        System.out.println(findTotalDisconnectedGraph(grid));
    }

}
