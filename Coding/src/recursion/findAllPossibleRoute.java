package recursion;

public class findAllPossibleRoute {

    public static void printArrayPath(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("====>");
    }

    public static void findAllPossiblePath(int arr[][], int row, int column, int n) {

        if (row == n - 1 && column == n - 1) {
            arr[row][column] = 1;
            printArrayPath(arr);
            return;
        }
        if (row > n - 1) {
            return;
        }
        if (column > n - 1) {
            return;
        }
        arr[row][column] = 1;
        findAllPossiblePath(arr, row + 1, column, n);
        findAllPossiblePath(arr, row, column + 1, n);
        arr[row][column] = 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int arr[][] = new int[n][n];
        findAllPossiblePath(arr, 0, 0, n);
    }

}
