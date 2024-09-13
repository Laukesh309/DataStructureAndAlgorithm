package Sheet.Array.medium;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150

public class buySellStocksecond {

    public static int findMaxValue(int arr[], int minValue, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }
        int min = Math.min(minValue, arr[startIndex]);
        int profit = arr[startIndex] - min;
        if (profit > 0) {
            int withoutSell = findMaxValue(arr, min, startIndex + 1, endIndex);
            int withSell = profit + findMaxValue(arr, Integer.MAX_VALUE, startIndex + 1, endIndex);
            return Math.max(withSell, withoutSell);
        } else {
            return findMaxValue(arr, min, startIndex + 1, endIndex);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 4, 3, 1 };
        System.out.println(findMaxValue(arr, Integer.MAX_VALUE, 0, arr.length - 1));
    }

}
