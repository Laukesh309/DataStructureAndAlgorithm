package DynamicProgramming;

public class TargetSumSubsetImp {

    public static boolean isValid(int number[], int targetSum, int currentIndex, String result) {
        if (targetSum == 0) {
            System.out.println(result);
            return true;
        }
        if (currentIndex >= number.length || targetSum < 0) {
            return false;
        }
        boolean isIncluded = isValid(number, targetSum - number[currentIndex], currentIndex + 1,
                result + number[currentIndex]);
        boolean isExcluded = isValid(number, targetSum, currentIndex + 1, result);
        return isIncluded || isExcluded;

    }

    public static boolean isValidMemoization(int number[], int targetSum, int currentIndex, boolean dp[][]) {

        if (targetSum == 0) {
            // printDp(dp);
            System.out.println();
            System.out.println();
            return true;
        }
        if (currentIndex >= number.length || targetSum < 0) {
            return false;
        }
        boolean isIncluded = isValidMemoization(number, targetSum - number[currentIndex], currentIndex + 1, dp);
        boolean isExcluded = isValidMemoization(number, targetSum, currentIndex + 1, dp);
        dp[currentIndex][targetSum] = isExcluded || isIncluded;
        printDp(dp);
        System.out.println(currentIndex + " " + targetSum);
        return dp[currentIndex][targetSum];

    }

    public static void printDp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValidTabulisation(int number[], int targetSum) {
        int n = number.length;
        boolean dp[][] = new boolean[n + 1][targetSum + 1];
        for (int i = 0; i < targetSum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                int currentNumber = number[i - 1];
                if (currentNumber <= j && dp[i - 1][j - currentNumber] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        printDp(dp);
        return dp[n][targetSum];

    }

    public static void main(String[] args) {
        int number[] = { 4, 2, 7, 1, 3 };
        int targetSum = 10;
        String result = "";

        // System.out.println(isValid(number, targetSum, 0, result));
        // System.out.println(isValidMemoization(number, targetSum, 0, dp));
        // printDp(dp);
        isValidTabulisation(number, targetSum);
    }

}
