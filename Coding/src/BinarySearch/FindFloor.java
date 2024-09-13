package BinarySearch;

public class FindFloor {

    public static int findFloor(int arr[], int start, int end, int target) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return findFloor(arr, start, mid - 1, target);
        }
        if (arr[mid] < target) {
            if ((mid + 1) <= end && arr[mid + 1] < target) {
                return findFloor(arr, mid + 1, end, target);
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static int findElementSecondWays(int arr[], int start, int end, int target, int result) {
        if (start > end) {
            return result + 1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return findElementSecondWays(arr, mid + 1, end, target, mid);
        } else {
            return findElementSecondWays(arr, start, mid - 1, target, result);
        }
    }

    public static int findCeilOfAnElement(int arr[], int start, int end, int target, int result) {
        if (start > end) {
            return result;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return findCeilOfAnElement(arr, start, mid - 1, target, mid);
        } else {
            return findCeilOfAnElement(arr, mid + 1, end, target, result);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 6 };
        int index = findFloor(arr, 0, arr.length - 1, 0);
        int index2 = findElementSecondWays(arr, 0, arr.length - 1, 4, -1);
        int index3 = findCeilOfAnElement(arr, 0, arr.length - 1, 4, arr.length);
        System.out.println(index3);

    }

}
