package array;

// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1288282260/
///decrease space 

public class searchInRotated {

    public static int findNumberIndex(int arr[], int targetElement) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == targetElement) {
                return mid;
            }
            if (targetElement >= arr[0]) {
                if (targetElement > arr[mid] && arr[mid] >= arr[0]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (targetElement <= arr[end] && targetElement > arr[mid]) {
                    start = mid + 1;
                } else if (arr[mid] > arr[end]) {
                    start = mid + 1;
                } else {
                    end = end - 1;
                }
            }
        }
        return -1;

    }

    public static int findIndexSecondApproach(int arr[], int targetElement) {
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
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        // int arr[] = { 5, 1, 2 };
        int target = 0;
        System.out.println(findNumberIndex(arr, target));
    }

}
