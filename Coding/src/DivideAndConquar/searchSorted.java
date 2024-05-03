package DivideAndConquar;

public class searchSorted {

    public static int searchIndex(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && target < arr[mid]) {
                return searchIndex(arr, start, mid - 1, target);
            } else {
                return searchIndex(arr, mid + 1, end, target);
            }

        } else {
            if (arr[mid] <= target && target <= arr[end]) {
                return searchIndex(arr, mid + 1, end, target);
            } else {
                return searchIndex(arr, start, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int index = searchIndex(arr, 0, arr.length - 1, target);
        if (index == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("FoundAtIndex" + index);
        }

    }

}
