package array.GeekForGeek;

// https://www.geeksforgeeks.org/window-sliding-technique/
public class findMaxSubArray {

    public static int findMaxValueNaiveMethod(int arr[], int k) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = 0;
            for (int j = 0; j < k; j++) {
                max += arr[i + j];
            }
            maxValue = Math.max(maxValue, max);
        }
        if (maxValue == Integer.MIN_VALUE) {
            return -1;
        }
        return maxValue;
    }

    public static int findMaxValueSlidingWindow(int arr[], int k) {
        int arrLength = arr.length;
        int start = 0;
        if (arrLength < k) {
            return -1;
        }
        int result = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            result += arr[i];
        }
        maxValue = Math.max(result, maxValue);
        for (int j = k; j < arr.length; j++) {
            result = result + arr[j] - arr[start++];
            maxValue = Math.max(maxValue, result);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        // int arr[] = { 100, 200, 300, 400 };
        // int k = 2;
        // int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        // int k = 4;

        int arr[] = { 2, 3 }, k = 2;
        System.out.println(findMaxValueNaiveMethod(arr, k));
        System.out.println(findMaxValueSlidingWindow(arr, k));

    }
}
