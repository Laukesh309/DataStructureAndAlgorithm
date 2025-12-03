package GraphStriver;

import java.util.LinkedList;
import java.util.Queue;

public class mazeShortestDistance {

    static class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static int findMazePath(int grid[][], int source[], int destination[]) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(source[0], source[1]));
        int visited[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[source[0]][source[1]] = 0;
        while (!que.isEmpty()) {
            Pair pair = que.remove();
            int deltaRow[] = { 0, 0, -1, 1 };
            int deltaCol[] = { 1, -1, 0, 0 };
            for (int i = 0; i < 4; i++) {
                int curRow = pair.row + deltaRow[i];
                int curCol = pair.column + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < grid.length && curCol < grid[0].length &&
                        grid[curRow][curCol] == 1 && visited[pair.row][pair.column] + 1 < visited[curRow][curCol]) {
                    visited[curRow][curCol] = visited[pair.row][pair.column] + 1;
                    que.add(new Pair(curRow, curCol));

                }
            }

        }
        if (visited[destination[0]][destination[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return visited[destination[0]][destination[1]];
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 } };
        int source[] = { 0, 1 };
        int destination[] = { 2, 2 };
        System.out.println(findMazePath(grid, source, destination));

    }

}
