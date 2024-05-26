package DynamicProgramming;

public class coinChanges {

    public static int findTotalWays(int num[], int totalSum, int currentIndex, String result) {
        if (totalSum == 0) {
            System.out.println(result);
            return 1;
        }
        if (totalSum < 0 || currentIndex >= num.length) {
            return 0;
        }
        if (num[currentIndex] <= totalSum) {
            int totalIncludedWays = findTotalWays(num, totalSum - num[currentIndex], currentIndex,
                    result + num[currentIndex]);
            int excludedWays = findTotalWays(num, totalSum, currentIndex + 1, result);
            return totalIncludedWays + excludedWays;
        } else {
            return findTotalWays(num, totalSum, currentIndex + 1, result);
        }
    }

    public static int findTabulisation(int num[], int totalSum) {
        int row = num.length;
        int column = totalSum;
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (num[i - 1] <= j) {
                    dp[i][j] = dp[i][j - num[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        // int num[] = { 1, 2, 3 };
        // int totalSum = 4;
        int num[] = { 2, 5, 3, 6 };
        int totalSum = 10;
        System.out.println(findTotalWays(num, totalSum, 0, ""));
        System.out.println(findTabulisation(num, totalSum));

    }

}
