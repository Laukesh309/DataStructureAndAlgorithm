package GraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class distanceOfnearestCell {

    static class Pair {
        int source;
        int dest;
        int distance;

        Pair(int source, int dest, int distance) {
            this.source = source;
            this.dest = dest;
            this.distance = distance;
        }
    }

    public static void findNearest(int grid[][], int result[][]) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int source = pair.source;
            int destination = pair.dest;
            int step = pair.distance;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int curRow = source + deltaRow[i];
                int curCol = destination + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < grid.length && curCol < grid[0].length
                        && grid[curRow][curCol] != 1 && result[curRow][curCol] == 0) {

                    result[curRow][curCol] = step + 1;
                    queue.add(new Pair(curRow, curCol, step + 1));

                }
            }

        }
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };
        int result[][] = new int[grid.length][grid[0].length];
        findNearest(grid, result);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }

    }

}
