package GraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class replaceowithx {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void printMatrix(char mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void perFormBFS(char mat[][], char result[][]) {
        System.out.println("testing1");
        Queue<Pair> que = new LinkedList<>();
        int deltaRow[] = { 0, mat.length - 1 };
        for (int i = 0; i < deltaRow.length; i++) {
            int row = deltaRow[i];
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[row][j] == 'O') {
                    que.add(new Pair(row, j));
                    result[row][j] = 'O';
                }
            }
        }
        printMatrix(result);
        int deltaCol[] = { 0, mat[0].length - 1 };
        for (int i = 0; i < deltaRow.length; i++) {
            int col = deltaCol[i];
            for (int j = 1; j < mat.length - 1; j++) {
                if (mat[j][col] == 'O') {
                    que.add(new Pair(j, col));
                    result[j][col] = 'O';
                }
            }
        }
        System.out.println("==>");
        printMatrix(result);
        while (!que.isEmpty()) {
            System.out.println("testing");
            Pair pair = que.poll();
            int sourceRow = pair.row;
            int sourceCol = pair.col;
            int dRow[] = { 1, -1, 0, 0 };
            int dCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int curRow = sourceRow + dRow[i];
                int curCol = sourceCol + dCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < mat.length && curCol < mat[0].length
                        && mat[curRow][curCol] == 'O' && result[curRow][curCol] != 'O') {
                    que.add(new Pair(curRow, curCol));
                    result[curRow][curCol] = 'O';
                }
            }
        }

    }

    public static void main(String[] args) {
        char mat[][] = { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'O' } };
        char result[][] = new char[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                result[i][j] = 'X';
            }
        }
        perFormBFS(mat, result);
        System.out.println("\n\n\n==>");
        printMatrix(result);
    }

}
