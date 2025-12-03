package GraphCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PatthWithMinEffor {
    static class Pair implements Comparable<Pair> {
        int sourceRow;
        int sourceCol;
        int Path;

        Pair(int row, int col, int path) {
            this.sourceRow = row;
            this.sourceCol = col;
            this.Path = path;
        }

        public int compareTo(Pair p2) {
            return this.Path - p2.Path;
        }
    }

    public static void findMinEffort(int row, int columns, int height[][]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int visited[][] = new int[height.length][height[0].length];
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[0].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(row, columns, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int sourceRow = pair.sourceRow;
            int sourceCol = pair.sourceCol;
            int path = pair.Path;
            if (sourceRow == height.length - 1 && sourceCol == height[0].length - 1) {
                System.out.println(path);
                return;
            }
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int curRow = sourceRow + deltaRow[i];
                int curCol = sourceCol + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < height.length && curCol < height[0].length
                        && visited[curRow][curCol] > Math.abs(height[sourceRow][sourceCol] - height[curRow][curCol])) {
                    int curPath = Math.abs(height[sourceRow][sourceCol] - height[curRow][curCol]);
                    visited[curRow][curCol] = Math.abs(height[sourceRow][sourceCol] - height[curRow][curCol]);
                    if (curPath > path) {
                        pq.add(new Pair(curRow, curCol, curPath));
                    } else {
                        pq.add(new Pair(curRow, curCol, path));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int row = 3;
        int columns = 3;
        int heights[][] = { { 7, 7 }, { 7, 7 } };
        findMinEffort(0, 0, heights);
    }

}
