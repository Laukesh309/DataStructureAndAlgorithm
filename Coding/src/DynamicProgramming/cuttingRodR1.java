package DynamicProgramming;

public class cuttingRodR1 {

    public static int findMaxValue(int length[], int price[], int totalRodLength, String result, int currentIndex) {

        if (totalRodLength <= 0 || currentIndex >= length.length) {
            return 0;
        }
        if (length[currentIndex] <= totalRodLength) {
            int includedValue = price[currentIndex] + findMaxValue(length, price, totalRodLength - length[currentIndex],
                    result + length[currentIndex], currentIndex);
            int excliudeValue = findMaxValue(length, price, totalRodLength, result, currentIndex + 1);
            return Math.max(includedValue, excliudeValue);
        } else {
            return findMaxValue(length, price, totalRodLength, result, currentIndex + 1);
        }

    }

    public static int findMaxValueByTabulisation(int length[], int price[], int totalLength) {
        int row = price.length;
        int column = totalLength;
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (length[i - 1] <= j) {
                    int includedValue = price[i - 1] + dp[i][j - length[i - 1]];
                    int excliudeValue = dp[i - 1][j];
                    dp[i][j] = Math.max(includedValue, excliudeValue);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totalRodLength = 8;
        System.out.println(findMaxValue(length, price, totalRodLength, "", 0));
        System.out.println(findMaxValueByTabulisation(length, price, totalRodLength));
    }

}
