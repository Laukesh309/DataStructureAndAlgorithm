package BinarySearchRevision;

public class findMinimum {
    public static int findMinElemnt(int arr[], int start, int end) {
        if (arr[start] <= arr[end]) {
            return arr[start];
        }
        if (start == end) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (arr[mid] >= arr[start]) {
            return findMinElemnt(arr, mid + 1, end);
        } else {
            return findMinElemnt(arr, start, mid);
        }

    }

    static int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
        return low; // index of minimum element
    }

    public static void main(String[] args) {
        int arr[] = { 3, 3, 3, 3, 3, 1, 2, 3, 3 };
        System.out.println(findMinElemnt(arr, 0, arr.length - 1));
        findPivot(arr);
    }

}
