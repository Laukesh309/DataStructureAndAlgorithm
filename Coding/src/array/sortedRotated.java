package array;

public class sortedRotated {

    public static int findIndex(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] >= arr[start]) {
            if (target >= arr[start] && arr[mid] > target) {
                return findIndex(arr, start, mid - 1, target);
            } else {
                return findIndex(arr, mid + 1, end, target);
            }

        } else {
            if (target <= arr[end]) {
                return findIndex(arr, mid + 1, end, target);
            } else {
                return findIndex(arr, start, mid - 1, target);
            }

        }

    }

    public static void main(String[] args) {
        int array[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int target = 10;
        System.out.println(findIndex(array, 0, array.length - 1, target));
    }

}
