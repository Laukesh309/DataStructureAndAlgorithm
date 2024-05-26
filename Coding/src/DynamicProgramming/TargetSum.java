package DynamicProgramming;

import Stack.pushBottom;

public class TargetSum {

    public static int findTotalNumberOfSubSet(int number[], int totalNumber, int currentIndex, String result) {
        if (totalNumber == 0) {
            System.out.println(result);
            return 1;
        }
        if (totalNumber < 0 || currentIndex >= number.length) {
            return 0;
        }
        return findTotalNumberOfSubSet(number, totalNumber - number[currentIndex], currentIndex + 1,
                result + number[currentIndex]) + findTotalNumberOfSubSet(number, totalNumber, currentIndex + 1, result);
    }

    public static void printDp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean findTotalNumberOfSubSetByTabulisation(int number[], int targetSum) {
        int row = number.length;
        int column = targetSum;
        boolean dp[][] = new boolean[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (number[i - 1] <= j) {
                    boolean include = dp[i - 1][j - number[i - 1]];
                    boolean exclude = dp[i - 1][j];
                    dp[i][j] = include || exclude;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDp(dp);
        return dp[row][column];
    }

    public static void main(String[] args) {
        // int number[] = { 1, 2, 3 };
        int number[] = { 4, 2, 7, 1, 3 };
        int totalNumber = 10;
        System.out.println(findTotalNumberOfSubSet(number, totalNumber, 0, ""));
        System.out.println(findTotalNumberOfSubSetByTabulisation(number, totalNumber));

    }

}
