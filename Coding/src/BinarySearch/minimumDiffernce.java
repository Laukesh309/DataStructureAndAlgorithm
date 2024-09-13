package BinarySearch;

public class minimumDiffernce {
    public static int findCeilElement(int arr[], int target, int start, int end, int result) {
        if (start > end) {
            return result;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return findCeilElement(arr, target, start, mid - 1, mid);
        } else {
            return findCeilElement(arr, target, mid + 1, end, result);
        }
    }

    public static int findFloorIndex(int arr[], int target, int start, int end, int result) {
        if (start > end) {
            return result;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return findFloorIndex(arr, target, mid + 1, end, mid);
        } else {
            return findFloorIndex(arr, target, start, mid - 1, result);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 6, 10 };
        int target = 7;
        int floorIndex = findFloorIndex(arr, target, 0, arr.length - 1, -1);
        int ceilIndex = findCeilElement(arr, target, 0, arr.length - 1, arr.length);
        int difference = Math.min(Math.abs(target - arr[floorIndex]), Math.abs(target - arr[ceilIndex]));
        System.out.println(difference);
    }

}
