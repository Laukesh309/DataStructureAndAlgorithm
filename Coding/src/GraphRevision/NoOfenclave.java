package GraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfenclave {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int findNoOfEnclave(int grid[][]) {
        Queue<Pair> que = new LinkedList<>();
        int count = 0;
        // row move
        for (int col = 0; col < grid[0].length; col++) {
            // firstRow
            if (grid[0][col] == 1) {
                que.add(new Pair(0, col));
                grid[0][col] = 0;
            }
            // last row
            if (grid[grid.length - 1][col] == 1) {
                que.add(new Pair(grid.length - 1, col));
                grid[grid.length - 1][col] = 0;
            }
        }

        // colmove
        for (int row = 1; row < grid.length - 1; row++) {
            // firstCol
            if (grid[row][0] == 1) {
                que.add(new Pair(row, 0));
                grid[row][0] = 0;
            }
            // last col
            if (grid[row][grid[0].length - 1] == 1) {
                que.add(new Pair(row, grid[0].length - 1));
                grid[row][grid[0].length - 1] = 0;

            }
        }
        while (!que.isEmpty()) {
            Pair pq = que.poll();
            int row = pq.row;
            int col = pq.col;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int curRow = row + deltaRow[i];
                int curCol = col + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < grid.length && curCol < grid[0].length
                        && grid[curRow][curCol] == 1) {
                    que.add(new Pair(curRow, curCol));
                    grid[curRow][curCol] = 0;
                }
            }

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        findNoOfEnclave(grid);
    }

}
