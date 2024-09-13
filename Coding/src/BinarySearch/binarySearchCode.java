package BinarySearch;

public class binarySearchCode {

    public static int binarySearch(int arr[], int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 6, 9, 10, 15, 20 };
        int targetElement = 17;
        int index = binarySearch(arr, targetElement, 0, arr.length - 1);
        if (index == -1) {
            System.out.println("No Element Exist");
        } else {
            System.out.println("Element Present At Index " + index);
        }

    }

}
