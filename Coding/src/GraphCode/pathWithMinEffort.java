package GraphCode;

import java.util.PriorityQueue;

public class pathWithMinEffort {

    static class Pair {
        int row;
        int col;
        int effort;

        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public static void findMinEffor(int height[][], int sourceRow, int sourceCol) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int visited[][] = new int[height.length][height[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(sourceRow, sourceCol, 0));
        visited[sourceRow][sourceCol] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int row = pair.row;
            int col = pair.col;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int curRow = row + deltaRow[i];
                int curCol = col + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < height.length && curCol < height[0].length) {
                    int curEffort = Math.abs(height[row][col] - height[curRow][curCol]);
                    if (curEffort < visited[curRow][curCol]) {
                        pq.add(new Pair(curRow, curCol, curEffort));
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int height[][] = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };

    }

}
