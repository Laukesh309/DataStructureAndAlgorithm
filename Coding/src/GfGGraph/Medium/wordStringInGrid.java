package GfGGraph.Medium;

import java.util.ArrayList;

public class wordStringInGrid {

    public static boolean findAllIndex(char grid[][], int sourceRow, int sourceCol, int direction, String result,
            String currentResult) {
        System.out.println("testing");
        if (sourceRow < 0 || sourceCol < 0 || sourceRow >= grid.length || sourceCol >= grid[0].length
                || !result.startsWith(currentResult)) {
            return false;
        }
        String tempString = currentResult + grid[sourceRow][sourceCol];
        if (result.equals(tempString)) {
            return true;
        }
        int deltaRow[] = { 1, 1, 1, -1, -1, -1, 0, 0 };
        int deltaCol[] = { 0, 1, -1, 0, 1, -1, 1, -1 };
        int nextRow = sourceRow + deltaRow[direction];
        int nextCol = sourceCol + deltaCol[direction];
        return findAllIndex(grid, nextRow, nextCol, direction, result, tempString);

    }

    public static void findAllStringIndex(char grid[][], String word) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String curChar = grid[i][j] + "";
                if (word.startsWith(curChar)) {
                    for (int k = 0; k < 8; k++) {
                        if (findAllIndex(grid, i, j, k, word, new String())) {
                            ArrayList<Integer> tempResult = new ArrayList<>();
                            tempResult.add(i);
                            tempResult.add(j);
                            finalResult.add(tempResult);
                            break;
                        }
                    }

                }
            }
        }
        int tempResult[][] = new int[finalResult.size()][2];
        for (int row = 0; row < finalResult.size(); row++) {
            tempResult[row][0] = finalResult.get(row).get(0);
            tempResult[row][1] = finalResult.get(row).get(1);
        }
        return tempResult;
    }

    public static void main(String[] args) {
        char grid[][] = { { 'a', 'b', 'a', 'b' }, { 'a', 'b', 'e', 'b' }, { 'e', 'b', 'e', 'b' } };
        String word = "abe";
        findAllStringIndex(grid, word);
    }

}
