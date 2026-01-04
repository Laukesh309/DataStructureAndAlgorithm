package BinarySearchRevision;

public class AllocatePages {

    public static int checkFeasiblity(int arr[], int k, int maxRange) {
        int count = 1;
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxValue = maxValue + arr[i];
            if (maxValue > maxRange) {
                maxValue = arr[i];
                count++;
            }
        }
        return count;
    }

    public static int findMin(int arr[], int k, int start, int end) {
        if (start > end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (checkFeasiblity(arr, k, mid) > k) {
            return findMin(arr, k, mid + 1, end);
        } else {
            return findMin(arr, k, start, mid - 1);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 }, k = 2;
        int minValue = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            minValue = Math.max(minValue, arr[i]);
            total = total + arr[i];
        }
        System.out.println(findMin(arr, k, minValue, total));
        System.out.println("this is latest---->");

    }
}
