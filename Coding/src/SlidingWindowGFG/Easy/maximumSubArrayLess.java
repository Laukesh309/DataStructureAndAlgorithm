package SlidingWindowGFG.Easy;

public class maximumSubArrayLess {

    public static long findMaximumSubArray(int arr[], int target) {
        int left = 0;
        int right = 0;
        long currentSum = 0;
        long maxSum = 0;
        while (right < arr.length) {
            currentSum = currentSum + arr[right];
            while (currentSum > target) {
                currentSum = currentSum - arr[left++];
            }
            maxSum = Math.max(maxSum, currentSum);
            right++;
        }
        System.out.println(maxSum);
        return maxSum;

    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int x = 7;
        System.out.println(findMaximumSubArray(arr, x));
    }

}
