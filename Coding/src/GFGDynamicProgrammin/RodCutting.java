package GFGDynamicProgrammin;

public class RodCutting {

    public static int findMax(int arr[], int currentIndex, int target) {
        if (target <= 0 || currentIndex > arr.length) {
            return 0;
        }
        int include = 0;
        if (target >= currentIndex) {
            include = arr[currentIndex - 1] + findMax(arr, currentIndex, target - currentIndex);
        }
        int exclude = findMax(arr, currentIndex + 1, target);
        return Math.max(include, exclude);
    }

    public static int findMaxCut(int arr[]) {
        int capacity = arr.length + 1;
        int dp[][] = new int[arr.length + 1][capacity];
        for (int row = 1; row < arr.length + 1; row++) {
            for (int col = 1; col < arr.length + 1; col++) {
                int include = 0;
                if (col >= row) {
                    include = arr[row - 1] + dp[row][col - row];
                }
                int exclude = dp[row - 1][col];
                dp[row][col] = Math.max(include, exclude);
            }
        }
        return dp[arr.length][arr.length];
    }

    public static int findMaxCut1(int arr[]) {
        int dp[] = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j > 0; j--) {
                maxValue = Math.max(maxValue, arr[j - 1] + dp[i - j]);
            }
            dp[i] = maxValue;
        }
        return dp[arr.length];
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(findMax(price, 1, price.length));
        System.out.println(findMaxCut(price));
        findMaxCut1(price);
    }

}
