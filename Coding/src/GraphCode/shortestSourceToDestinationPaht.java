package GraphCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class shortestSourceToDestinationPaht {

    static class Pair {
        int row;
        int col;
        int curWeight;

        Pair(int row, int col, int curWeight) {
            this.row = row;
            this.col = col;
            this.curWeight = curWeight;

        }

    }

    public static int findMin(int grid[][], int source[], int destination[]) {
        int visited[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(source[0], source[1], 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int row = pair.row;
            int col = pair.col;
            int weight = pair.curWeight;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            if (row == destination[0] && col == destination[1]) {
                return weight;
            }
            for (int i = 0; i < 4; i++) {
                int curRow = row + deltaRow[i];
                int curCol = col + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < grid.length && curCol < grid[0].length
                        && grid[curRow][curCol] == 1 && weight + 1 < visited[curRow][curCol]) {
                    pq.add(new Pair(curRow, curCol, weight + 1));
                    visited[curRow][curCol] = weight + 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 } };
        int source[] = { 0, 1 };
        int destination[] = { 2, 2 };
        System.out.println(findMin(grid, source, destination));
    }

}
