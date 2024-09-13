package Sheet.Array.Easy;

public class searchInRotatedArray {

    public static int findBinarySearch(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return findBinarySearch(arr, start, mid - 1, target);
        } else {
            return findBinarySearch(arr, mid + 1, end, target);
        }
    }

    public static int findPivotIndex(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] >= arr[0]) {
            if (target <= arr[mid] && target >= arr[0]) {
                return findBinarySearch(arr, 0, mid, target);
            } else {
                return findPivotIndex(arr, mid + 1, end, target);
            }

        } else {
            if (target >= arr[mid] && target <= arr[end]) {
                return findBinarySearch(arr, start, end, target);
            } else {
                return findPivotIndex(arr, start, mid - 1, target);
            }

        }
    }

    public int search(int[] arr, int targetElement) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == targetElement) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= targetElement && targetElement < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (targetElement > arr[mid] && targetElement <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1 };
        System.out.println(findPivotIndex(arr, 0, arr.length - 1, 0));

    }

}
