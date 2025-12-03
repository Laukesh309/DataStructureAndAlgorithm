package GraphStriver;

import java.util.LinkedList;
import java.util.Queue;

public class sorroundedRegion1 {
    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void createGraph(String board[][]) {
        Queue<Pair> que = new LinkedList<>();
        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column].equals("O")) {
                que.add(new Pair(0, column));
                board[0][column] = "V";
            }
            if (board[board.length - 1][column].equals("O")) {
                que.add(new Pair(board.length - 1, column));
                board[board.length - 1][column] = "V";
            }
        }
        for (int row = 1; row < board.length - 1; row++) {
            if (board[row][0].equals("O")) {
                que.add(new Pair(row, 0));
                board[row][0] = "V";
            }
            if (board[row][board[0].length - 1].equals("O")) {
                que.add(new Pair(row, board[0].length - 1));
                board[row][board[0].length - 1] = "V";
            }
        }
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int curRow = pair.row;
            int curCol = pair.col;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int curSource = curRow + deltaRow[i];
                int curColumn = curCol + deltaCol[i];
                System.out.println(curSource + " " + curColumn);
                if (curSource >= 0 && curColumn >= 0 && curSource < board.length && curColumn < board[0].length
                        && board[curSource][curColumn].equals("O")) {
                    board[curSource][curColumn] = "V";
                    que.add(new Pair(curRow, curColumn));
                }
            }

        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("O")) {
                    board[i][j] = "X";
                }
                if (board[i][j].equals("V")) {
                    board[i][j] = "O";
                }
            }
        }

    }

    public static void main(String[] args) {
        String board[][] = { { "O" } };
        createGraph(board);

    }

}
