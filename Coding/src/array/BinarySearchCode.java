package array;

public class BinarySearchCode {

    public static int findIndex(int arr[], int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return findIndex(arr, target, mid + 1, end);
        } else {
            return findIndex(arr, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 6, 10, 12, 14 };
        int target = 6;
        System.out.println(findIndex(arr, target, 0, arr.length - 1));
    }

}
