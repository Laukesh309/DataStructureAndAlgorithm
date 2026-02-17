package GFGDynamicProgrammin;

import java.util.Arrays;

public class MaximumLengthPair {

    public static int findMaxPair(int pairs[][], int currentIndex, int prevValue) {

        if (currentIndex >= pairs.length) {
            return 0;
        }
        int exlude = findMaxPair(pairs, currentIndex + 1, prevValue);
        int include = 0;
        if (pairs[currentIndex][0] > prevValue) {
            include = 1 + findMaxPair(pairs, currentIndex, pairs[currentIndex][1]);
        }
        return Math.max(exlude, include);

    }

    public static int findMaxPairDynamic(int pairs[][]) {
        int dp[] = new int[pairs.length];
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            int nextValue = pairs[i][0];
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                int currentValue = pairs[j][1];
                if (currentValue < nextValue) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[pairs.length - 1];
    }

    public static void main(String[] args) {
        int pairs[][] = { { 1, 2 }, { 7, 8 }, { 4, 5 } };

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        System.out.println(findMaxPair(pairs, 0, Integer.MIN_VALUE));
        System.out.println(findMaxPairDynamic(pairs));

    }

}
