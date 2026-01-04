
package array;

import java.util.ArrayList;

public class findFirstAndLast {

    public static void findFirstAndLast(int arr[], int x, ArrayList<Integer> result, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == x) {
            result.set(0, Math.min(result.get(0), mid));
            result.set(1, Math.max(result.get(1), mid));
            findFirstAndLast(arr, x, result, start, mid - 1);
            findFirstAndLast(arr, x, result, mid + 1, end);
            return;
        }
        if (arr[mid] > x) {
            findFirstAndLast(arr, x, result, start, mid - 1);
        } else {
            findFirstAndLast(arr, x, result, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int x = 5;
        ArrayList<Integer> result = new ArrayList<>();

        result.add(Integer.MAX_VALUE);
        result.add(Integer.MIN_VALUE);
        findFirstAndLast(arr, x, result, 0, arr.length - 1);
        if (result.get(0) == Integer.MAX_VALUE) {
            result.set(0, -1);
        }
        if (result.get(1) == Integer.MIN_VALUE) {
            result.set(1, -1);
        }
        System.out.println(result);
    }
}
