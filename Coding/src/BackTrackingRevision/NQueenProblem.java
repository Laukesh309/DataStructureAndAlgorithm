package BackTrackingRevision;

public class NQueenProblem {

    public static boolean isSafe(int chess[][], int currentRow, int currentColumn) {

        // checkTop
        for (int i = currentRow - 1; i >= 0; i--) {
            if (chess[i][currentColumn] == 1) {
                return false;
            }
        }
        // check leftdiagonal
        for (int i = currentRow - 1, j = currentColumn - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        /// check rightDiagonal

        for (int i = currentRow - 1, j = currentColumn + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;

    }

    public static void printArray(int chess[][]) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findTotalWays(int chess[][], int currentRow) {
        if (currentRow >= chess.length) {
            printArray(chess);
            return 1;
        }
        int totalResult = 0;
        for (int i = 0; i < chess.length; i++) {
            if (isSafe(chess, currentRow, i)) {
                chess[currentRow][i] = 1;
                totalResult = totalResult + findTotalWays(chess, currentRow + 1);
                chess[currentRow][i] = 0;
            }

        }
        return totalResult;

    }

    public static void main(String[] args) {
        int n = 4;
        int chess[][] = new int[n][n];
        System.out.println(findTotalWays(chess, 0));

    }

}
