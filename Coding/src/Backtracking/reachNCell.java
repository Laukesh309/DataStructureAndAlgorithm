package Backtracking;

public class reachNCell {

    public static void findWays(int board[][], int row, int column) {
        if (row == board.length - 1 && column == board[0].length - 1) {
            totalWays++;
            board[row][column] = 1;
            printGrid(board);
            System.out.println();
            board[row][column] = 1;
            return;
        }
        if (row >= board.length) {
            return;
        }
        if (column >= board[0].length) {
            return;
        }
        board[row][column] = 1;
        findWays(board, row + 1, column);
        findWays(board, row, column + 1);
        board[row][column] = 0;
    }

    public static int totalWays = 0;

    public static void printGrid(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int board[][] = new int[3][3];
        findWays(board, 0, 0);
        System.out.println("totalways==>" + totalWays);

    }

}
