package BinarySearch;

public class serchInBiotonicArray {

    public static int findAscBinarySearch(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return findAscBinarySearch(arr, mid + 1, end, target);
        } else {
            return findAscBinarySearch(arr, start, mid - 1, target);
        }
    }

    public static int findDscBinarySearch(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return findDscBinarySearch(arr, mid + 1, end, target);
        } else {
            return findDscBinarySearch(arr, start, mid - 1, target);
        }
    }

    public static int findPeakIndex(int arr[], int start, int end) {
        if (start > end) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (mid == 0 || mid == arr.length - 1) {
            if (mid == 0) {
                return arr[0] > arr[1] ? 0 : 1;
            }
            return mid;
        }
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (arr[mid] > arr[mid - 1]) {
            return findPeakIndex(arr, mid + 1, end);
        } else {
            return findPeakIndex(arr, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 3, 8, 12, 4, 2 };
        int arr[] = { 1, 2, 3, 1 };
        int target = 0;
        int peakIndex = findPeakIndex(arr, 0, arr.length - 1);
        // int leftSearch = findAscBinarySearch(arr, 0, peakIndex, target);
        // int rightSearch = findDscBinarySearch(arr, peakIndex + 1, arr.length - 1,
        // target);
        System.out.println("PeakElement-- " + peakIndex);
        // System.out.println("LeftSearch++ " + leftSearch);
        // System.out.println("RightSearch++ " + rightSearch);

    }

}
