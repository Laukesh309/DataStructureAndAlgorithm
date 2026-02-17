package GFGDynamicProgrammin;

public class knapsackProblem {

    public static int findMaxValue(int val[], int weight[], int capacity, int currentIndex) {
        if (capacity == 0 || currentIndex >= val.length) {
            return 0;
        }
        int exclude = findMaxValue(val, weight, capacity, currentIndex + 1);
        int include = Integer.MIN_VALUE;
        if (weight[currentIndex] <= capacity) {
            include = val[currentIndex] + findMaxValue(val, weight, capacity - weight[currentIndex], currentIndex + 1);
        }
        return Math.max(exclude, include);

    }

    public static void printArray(int dp[][]) {
        for (int[] is : dp) {
            for (int item : is) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static int fidnMax(int val[], int weight[], int capacity) {
        int dp[][] = new int[weight.length + 1][capacity + 1];
        for (int row = 1; row < weight.length + 1; row++) {
            for (int col = 1; col < capacity + 1; col++) {
                dp[row][col] = dp[row - 1][col];
                if (weight[row - 1] <= col) {
                    dp[row][col] = Math.max(dp[row][col], val[row - 1] + dp[row - 1][col - weight[row - 1]]);
                }
            }
        }
        return dp[weight.length][capacity];
    }

    public static void main(String[] args) {
        int W = 4;
        int val[] = { 1, 2, 3 }, wt[] = { 4, 5, 1 };
        System.out.println(findMaxValue(val, wt, W, 0));
        System.out.println(fidnMax(val, wt, W));
    }

}
