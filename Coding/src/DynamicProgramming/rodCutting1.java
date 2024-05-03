package DynamicProgramming;

public class rodCutting1 {

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMaxByRecursion(int length[], int price[], int totalLength, int currentIndex) {
        if (currentIndex >= price.length || totalLength <= 0) {
            return 0;
        }
        if (length[currentIndex] <= totalLength) {
            int include = price[currentIndex]
                    + findMaxByRecursion(length, price, totalLength - length[currentIndex], currentIndex);
            int exclude = findMaxByRecursion(length, price, totalLength, currentIndex + 1);
            return Math.max(include, exclude);
        } else {
            return findMaxByRecursion(length, price, totalLength, currentIndex + 1);
        }

    }

    public static int findMaxByTabulisation(int length[], int price[], int totalLength) {
        int n = price.length;
        int dp[][] = new int[n + 1][totalLength + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalLength; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalLength; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printDp(dp);
        return dp[n][totalLength];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totalLength = 8;
        System.out.println(findMaxByRecursion(length, price, totalLength, 0));
        System.out.println(findMaxByTabulisation(length, price, totalLength));
    }

}
