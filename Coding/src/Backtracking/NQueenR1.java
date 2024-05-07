package Backtracking;

public class NQueenR1 {

    public static boolean isSafe(char chess[][], int row, int column) {
        // validate top
        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][column] == 'Q') {
                return false;
            }
        }
        /// check left diogonal
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //// checkk right diogonal
        for (int i = row - 1, j = column + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void findAllSolution(char chess[][], int row) {
        if (row == chess.length) {
            printNQueen(chess);
            return;
        }

        for (int column = 0; column < chess.length; column++) {
            if (isSafe(chess, row, column)) {
                chess[row][column] = 'Q';
                findAllSolution(chess, row + 1);
                chess[row][column] = 'X';
            }
        }

    }

    public static void printNQueen(char chess[][]) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char chess[][] = new char[5][5];
        for (int row = 0; row < chess.length; row++) {
            for (int column = 0; column < chess.length; column++) {
                chess[row][column] = 'X';
            }
        }
        findAllSolution(chess, 0);
    }

}
