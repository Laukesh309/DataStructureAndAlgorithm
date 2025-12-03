package SlidingWindow;

public class BinarySumSubArray {

    public static int findTotalCount(int arr[], int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int totalCount = 0;
        while (right < arr.length) {
            sum = sum + arr[right];
            while (sum > target) {
                sum = sum - arr[left];
                left++;
            }
            totalCount = totalCount + right - left + 1;
            right++;
        }
        return totalCount;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, };
        int target = 5;
        int num1 = findTotalCount(arr, target);
        int num2 = findTotalCount(arr, target - 1);

    }

}
