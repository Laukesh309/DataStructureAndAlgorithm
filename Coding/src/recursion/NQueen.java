package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void printArray(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("======>");
    }

    public static boolean checkSafe(String arr[][], int row, int column) {
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][column] == "Q") {
                return false;
            }
        }
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == "Q") {
                return false;
            }
        }
        for (int i = row - 1, j = column + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == "Q") {
                return false;
            }
        }
        return true;

    }

    public static int findSolution(String arr[][], int row, int column, List<List<String>> finalResult) {
        if (row >= arr.length) {
            return 1;
        }

        int totalResult = 0;
        for (int i = 0; i < column; i++) {
            if (checkSafe(arr, row, i)) {
                arr[row][i] = "Q";
                totalResult = totalResult + findSolution(arr, row + 1, column, finalResult);
                arr[row][i] = ".";
            }

        }
        return totalResult;
    }

    public static void main(String[] args) {
        int n = 1;
        String arr[][] = new String[n][n];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr.length; column++) {
                arr[row][column] = ".";
            }
        }
        List<List<String>> finalResult = new ArrayList<>();
        // findSolution(arr, 0, n, finalResult);
        System.out.println(findSolution(arr, 0, n, finalResult));

    }

}
