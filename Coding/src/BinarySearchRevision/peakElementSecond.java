package BinarySearchRevision;

import java.util.ArrayList;

public class peakElementSecond {
    public static int findMaxRow(int mat[][], int currentColumn) {
        int maxValue = mat[0][currentColumn];
        int maxIndex = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][currentColumn] > maxValue) {
                maxValue = mat[i][currentColumn];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static ArrayList<Integer> findPeakElement(int mat[][], int startColumn,
            int endColumn) {
        if (startColumn > endColumn) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(-1);
            result.add(-1);
            return result;

        }
        int midColumn = (startColumn + endColumn) / 2;
        int findMaxRow = findMaxRow(mat, midColumn);
        int leftValue = midColumn == 0 ? Integer.MIN_VALUE : mat[findMaxRow][midColumn - 1];
        int rightValue = midColumn == mat[0].length - 1 ? Integer.MIN_VALUE : mat[findMaxRow][midColumn + 1];
        if (mat[findMaxRow][midColumn] >= leftValue && mat[findMaxRow][midColumn] >= rightValue) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(findMaxRow);
            result.add(midColumn);
            return result;
        }
        if (mat[findMaxRow][midColumn] < leftValue) {
            return findPeakElement(mat, startColumn, midColumn - 1);
        } else {
            return findPeakElement(mat, midColumn + 1, endColumn);
        }

    }

    public static void main(String[] args) {
        int mat[][] = { { 46, 46 } };
        System.out.println(findPeakElement(mat, 0, mat[0].length - 1));
    }

}
