package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCelll {

    public static int findNearestCell(int grid[][]) {

        int dist[][] = new int[grid.length][grid[0].length];
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    dist[i][j] = 0;
                    queue.add(new int[] { i, j });
                }
            }
        }
        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            int curRow = temp[0];
            int curCol = temp[1];
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + deltaRow[i];
                int nextCol = curCol + deltaCol[i];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length
                        && !visited[nextRow][nextCol]) {
                    dist[nextRow][nextCol] = dist[curRow][curCol] + 1;
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] { nextRow, nextCol });
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] is : dist) {
            ArrayList<Integer> tempArray = new ArrayList<>();
            for (int item : is) {
                tempArray.add(item);
            }
            result.add(tempArray);
        }
        System.out.println(result);
        // System.out.println(queue);
        return 0;

    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 1, 1, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 } };
        findNearestCell(grid);

    }

}
