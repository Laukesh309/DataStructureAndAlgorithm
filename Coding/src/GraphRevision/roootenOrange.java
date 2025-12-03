package GraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class roootenOrange {
    static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int findMinTime(int mat[][], int visited[][]) {
        Queue<Pair> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (mat[i][j] == 1) {
                    count++;
                }
            }
        }
        int maxTime = 0;
        int countFresh = 0;
        int deltaRow[] = { -1, 0, 1, 0 };
        int deltaCol[] = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            Pair currentPair = queue.remove();
            int curRow = currentPair.row;
            int curCol = currentPair.col;
            int curTime = currentPair.time;

            for (int i = 0; i < 4; i++) {
                int cRow = curRow + deltaRow[i];
                int cCol = curCol + deltaCol[i];
                if (cRow >= 0 && cRow < mat.length && cCol >= 0 && cCol < mat[0].length
                        && visited[cRow][cCol] != 2 && mat[cRow][cCol] == 1) {
                    visited[cRow][cCol] = 2;
                    queue.add(new Pair(cRow, cCol, curTime + 1));
                    countFresh++;

                }
            }
            maxTime = Math.max(maxTime, curTime);

        }
        if (count != countFresh)
            return -1;
        return maxTime;
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };
        int visited[][] = new int[mat.length][mat[0].length];
        System.out.println(findMinTime(mat, visited));

    }

}