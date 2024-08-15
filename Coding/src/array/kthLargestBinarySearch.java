package array;

public class kthLargestBinarySearch {

    public static int findMaxValue(int arr[]) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        return maxValue;
    }

    public static int findMinValue(int arr[]) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
        }
        return minValue;
    }

    public static int getTotalValue(int arr[], int start, int lastPointer) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= lastPointer) {
                count++;
            }
        }
        return count;
    }

    public static int getMinValue(int arr[], int start, int lastPointer) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= lastPointer) {
                minValue = Math.min(minValue, arr[i]);
            }
        }
        return minValue;
    }

    public static int getkthValue(int arr[], int min, int max, int k) {
        int mid = (min + max) / 2;
        int count = getTotalValue(arr, mid, max);
        System.out.println(count);
        if (count == k) {
            return getMinValue(arr, mid, max);
        }
        if (count < k) {
            return getkthValue(arr, min, mid, k - count);
        } else {
            return getkthValue(arr, mid, max, k);
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 3, 2, 1, 5, 6, 4 };
        int arr[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        int min = findMinValue(arr);
        int max = findMaxValue(arr);
        System.out.println(getkthValue(arr, min, max, k));
    }

}
