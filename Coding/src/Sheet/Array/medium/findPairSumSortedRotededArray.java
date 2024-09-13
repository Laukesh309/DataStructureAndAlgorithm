package Sheet.Array.medium;

public class findPairSumSortedRotededArray {

    public static int findPivotIndex(int arr[], int start, int end) {
        if (start > end) {
            return end;
        }
        int mid = (start + end) / 2;
        if (arr[mid] >= arr[0]) {
            return findPivotIndex(arr, mid + 1, end);
        } else {
            return findPivotIndex(arr, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 15, 11, 10, 9, 8, 6 };
        int pivotIndex = findPivotIndex(arr, 0, arr.length - 1);
        System.out.println(pivotIndex);
    }

}
