package Sheet.Array.medium;

public class findMinimumInSortedRotatedArray {

    public static int findMinimum(int arr[], int start, int end) {

        if (start >= end) {
            return arr[end];
        }
        int mid = (start + end) / 2;
        if (arr[mid] < arr[end]) {
            return findMinimum(arr, start, mid);
        } else {
            return findMinimum(arr, mid + 1, end);
        }
    }

    // public int findMin(int[] arr) {
    // int start = 0;
    // int end = arr.length - 1;

    // while (start < end) {
    // int mid = (start + end) / 2;
    // if (arr[mid] > arr[end]) {
    // start = mid + 1;
    // } else {
    // end = mid;
    // }
    // }
    // return arr[start];
    // }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println(findMinimum(arr, 0, arr.length - 1));
    }

}
