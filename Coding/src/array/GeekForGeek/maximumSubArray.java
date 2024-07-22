package array.GeekForGeek;

public class maximumSubArray {

    // public static int findMaxValue(int arr[]) {
    // int start = 0;
    // int currentSum = 0;
    // int maximumSum = Integer.MIN_VALUE;
    // while (start < arr.length) {
    // maximumSum = Math.max(arr[start], maximumSum);
    // start++;
    // }
    // if (maximumSum < 0) {
    // return maximumSum;
    // }
    // maximumSum = Integer.MIN_VALUE;
    // start = 0;
    // while (start < arr.length) {
    // currentSum += arr[start];
    // if (currentSum < 0) {
    // currentSum = 0;
    // }
    // maximumSum = Math.max(currentSum, maximumSum);
    // start++;
    // }

    // return maximumSum;

    // }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(findMaxValue(arr));

    }

}
