package array;

public class buyAndSell {

    public static int getMaxProfit(int arr[], int buyValue, int currentIndex, int maxProfit) {
        if (currentIndex >= arr.length) {
            System.out.println(maxProfit);
            return maxProfit;
        }
        int currentValue = arr[currentIndex];
        int profit = currentValue - buyValue;
        return getMaxProfit(arr, buyValue, currentIndex + 1, Math.max(profit, maxProfit));
    }

    public static int findMaxProfit(int arr[]) {

        int MaxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            MaxProfit = Math.max(MaxProfit, getMaxProfit(arr, arr[i], i + 1, MaxProfit));
        }
        return MaxProfit;

    }

    public static int findMaxValue(int arr[]) {
        int maxProfit = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= maxValue) {
                maxProfit = Math.max(maxProfit, maxValue - arr[i]);
            } else {
                maxValue = arr[i];
            }
        }

        if (maxProfit == Integer.MIN_VALUE) {
            return 0;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        // int arr[] = { 7, 6, 4, 3, 1 };
        int profit = findMaxProfit(arr);
        if (profit <= 0) {
            System.out.println("zero");
        } else {
            System.out.println(profit);
        }
        System.out.println(findMaxValue(arr));
    }

}
