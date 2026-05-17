package GfGGraph.LeetcodeGraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public static void printArray(char board[][]) {
        for (char[] cs : board) {
            for (char cs2 : cs) {
                System.out.print(cs2 + " ");

            }
            System.out.println();
        }
    }

    public static void formedSurroundedRegion(char board[][]) {

        Queue<int[]> que = new LinkedList<>();
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                que.add(new int[] { 0, col });
            }
            if (board[board.length - 1][col] == 'O') {
                que.add(new int[] { board.length - 1, col });
            }
        }

        for (int row = 1; row < board.length - 1; row++) {
            if (board[row][0] == 'O') {
                que.add(new int[] { row, 0 });
            }
            if (board[row][board[0].length - 1] == 'O') {
                que.add(new int[] { row, board[0].length - 1 });
            }
        }
        while (!que.isEmpty()) {
            int temp[] = que.poll();
            int row = temp[0];
            int col = temp[1];

            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            board[row][col] = 'L';
            for (int i = 0; i < 4; i++) {
                int nextRow = row + deltaRow[i];
                int nextCol = col + deltaCol[i];
                if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'L') {
                    continue;
                }
                que.add(new int[] { nextRow, nextCol });

            }

        }
        printArray(board);

    }

    public static void main(String[] args) {
        char board[][] = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };

        formedSurroundedRegion(board);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == 'L') {
                    board[row][col] = 'O';
                }
            }
        }
    }

}
