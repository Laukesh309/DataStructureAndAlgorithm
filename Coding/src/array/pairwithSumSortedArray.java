package array;

public class pairwithSumSortedArray {

    public static int findPivotIndex(int arr[], int pivotIndex, int start, int end) {
        System.out.println(pivotIndex);
        if (start > end) {
            return pivotIndex;
        }
        int mid = (start + end) / 2;
        if (arr[mid] >= arr[0]) {
            return findPivotIndex(arr, mid, mid + 1, end);
        } else {
            return findPivotIndex(arr, pivotIndex, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 11, 15, 6, 8, 9, 10 };
        int targetElement = 16;
        int pivotIndex = findPivotIndex(arr, 0, 0, arr.length - 1);
        System.out.println(pivotIndex);
    }

}
