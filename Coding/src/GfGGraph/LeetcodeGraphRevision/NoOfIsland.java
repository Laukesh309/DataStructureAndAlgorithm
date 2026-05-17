package GfGGraph.LeetcodeGraphRevision;

public class NoOfIsland {

    public static void makeVisited(char grid[][], int currentRow, int currentCol, boolean visited[][]) {
        if (currentCol < 0 || currentRow < 0 || currentRow >= grid.length || currentCol >= grid[0].length
                || grid[currentRow][currentCol] == '0' || visited[currentRow][currentCol]) {
            return;
        }
        visited[currentRow][currentCol] = true;
        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaCol[] = { 0, 0, 1, -1 };
        for (int i = 0; i < 4; i++) {
            int nextRow = currentRow + deltaRow[i];
            int nextCol = currentCol + deltaCol[i];
            makeVisited(grid, nextRow, nextCol, visited);
        }

    }

    public static int findTotalIsland(char grid[][]) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int totalCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    makeVisited(grid, row, col, visited);
                    totalCount++;
                }

            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        char grid[][] = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        System.out.println(findTotalIsland(grid));
    }

}
