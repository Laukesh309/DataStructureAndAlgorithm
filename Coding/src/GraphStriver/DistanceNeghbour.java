package GraphStriver;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceNeghbour {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void printArray(int graph[][]) {
        for (int[] row : graph) {
            for (int col : row) {
                System.out.print(col + " ");

            }
            System.out.println();
        }
    }

    public static void findNearest(int graph[][]) {
        int result[][] = new int[graph.length][graph[0].length];
        boolean visited[][] = new boolean[graph.length][graph[0].length];
        Queue<Pair> que = new LinkedList<>();
        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[0].length; col++) {
                if (graph[row][col] == 1) {
                    que.add(new Pair(row, col));
                    visited[row][col] = true;
                    result[row][col] = 0;
                }
            }
        }
        while (!que.isEmpty()) {
            Pair curPair = que.remove();
            int dRow[] = { -1, 1, 0, 0 };
            int dCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int row = dRow[i] + curPair.row;
                int col = dCol[i] + curPair.col;
                int curStep = result[curPair.row][curPair.col];
                if (row >= 0 && col >= 0 && row < graph.length && col < graph[0].length && !visited[row][col]
                        && graph[row][col] != 1) {
                    que.add(new Pair(row, col));
                    visited[row][col] = true;
                    result[row][col] = curStep + 1;
                }
            }
        }
        printArray(result);
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };
        findNearest(grid);
    }

}
