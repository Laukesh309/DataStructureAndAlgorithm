package TwoPointerGFG.Easy;

import java.util.Arrays;

public class DominantPair {

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int findTotalCount(int arr[]) {
        int right = arr.length / 2;
        Arrays.sort(arr, 0, right);
        Arrays.sort(arr, right, arr.length);
        int totalCount = 0;
        // printArray(arr);
        for (int i = 0; i < arr.length / 2; i++) {

            int currentValue = arr[i];
            while (right < arr.length && currentValue >= 5 * arr[right]) {
                right++;
            }
            System.out.println(totalCount);
            totalCount = totalCount + right - arr.length / 2;
        }
        System.out.println(totalCount);
        return totalCount;

    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, 2, 1 };
        findTotalCount(arr);
    }
}
