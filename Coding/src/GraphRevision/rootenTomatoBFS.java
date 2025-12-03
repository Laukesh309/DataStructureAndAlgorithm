package GraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class rootenTomatoBFS {
    static class Pair {
        int row;
        int column;
        int count;

        Pair(int source, int destination, int count) {
            this.row = source;
            this.column = destination;
            this.count = count;
        }
    }

    public static void findBFS(int grid[][], Queue<Pair> que, int count[]) {
        while (!que.isEmpty()) {
            Pair pq = que.poll();
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            int curCount = pq.count;
            for (int i = 0; i < 4; i++) {
                int curRow = pq.row + deltaRow[i];
                int curCol = pq.column + deltaCol[i];
                if (curCol >= 0 && curRow >= 0 && curRow < grid.length && curCol < grid[0].length
                        && grid[curRow][curCol] == 1) {
                    grid[curRow][curCol] = 2;
                    que.add(new Pair(curRow, curCol, curCount + 1));
                }

            }
            count[0] = Math.max(count[0], curCount);
        }

    }

    public static void main(String[] args) {
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        Queue<Pair> que = new LinkedList<>();
        int result[] = { 0 };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    que.add(new Pair(i, j, 0));
                }
            }
        }
        findBFS(grid, que, result);
        // for (int i = 0; i < grid.length; i++) {
        // for (int j = 0; j < grid[0].length; j++) {
        // if (grid[i][j] == 1) {
        // return -1;
        // }
        // }
        // }
        // return result[0];
    }

}
