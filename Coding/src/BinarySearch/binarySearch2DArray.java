package BinarySearch;

public class binarySearch2DArray {

    public static String findTargetIndex(int arr[][], int row, int col, int target) {
        if (row < 0 || col < 0 || col > arr[0].length - 1 || row > arr.length - 1) {
            return "-1";
        }
        if (arr[row][col] == target) {
            return row + " " + col;
        }
        System.out.println(row + " " + col + " " + arr[row][col] + " " + target);
        if (arr[row][col] > target) {
            return findTargetIndex(arr, row, col - 1, target);
        } else {
            return findTargetIndex(arr, row + 1, col, target);
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        int target = 29;
        String index = findTargetIndex(arr, 0, arr[0].length - 1, target);
        System.out.println("index===>  " + index);
    }

}
