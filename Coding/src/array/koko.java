package array;

import java.util.Arrays;

public class koko {

    public static boolean isFullFilled(int arr[], int k, int mid) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentNo = arr[i];
            ans = ans + (int) Math.ceil((double) currentNo / mid);
            System.out.println(ans + " " + currentNo + " " + mid);
        }

        if (ans <= k) {
            return true;
        }
        return false;
    }

    public static void findMin(int arr[], int start, int end, int k, int result[]) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        if (isFullFilled(arr, k, mid)) {
            result[0] = Math.min(result[0], mid);
            findMin(arr, start, mid - 1, k, result);
        } else {
            findMin(arr, mid + 1, end, k, result);

        }
    }

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 10, 15, 20 };
        int k = 7;
        Arrays.sort(arr);
        printArray(arr);

        int end = arr[arr.length - 1];
        int result[] = new int[1];
        result[0] = arr[arr.length - 1];
        findMin(arr, 1, end, k, result);
        System.out.println(result[0]);

    }

}
