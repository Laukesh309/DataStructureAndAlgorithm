package DivideAndConquareRevision;

public class searchInRotatedArray {

    public static int findIndex(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        System.out.println(start + " " + end);
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] >= arr[start]) {
            if (target >= arr[start] && target < arr[mid]) {
                return findIndex(arr, start, mid - 1, target);
            } else {
                return findIndex(arr, mid + 1, end, target);
            }
        } else {
            if (target > arr[mid] && target <= arr[end]) {
                return findIndex(arr, mid + 1, end, target);
            } else {
                return findIndex(arr, start, mid, target);
            }
        }

    }

    public static int findPivotElement(int arr[], int start, int last) {
        if (start == last) {
            return start;
        }
        int mid = (start + last) / 2;
        if (arr[mid] > arr[last]) {
            return findPivotElement(arr, mid + 1, last);
        } else {
            return findPivotElement(arr, start, mid);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 4, 5, 1 };
        int target = 4;
        // System.out.println(findIndex(arr, 0, arr.length - 1, target));
        System.out.println(findPivotElement(arr, 0, arr.length - 1));
    }

}
