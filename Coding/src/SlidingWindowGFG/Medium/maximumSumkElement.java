package SlidingWindowGFG.Medium;

public class maximumSumkElement {

    public static int langestSubArray(int arr[], int k) {

        int left = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentWindowSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentWindowSum = currentWindowSum + arr[i];
            if (currentWindowSum < arr[i]) {
                if (i - left + 1 >= k) {
                    maxSum = Math.max(maxSum, currentWindowSum);
                }
                left = i;
                currentWindowSum = arr[i];

            }
            if (i - left + 1 >= k) {
                maxSum = Math.max(maxSum, currentWindowSum);
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 5, -6, -2, 8, -10, -9, -9, -8, 4, 3 }, k = 9;
        System.out.println(langestSubArray(arr, k));
    }

}
