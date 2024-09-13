package Sheet.Array.medium;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class bestTimeToBuyAndSell {
    public static void printData(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findMaxValue(int arr[]) {
        int result[] = new int[arr.length];
        int maximumValue = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maximumValue) {
                maximumValue = arr[i];
            }
            result[i] = maximumValue;
        }
        printData(result);
        int maxDifference = 0;
        for (int i = 0; i < arr.length; i++) {
            maxDifference = Math.max(maxDifference, result[i] - arr[i]);
        }
        return maxDifference;
    }

    // best implementation
    public static int findmaxValueSecond(int arr[]) {
        int maxValue = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
            maxProfit = Math.max(maxProfit, maxValue - arr[i]);
        }
        return maxProfit;
    }

    ///// best solution22
    public static int getMaxProfitByRecursion(int arr[], int currentIndex, int minValue) {
        if (currentIndex >= arr.length) {
            return 0;
        }
        int min = Math.min(minValue, arr[currentIndex]);
        int profit = arr[currentIndex] - min;
        if (profit > 0) {
            return Math.max(profit, getMaxProfitByRecursion(arr, currentIndex + 1, min));
        } else {
            return getMaxProfitByRecursion(arr, currentIndex + 1, min);
        }
    }

    public static int findMaxProfit(int arr[]) {
        int maxProfit = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            maxValue = Math.max(maxValue, arr[i]);
            maxProfit = Math.max(maxProfit, maxValue - arr[i]);

        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] <= maxValue) {
                maxProfit = Math.max(maxProfit, maxValue - prices[i]);
            } else {
                maxValue = prices[i];
            }
        }
        if (maxProfit == Integer.MIN_VALUE) {
            return 0;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 4, 3, 1 };
        System.out.println(findmaxValueSecond(arr));
        System.out.println(getMaxProfitByRecursion(arr, 0, Integer.MAX_VALUE));

    }
}
