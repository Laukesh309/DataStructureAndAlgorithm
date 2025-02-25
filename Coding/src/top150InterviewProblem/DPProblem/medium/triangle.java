package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class triangle {

    public static int findMinDifference(List<List<Integer>> triangle, int row, int column, int minSum) {
        if (row >= triangle.size()) {
            return minSum;
        }

        int sameIndex = findMinDifference(triangle, row + 1, column, minSum + triangle.get(row).get(column));
        int otherIndex = findMinDifference(triangle, row + 1, column + 1, minSum + triangle.get(row).get(column));
        return Math.min(sameIndex, otherIndex);

    }

    public static void printArray(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMinDifferenceDynamic(List<List<Integer>> triangle) {
        int row = triangle.size() + 1;
        int coloumn = triangle.size();
        int dp[][] = new int[row][coloumn];

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i - 1).get(j) + dp[i - 1][j];
                } else if ((i - 1) == j) {
                    dp[i][j] = triangle.get(i - 1).get(j) + dp[i - 1][j - 1];
                } else {

                    dp[i][j] = triangle.get(i - 1).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }

            }
        }
        int result = dp[row - 1][0];
        for (int i = 0; i < coloumn; i++) {
            result = Math.min(result, dp[row - 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[][] = { { -10 } };
        List<List<Integer>> triangle = new ArrayList<>(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)));
        // System.out.println(findMinDifference(triangle, 0, 0, 0));
        System.out.println(findMinDifferenceDynamic(triangle));
    }

}
