package SlidingWindowGFG.Easy;

public class maximumSubArraySizeK {

    public static int findMaxValue(int arr[], int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (right < k) {
            sum = sum + arr[right++];
        }
        maxSum = sum;
        while (right < arr.length) {
            sum = sum + arr[right++] - arr[left++];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 200, 300, 400 };
        int k = 1;
        System.out.println(findMaxValue(arr, k));

    }

}
