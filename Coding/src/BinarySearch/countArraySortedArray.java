package BinarySearch;

public class countArraySortedArray {

    public static int totalElementCount(int arr[], int start, int end, int targetValue, int count) {
        if (start > end) {
            return count;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == targetValue) {
            int leftCount = totalElementCount(arr, start, mid - 1, targetValue, 0);
            int rightCount = totalElementCount(arr, mid + 1, end, targetValue, 0);
            return leftCount + rightCount + 1;
        }
        if (arr[mid] < targetValue) {
            return totalElementCount(arr, mid + 1, end, targetValue, count);
        } else {
            return totalElementCount(arr, start, mid - 1, targetValue, count);
        }

    }
    // secondApproach

    public static void main(String[] args) {
        int arr[] = { 2, 4, 10, 10, 10, 19, 20 };
        int totalCount = totalElementCount(arr, 0, arr.length - 1, 16, 0);
        System.out.println(totalCount);
    }

}
