package array.GeekForGeek;

public class smallestSubArraySumGreaterthanGiven {

    public static int findsmallest(int arr[], int k) {
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (end < arr.length) {
            if (sum + arr[end] > k) {
                result = Math.min(end - start + 1, result);
                sum = sum - arr[start++];
            } else {
                sum += arr[end++];
            }
        }

        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;

    }

    public static void main(String[] args) {
        // int arr[] = { 1, 4, 45, 6, 0, 19 };
        // int k = 51;
        // int arr[] = { 1, 10, 5, 2, 7 };
        // int k = 9;
        int arr[] = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
        int k = 280;
        System.out.println(findsmallest(arr, k));
    }

}
