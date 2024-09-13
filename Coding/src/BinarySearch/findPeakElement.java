package BinarySearch;

public class findPeakElement {

    public static int findPeakIndex(int arr[], int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid == 0)
            if (mid == arr.length - 1 && arr[mid] > arr[mid - 1]) {

            }
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return mid;
        }
        if (arr[mid] > arr[mid - 1]) {
            return findPeakIndex(arr, mid + 1, end);
        }
        if (arr[mid] < arr[mid - 1]) {
            return findPeakIndex(arr, start, mid - 1);
        }
        return -1;

    }

    public static void main(String[] args) {
        int arr[] = { 5, 10, 20, 15 };
        int peakIndex = findPeakIndex(arr, 0, arr.length - 1);
        System.out.println(peakIndex);
    }

}
