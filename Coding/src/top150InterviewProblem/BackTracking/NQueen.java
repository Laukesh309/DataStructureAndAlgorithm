package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static boolean isSafe(int grid[][], int currentRow, int currentColumn) {
        // checktop
        for (int i = currentRow - 1; i >= 0; i--) {
            if (grid[i][currentColumn] == 1) {
                return false;
            }
        }
        // check leftDiogonal
        for (int i = currentRow - 1, j = currentColumn - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 1) {
                return false;
            }
        }
        // check rightopdiogonal
        for (int i = currentRow - 1, j = currentColumn + 1; i >= 0 && j < grid[0].length; i--, j++) {
            if (grid[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static int isPossible(int grid[][], int currentRow, List<String> result) {
        if (currentRow >= grid.length) {
            System.out.println(result);
            return 1;
        }

        int totalResult = 0;
        for (int i = 0; i < grid.length; i++) {
            if (isSafe(grid, currentRow, i)) {
                grid[currentRow][i] = 1;
                totalResult = totalResult + isPossible(grid, currentRow + 1, result);
                result.remove(result.size() - 1);
                grid[currentRow][i] = 0;
            }
        }
        return totalResult;

    }

    public static void main(String[] args) {
        int n = 4;
        int grid[][] = new int[n][n];
        System.out.println(isPossible(grid, 0, new ArrayList<String>()));
    }

}
