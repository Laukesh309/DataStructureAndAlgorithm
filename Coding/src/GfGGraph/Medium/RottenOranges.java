package GfGGraph.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int findTotalTime(int mar[][]) {
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < mar.length; i++) {
            for (int j = 0; j < mar[0].length; j++) {
                if (mar[i][j] == 2) {
                    que.add(new int[] { i, j });
                }
            }
        }
        int totalCount = 0;
        while (!que.isEmpty()) {
            int size = que.size();

            boolean flag = false;
            for (int i = 0; i < size; i++) {
                int temp[] = que.poll();
                int sourceRow = temp[0];
                int sourceCol = temp[1];
                int deltaRow[] = { 1, -1, 0, 0 };
                int deltaCol[] = { 0, 0, 1, -1 };

                for (int j = 0; j < 4; j++) {
                    int nextRow = sourceRow + deltaRow[j];
                    int nextCol = sourceCol + deltaCol[j];
                    if (nextRow >= 0 && nextCol >= 0 && nextRow < mar.length && nextCol < mar[0].length
                            && mar[nextRow][nextCol] == 1) {
                        mar[nextRow][nextCol] = 2;
                        que.add(new int[] { nextRow, nextCol });
                        flag = true;
                    }
                }
            }
            if (flag == true) {
                totalCount++;
            }
        }
        for (int i = 0; i < mar.length; i++) {
            for (int j = 0; j < mar[0].length; j++) {
                if (mar[i][j] == 1) {
                    return -1;
                }
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int mat[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
        findTotalTime(mat);
    }

}
