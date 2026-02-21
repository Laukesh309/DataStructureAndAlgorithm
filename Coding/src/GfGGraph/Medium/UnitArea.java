package GfGGraph.Medium;

public class UnitArea {

    public static int findMaxArea(int grid[][], int currentRow, int currentCol, boolean visited[][]) {
        visited[currentRow][currentCol] = true;
        int deltaRow[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
        int deltaCol[] = { 0, 1, -1, 0, 1, -1, 1, -1 };
        int total = 1;
        for (int i = 0; i < 8; i++) {
            int nextRow = currentRow + deltaRow[i];
            int nextCol = currentCol + deltaCol[i];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length
                    && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                total = total + findMaxArea(grid, nextRow, nextCol, visited);
            }
        }
        return total;
    }

    public static int maxArea(int grid[][]) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, findMaxArea(grid, i, j, visited));
                }
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int grid[][] = { { 0 } };
        System.out.println(maxArea(grid));
    }

}
