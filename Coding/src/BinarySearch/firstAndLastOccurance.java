package BinarySearch;

public class firstAndLastOccurance {
    public static int findLastOccurance(int arr[], int target, int start, int end, int ans) {
        if (start > end) {
            return ans;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return findLastOccurance(arr, target, mid + 1, end, mid);
        }
        if (arr[mid] > target) {
            return findLastOccurance(arr, target, start, mid - 1, ans);
        } else {
            return findLastOccurance(arr, target, mid + 1, end, ans);
        }

    }

    public static int findFirstOccurance(int arr[], int target, int start, int end, int ans) {
        if (start > end) {
            return ans;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return findFirstOccurance(arr, target, start, mid - 1, mid);
        }
        if (arr[mid] > target) {
            return findFirstOccurance(arr, target, start, mid - 1, ans);
        } else {
            return findFirstOccurance(arr, target, mid + 1, end, ans);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 10, 10, 10, 10, 18, 20 };
        int target = 2;
        int firstIndex = findFirstOccurance(arr, target, 0, arr.length - 1, -1);
        int lastIndex = findLastOccurance(arr, target, 0, arr.length - 1, -1);
        if (firstIndex != -1) {
            System.out.println("FirstOccurance-->" + firstIndex);
        }
        if (lastIndex != -1) {
            System.out.println("LastIndex---> " + lastIndex);
        }

    }

}
