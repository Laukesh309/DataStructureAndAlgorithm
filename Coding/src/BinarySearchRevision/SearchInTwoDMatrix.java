package BinarySearchRevision;

public class SearchInTwoDMatrix {

    public static int findRow(int matrix[][], int startRow, int endRow, int target) {
        if (startRow > endRow) {
            return endRow;
        }
        int midRow = (startRow + endRow) / 2;
        if (matrix[midRow][0] == target) {
            return midRow;
        }
        if (matrix[midRow][0] < target) {
            return findRow(matrix, midRow + 1, endRow, target);
        } else {
            return findRow(matrix, startRow, midRow - 1, target);
        }
    }

    public static boolean findElement(int matrix[][], int row, int startColumn, int endColumn, int target) {
        if (startColumn > endColumn) {
            return false;
        }
        int midIndex = (startColumn + endColumn) / 2;
        if (matrix[row][midIndex] == target) {
            System.out.println(row + " " + midIndex);
            return true;
        }
        if (matrix[row][midIndex] < target) {
            return findElement(matrix, row, midIndex + 1, endColumn, target);
        } else {
            return findElement(matrix, row, startColumn, midIndex - 1, target);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        int target = 13;
        int row = findRow(matrix, 0, matrix.length - 1, target);
        boolean result = findElement(matrix, row, 0, matrix[0].length - 1, target);
        System.out.println(result);

    }

}
