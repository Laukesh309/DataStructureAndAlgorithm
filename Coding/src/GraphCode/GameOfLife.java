package GraphCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GameOfLife {
    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean checkDiedChange(int board[][], int row, int col) {
        int deltaRow[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
        int deltaCol[] = { -1, 0, 1, -1, 1, 0, 1, -1 };
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int curRow = row + deltaRow[i];
            int curCol = col + deltaCol[i];
            if (curRow >= 0 && curCol >= 0 && curRow < board.length && curCol < board[0].length
                    && board[curRow][curCol] == 1) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }

    public static boolean checkLiveChange(int board[][], int row, int col) {
        int deltaRow[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
        int deltaCol[] = { -1, 0, 1, -1, 1, 0, 1, -1 };
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int curRow = row + deltaRow[i];
            int curCol = col + deltaCol[i];
            if (curRow >= 0 && curCol >= 0 && curRow < board.length && curCol < board[0].length
                    && board[curRow][curCol] == 1) {
                count++;
            }
        }
        if (count < 2 || count > 3) {
            return true;
        }
        return false;

    }

    public static void checkChange(int board[][]) {
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && checkLiveChange(board, i, j)) {
                    st.add(new Pair(i, j));
                }
                if (board[i][j] == 0 && checkDiedChange(board, i, j)) {
                    st.add(new Pair(i, j));
                }
            }
        }
        while (!st.isEmpty()) {
            Pair pair = st.pop();
            int curRow = pair.row;
            int curCol = pair.col;
            board[curRow][curCol] = board[curRow][curCol] == 1 ? 0 : 1;
        }

    }

    public static void main(String[] args) {
        int board[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        checkChange(board);
    }

}
