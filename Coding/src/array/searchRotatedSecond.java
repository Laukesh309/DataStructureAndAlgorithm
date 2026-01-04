package array;

public class searchRotatedSecond {

    public static boolean findPresent(int arr[], int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return true;
        }
        if (arr[mid] == arr[start]) {
            return findPresent(arr, target, start, mid - 1) || findPresent(arr, target, mid + 1, end);
        }
        if (arr[mid] > arr[start]) {
            if (target >= arr[start] && target < arr[mid]) {
                return findPresent(arr, target, start, mid - 1);
            } else {
                return findPresent(arr, target, mid + 1, end);
            }
        } else {
            if (target <= arr[end] && target > arr[mid]) {
                return findPresent(arr, target, mid + 1, end);
            } else {
                return findPresent(arr, target, start, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 1, 1 };
        int key = 0;
        System.out.println(findPresent(arr, key, 0, arr.length - 1));
    }

}
