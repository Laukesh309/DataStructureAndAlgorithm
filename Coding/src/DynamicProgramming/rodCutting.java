package DynamicProgramming;

public class rodCutting {

    public static int findMaximumProfitOfRod(int rodlength[], int price[], int totalRodLenght) {
        int n = rodlength.length;
        int dp[][] = new int[n + 1][totalRodLenght + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= totalRodLenght; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalRodLenght; j++) {
                if (rodlength[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - rodlength[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totalRodLenght];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;
        System.out.println(findMaximumProfitOfRod(length, price, rodLength));
    }

}
