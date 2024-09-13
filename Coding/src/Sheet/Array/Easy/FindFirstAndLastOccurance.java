package Sheet.Array.Easy;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class FindFirstAndLastOccurance {

    public static int findRightIndex(int arr[], int start, int end, int target, int result) {
        if (start > end) {
            return result;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return findRightIndex(arr, mid + 1, end, target, mid);
        }
        if (arr[mid] > target) {
            return findRightIndex(arr, start, mid - 1, target, result);
        } else {
            return findRightIndex(arr, mid + 1, end, target, result);
        }
    }

    public static int findLeftOccurance(int arr[], int start, int end, int target, int result) {
        if (start > end) {
            return result;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return findLeftOccurance(arr, start, mid - 1, target, mid);
        }
        if (arr[mid] > target) {
            return findLeftOccurance(arr, start, mid - 1, target, result);
        } else {
            return findLeftOccurance(arr, mid + 1, end, target, result);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int target = 6;
        int result1[] = new int[2];
        int leftIndex = findLeftOccurance(arr, 0, arr.length - 1, target, -1);
        int rightIndex = findRightIndex(arr, 0, arr.length - 1, target, -1);
        System.out.println(leftIndex + " " + rightIndex);

    }

}
