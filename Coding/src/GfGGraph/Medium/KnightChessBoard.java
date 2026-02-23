package GfGGraph.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class KnightChessBoard {

    public static int findMin(int n, int knightPos[], int targetPos[]) {
        boolean visited[][] = new boolean[n][n];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { targetPos[0], targetPos[1], 0 });
        visited[targetPos[0] - 1][targetPos[1] - 1] = true;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int deltaRow[] = { 2, 2, -2, -2, 1, -1, 1, -1 };
                int deltaCol[] = { 1, -1, 1, -1, 2, 2, -2, -2 };
                int temp[] = que.poll();
                int sourceRow = temp[0];
                int souceCol = temp[1];
                int step = temp[2];
                if (sourceRow == knightPos[0] && souceCol == knightPos[1]) {
                    return step;
                }
                for (int j = 0; j < 8; j++) {
                    int nextRow = sourceRow + deltaRow[j];
                    int nextCol = souceCol + deltaCol[j];
                    if (nextRow >= 1 && nextCol >= 1 && nextRow <= n && nextCol <= n
                            && !visited[nextRow - 1][nextCol - 1]) {
                        que.add(new int[] { nextRow, nextCol, 1 + step });
                    }
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 1;
        int knightPos[] = { 1, 1 };
        int targetPos[] = { 1, 1 };
        System.out.println(findMin(n, knightPos, targetPos));
    }

}
