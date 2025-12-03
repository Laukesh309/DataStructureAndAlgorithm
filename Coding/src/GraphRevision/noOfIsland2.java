package GraphRevision;

public class noOfIsland2 {

    public static void findDfs(char grid[][], int row, int column) {
        if (row < 0 || column < 0 || row > grid.length - 1 || column > grid[0].length - 1 || grid[row][column] == 'W'
                || grid[row][column] == 'V') {
            return;
        }
        grid[row][column] = 'V';
        // top
        findDfs(grid, row - 1, column);
        // down
        findDfs(grid, row + 1, column);
        // left
        findDfs(grid, row, column - 1);
        // right
        findDfs(grid, row, column + 1);
        // diogonal
        findDfs(grid, row + 1, column + 1);
        findDfs(grid, row + 1, column - 1);
        findDfs(grid, row - 1, column - 1);
        findDfs(grid, row - 1, column + 1);

    }

    public static void main(String[] args) {
        char grid[][] = { { 'L', 'L', 'W', 'W', 'W' }, { 'W', 'L', 'W', 'W', 'L' }, { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' }, { 'L', 'W', 'L', 'L', 'W' } };
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 'W' && grid[i][j] != 'V') {
                    count++;
                    findDfs(grid, i, j);
                }
            }
        }
        System.out.println(count);
    }

}
