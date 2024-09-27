package top150InterviewProblem.Array;

public class buyAndSellProblemSec {

    public static int findMaxProfit(int arr[], int start, int buy, int profit) {
        if (start >= arr.length) {
            return profit;
        }
        if (buy == 0) {
            int currBuy = findMaxProfit(arr, start + 1, arr[start], profit);
            int notBuy = findMaxProfit(arr, start + 1, 0, profit);
            return Math.max(currBuy, notBuy);
        } else {
            int currentProfit = arr[start] - buy;
            int currentSell = findMaxProfit(arr, start + 1, 0, currentProfit);
            int currentNotSell = findMaxProfit(arr, start + 1, buy, profit);
            return Math.max(currentNotSell, currentSell);
        }

    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(findMaxProfit(prices, 0, 0, 0));

    }

}
