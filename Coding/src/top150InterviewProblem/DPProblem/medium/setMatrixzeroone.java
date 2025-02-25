package top150InterviewProblem.DPProblem.medium;

import java.util.HashSet;

public class setMatrixzeroone {

    public static void formZeroOne(int matrix[][]) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        System.out.println(rowSet + " " + columnSet);

    }

    public static void printMatring(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        int totalRow = matrix.length;
        int totalColumn = matrix[0].length;
        for (Integer row : rowSet) {
            for (int i = 0; i < totalColumn; i++) {
                matrix[row][i] = 0;
            }
        }
        for (Integer column : columnSet) {
            for (int i = 0; i < totalRow; i++) {
                matrix[i][column] = 0;
            }
        }
        printMatring(matrix);
    }

}
