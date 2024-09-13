package top150InterviewProblem.slidingWindow;

public class maximumPoint {

    public static int findMaxSum(int arr[], int k) {
        int left = 0;
        int right = arr.length - 1;
        int sum = 0;
        while (left < k && left < arr.length) {
            sum += arr[left++];
        }
        int maxSum = sum;
        while (left > 0 && right > 0) {
            sum -= arr[--left];
            sum += arr[right--];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int arr[] = { 6, 2, 3, 4, 7, 2, 1, 7, 1 };
        int k = 4;
        System.out.println(findMaxSum(arr, k));

    }

}
