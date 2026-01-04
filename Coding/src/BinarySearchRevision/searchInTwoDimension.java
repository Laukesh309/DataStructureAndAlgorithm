package BinarySearchRevision;

public class searchInTwoDimension {

    // public static int findRow(int mat[][], int startRow, int endRow, int target)
    // {
    // if (startRow > endRow) {
    // return endRow;
    // }
    // int midRow = (startRow + endRow) / 2;
    // if (mat[midRow][0] == target) {
    // return midRow;
    // }
    // if (mat[midRow][0] > target) {
    // return findRow(mat, startRow, midRow - 1, target);
    // } else {
    // return findRow(mat, midRow + 1, endRow, target);
    // }
    // }

    // public static boolean findCol(int mat[][], int row, int startCol, int endCol,
    // int target) {
    // if (startCol > endCol) {
    // return false;
    // }
    // int mid = (startCol + endCol) / 2;
    // if (mat[row][mid] == target) {
    // return true;
    // }
    // if (mat[row][mid] > target) {
    // return findCol(mat, row, startCol, mid - 1, target);
    // } else {
    // return findCol(mat, row, mid + 1, endCol, target);
    // }
    // }

    public static boolean findTargetElement(int mat[][], int startRow, int endRow, int startCol, int endCol,
            int target) {
        if (startRow > endRow || startCol > endCol) {
            return false;
        }
        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;
        if (mat[midRow][midCol] == target) {
            return true;
        }
        if (mat[midRow][midCol] > target) {
            return findTargetElement(mat, midRow, midRow, startCol, midCol - 1, target)
                    || findTargetElement(mat, startRow, midRow - 1, startCol, endCol, target);
        } else {
            return findTargetElement(mat, midRow, midRow, midCol + 1, endCol, target)
                    || findTargetElement(mat, midRow + 1, endRow, startCol, endCol, target);
        }
    }

    public static boolean findTargetElement(int mat[][], int target) {
        int curRow = 0;
        int curCol = mat[0].length - 1;
        while (curRow < mat.length && curCol >= 0) {
            if (mat[curRow][curCol] == target) {
                return true;
            } else if (mat[curRow][curCol] < target) {
                curRow++;
            } else {
                curCol--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 } };
        int x = 14;
        // int row = findRow(mat, 0, mat.length - 1, x);
        // if (row < 0 || row > mat.length - 1) {
        // return false;
        // }
        // return findCol(mat, row, row, x, row)
        // System.out.println(findTargetElement(mat, 0, mat.length - 1, 0, mat[0].length
        // - 1, x));
        System.out.println(findTargetElement(mat, x));

    }

}
