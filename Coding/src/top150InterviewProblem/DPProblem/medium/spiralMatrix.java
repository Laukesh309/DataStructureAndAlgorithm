package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {

    public static void traverse(int matrix[][], int sourceRow, int sourceColumn, int destinationRow,
            int destinationColumn, List<Integer> result) {

        int row = sourceRow;
        int coloumn = sourceColumn;
        // move right
        for (int i = coloumn; i <= destinationColumn; i++) {
            result.add(matrix[row][i]);
        }
        // move down
        for (int i = row + 1; i <= destinationRow; i++) {
            result.add(matrix[i][destinationColumn]);
        }
        // move left
        if (sourceRow != destinationRow) {
            // move left
            for (int i = destinationColumn - 1; i >= sourceColumn; i--) {
                result.add(matrix[destinationRow][i]);
            }
        }
        // move top
        if (sourceColumn != destinationColumn) {
            for (int i = destinationRow - 1; i > sourceRow; i--) {
                result.add(matrix[i][sourceColumn]);
            }
        }

    }

    public static void findOutPut(int matrix[][], int sourceRow, int sourceColumn, int destinationRow,
            int destinationColumn, List<Integer> result) {
        if (sourceRow > destinationRow || sourceColumn > destinationColumn) {
            return;
        }
        traverse(matrix, sourceRow, sourceColumn, destinationRow, destinationColumn, result);
        findOutPut(matrix, sourceRow + 1, sourceColumn + 1, destinationRow - 1,
                destinationColumn - 1, result);

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        List<Integer> result = new ArrayList<>();
        findOutPut(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
        System.out.println(result);

    }

}
