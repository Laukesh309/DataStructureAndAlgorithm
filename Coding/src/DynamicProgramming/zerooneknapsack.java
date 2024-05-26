package DynamicProgramming;

import java.util.ArrayList;

public class zerooneknapsack {

    public static int findMaxValue(int value[], int weight[], int currentWeight, int currentIndex) {
        if (currentIndex < 0) {
            return 0;
        }
        if (currentWeight == 0) {
            return 0;
        }
        if (weight[currentIndex] <= currentWeight) {
            return Math.max(findMaxValue(value, weight, currentWeight, currentIndex - 1), value[currentIndex] +
                    findMaxValue(value, weight, currentWeight - weight[currentIndex], currentIndex - 1));
        } else {
            return findMaxValue(value, weight, currentWeight, currentIndex - 1);
        }

    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMaxValueByTabulisation(int value[], int weigh[], int totalWeight) {
        int row = weigh.length;
        int column = totalWeight;
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (weigh[i - 1] <= j) {
                    int includeValue = value[i - 1] + dp[i - 1][j - weigh[i - 1]];
                    int excliudeValue = dp[i - 1][j];
                    dp[i][j] = Math.max(includeValue, excliudeValue);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        printDp(dp);
        return dp[row][column];
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weigh[] = { 2, 5, 1, 3, 4 };
        int totalWight = 7;
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(findMaxValue(value, weigh, totalWight, value.length - 1));
        System.out.println(findMaxValueByTabulisation(value, weigh, totalWight));
    }

}
