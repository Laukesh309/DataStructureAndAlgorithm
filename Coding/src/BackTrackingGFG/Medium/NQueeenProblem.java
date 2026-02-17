package BackTrackingGFG.Medium;

import java.util.ArrayList;

public class NQueeenProblem {

    public static boolean isValid(boolean visited[][], int currentRow, int currentCol) {
        // check top
        for (int i = currentRow - 1; i >= 0; i--) {
            if (visited[i][currentCol]) {
                return false;
            }
        }
        // check leftDiagonal
        for (int i = currentRow - 1, j = currentCol - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j]) {
                return false;
            }
        }
        // check rightDiagonal
        for (int row = currentRow - 1, col = currentCol + 1; row >= 0 && col < visited.length; row--, col++) {
            if (visited[row][col]) {
                return false;
            }
        }
        return true;
    }

    public static void findAllPossibleWays(boolean visited[][], int currentRow, ArrayList<Integer> currentResult,
            ArrayList<ArrayList<Integer>> finalResult) {
        if (currentRow >= visited.length) {
            ArrayList<Integer> result = new ArrayList<>(currentResult);
            finalResult.add(result);
            return;
        }

        for (int col = 0; col < visited.length; col++) {
            if (isValid(visited, currentRow, col)) {
                visited[currentRow][col] = true;
                System.out.println("Testin" + currentRow);
                currentResult.set(currentRow, col + 1);
                findAllPossibleWays(visited, currentRow + 1, currentResult, finalResult);
                visited[currentRow][col] = false;
                // currentResult.remove(currentRow);
            }

        }
    }

    public static void main(String[] args) {
        int n = 1;
        boolean visited[][] = new boolean[n][n];
        ArrayList<Integer> currentResult = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            currentResult.add(0);
        }
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        findAllPossibleWays(visited, 0, currentResult, finalResult);
        System.out.println(finalResult);

    }

}
