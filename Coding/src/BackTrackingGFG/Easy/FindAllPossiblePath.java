package BackTrackingGFG.Easy;

import java.util.ArrayList;

public class FindAllPossiblePath {

    public static void printAllPath(int grid[][], int row, int col, ArrayList<Integer> currentResult,
            ArrayList<ArrayList<Integer>> finalResult) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            finalResult.add(new ArrayList<>(currentResult));
            return;
        }
        int deltaRow[] = { 1, 0 };
        int deltaCol[] = { 0, 1, };
        for (int i = 0; i < 2; i++) {
            int curRow = row + deltaRow[i];
            int curCol = col + deltaCol[i];
            if (curRow < grid.length && curCol < grid[0].length) {
                currentResult.add(grid[curRow][curCol]);
                printAllPath(grid, curRow, curCol, currentResult, finalResult);
                currentResult.remove(currentResult.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3 },
                { 4, 5, 6 } };
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        ArrayList<Integer> currentResult = new ArrayList<>();
        currentResult.add(grid[0][0]);
        printAllPath(grid, 0, 0, currentResult, finalResult);
        System.out.println(finalResult);
    }

}
