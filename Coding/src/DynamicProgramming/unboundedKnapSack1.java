package DynamicProgramming;

public class unboundedKnapSack1 {

    public static int findMaxRecustive(int val[], int weight[], int totalWeight, int currentIndex) {
        if (totalWeight < 0 || currentIndex >= val.length) {
            return 0;
        }
        if (weight[currentIndex] <= totalWeight) {
            int includeValue = val[currentIndex]
                    + findMaxRecustive(val, weight, totalWeight - weight[currentIndex], currentIndex);
            int secondValue = val[currentIndex]
                    + findMaxRecustive(val, weight, totalWeight - weight[currentIndex], currentIndex + 1);
            int excludeValue = findMaxRecustive(val, weight, totalWeight, currentIndex + 1);
            return Math.max(Math.max(includeValue, secondValue), excludeValue);
        } else {
            return findMaxRecustive(val, weight, totalWeight, currentIndex + 1);
        }

    }

    public static int findMaxTabulisation(int val[], int weight[], int totalSum) {
        int n = val.length;
        int dp[][] = new int[n + 1][totalSum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalSum; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                if (weight[i - 1] <= j) {
                    int include = val[i - 1] + dp[i][j - weight[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][totalSum];
    }

    public static void main(String[] args) {

        int val[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int totalWeight = 7;
        System.out.println(findMaxRecustive(val, weight, totalWeight, 0));
        System.out.println(findMaxTabulisation(val, weight, totalWeight));
    }

}
