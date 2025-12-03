package GraphRevision;

public class noOfIsland {

    public static void perFormDfs(char[][] grid, boolean visited[][], int row, int column) {
        if (visited[row][column] == true || grid[row][column] == '0') {
            return;
        }
        visited[row][column] = true;
        // go right
        if (column + 1 < grid[row].length && visited[row][column + 1] == false) {
            perFormDfs(grid, visited, row, column + 1);
        }
        // go left
        if (column - 1 >= 0 && visited[row][column - 1] == false) {
            perFormDfs(grid, visited, row, column - 1);
        }
        // go top
        if (row - 1 >= 0 && visited[row - 1][column] == false) {
            perFormDfs(grid, visited, row - 1, column);
        }
        // go bottom
        if (row + 1 < grid.length && visited[row + 1][column] == false) {
            perFormDfs(grid, visited, row + 1, column);
        }

    }

    public static int findTotalIsland(char[][] grid, boolean visited[][]) {

        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    perFormDfs(grid, visited, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        boolean visited[][] = new boolean[grid.length][grid[0].length];
        System.out.println(findTotalIsland(grid, visited));

    }

}
