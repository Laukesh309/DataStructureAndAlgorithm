package BackTrackingTop20;

import java.util.ArrayList;

public class printAllPossiblePath {

    public static void findAllPath(int grid[][], int curRow, int curCol, int n, int m, ArrayList<Integer> tempPath,
            ArrayList<ArrayList<Integer>> finalResult) {

        if (curRow == n - 1 && curCol == m - 1) {
            tempPath.add(grid[curRow][curCol]);
            ArrayList<Integer> tempResult = new ArrayList<>(tempPath);
            finalResult.add(tempResult);
            tempPath.remove(tempPath.size() - 1);
            return;
        }
        if (curRow < 0 || curCol < 0 || curRow >= n || curCol >= m) {
            return;
        }
        // go right
        tempPath.add(grid[curRow][curCol]);
        findAllPath(grid, curRow, curCol + 1, n, m, tempPath, finalResult);
        findAllPath(grid, curRow + 1, curCol, n, m, tempPath, finalResult);
        tempPath.remove(tempPath.size() - 1);

    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 2, 3 },
                { 4, 5, 6 } };
        int n = 2;
        int m = 3;
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        findAllPath(grid, 0, 0, n, m, new ArrayList<>(), finalResult);
        System.out.println(finalResult);
    }

}
