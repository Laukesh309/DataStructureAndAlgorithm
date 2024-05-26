package DynamicProgramming;

public class unboundedKnapSackR1 {

    public static int findTotalMaximumWeight(int value[], int weight[], int totalWeight, int currentIndex) {
        if (totalWeight <= 0 || currentIndex >= weight.length) {
            return 0;
        }
        if (weight[currentIndex] <= totalWeight) {
            int includeValue = value[currentIndex]
                    + findTotalMaximumWeight(value, weight, totalWeight - weight[currentIndex], currentIndex);
            int exclude = findTotalMaximumWeight(value, weight, totalWeight, currentIndex + 1);
            return Math.max(includeValue, exclude);
        } else {
            return findTotalMaximumWeight(value, weight, totalWeight, currentIndex + 1);
        }
    }

    public static int findMaxProfit(int value[], int weight[], int targetWeight) {
        int row = weight.length;
        int column = targetWeight;
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (weight[i - 1] <= j) {
                    int includeValue = value[i - 1] + dp[i][j - weight[i - 1]];
                    int excliudeValue = dp[i - 1][j];
                    dp[i][j] = Math.max(includeValue, excliudeValue);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int totalWeight = 7;
        System.out.println(findTotalMaximumWeight(value, weight, totalWeight, 0));
        System.out.println(findMaxProfit(value, weight, totalWeight));

    }

}
